package net.stenyalang.parsing.impl.importing;

import net.stenyalang.parsing.ClassParser;
import net.stenyalang.parsing.SingleLineParser;
import net.stenyalang.parsing.exception.ParsingException;
import net.stenyalang.units.MultiReplacement;
import net.stenyalang.units.CodeLine;

import java.util.regex.Pattern;

/**
 * The type Import line parser.
 */
public class ImportLineParser extends SingleLineParser<String> {

    /**
     * The constant IMPORT_CONTENT.
     */
    public static final String IMPORT_CONTENT = "([A-Za-z1-9.]*\\$*)\\w";
    /**
     * The constant IMPORT_PATTERN.
     */
    public static final Pattern IMPORT_PATTERN = Pattern.compile(IMPORT_CONTENT);

    private final ClassParser classParser;

    /**
     * Instantiates a new Import line parser.
     *
     * @param classParser the class parser
     */
    public ImportLineParser(ClassParser classParser) {
        super(classParser);
        this.classParser = classParser;
    }

    @Override
    public boolean isValidLineToParse(CodeLine entry) {
        return IMPORT_PATTERN.matcher(MultiReplacement.strip(entry.getLineContent().trim(), "import", ";", " ")).matches();
    }

    @Override
    public void parseLine(CodeLine entry) throws ParsingException {
        if (!isValidLineToParse(entry))
            return;

        if (entry.getLineContent().length() < "import;".length())
            throw new InvalidImportException("Import does not exceed minimum line size. at line: " + entry.getLineNumber());
        if (entry.getLineContent().startsWith("import")) {
            if (entry.getLineContent().endsWith(";")) {
                final String striped = MultiReplacement.strip(entry.getLineContent(), "import", ";", " ");

                if (!ImportLineParser.IMPORT_PATTERN.matcher(striped).matches())
                    throw new InvalidImportException("Import line does not match pattern at line " + entry.getLineNumber());

                if (!striped.isEmpty() && striped.length() != 3) {

                    String importContext = striped.replace(".", "/");

                    this.classParser.classFile.imports.add(importContext);

                    return;
                }
            } else {
                throw new InvalidImportException("Never ending import line \";\" is missing at line " + entry.getLineNumber());
            }
        }
        throw new InvalidImportException("Import line does not start with \"import\". at line " + entry.getLineNumber());
    }
}
