package net.stenyalang.parsing;

import net.stenyalang.parsing.exception.ParsingException;
import net.stenyalang.parsing.impl.entry.EntryFunctionParser;
import net.stenyalang.parsing.impl.header.HeaderLineParser;
import net.stenyalang.parsing.impl.importing.ImportLineParser;
import net.stenyalang.parsing.object.ClassFile;
import net.stenyalang.units.CodeLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The type Class parser.
 */
public class ClassParser implements IClassParser {

    public final ClassFile classFile;

    private final String fileName;

    private final List<LineParser> parsers = new ArrayList<>();

    /**
     * Instantiates a new Class parser.
     *
     * @param fileName the file name
     */
    public ClassParser(String fileName) {
        this.fileName = fileName;

        classFile = new ClassFile();
        classFile.imports = new ArrayList<>();

        parsers.addAll(Arrays.asList(

                new ImportLineParser(this),
                new HeaderLineParser(this),
                new EntryFunctionParser(this)

        ));
    }

    @Override
    public ClassParser parse(final List<CodeLine> content) throws ParsingException {
        for (CodeLine entry : content) {
            for (LineParser parser : this.parsers) {
                if (parser instanceof SingleLineParser<?>) {
                    final SingleLineParser<?> multiLineParser = (SingleLineParser<?>) parser;
                    multiLineParser.parseLine(entry);
                }
            }
        }

        for (LineParser parser : this.parsers) {
            if (parser instanceof MultiLineParser<?>) {
                final MultiLineParser<?> multiLineParser = (MultiLineParser<?>) parser;
                multiLineParser.parseLines(content.toArray(new CodeLine[0]));
            }
        }

        return this;
    }

    /**
     * Gets file name.
     *
     * @return the file name
     */
    public String getFileName() {
        return fileName;
    }

    public ClassFile getClassFile() {
        return classFile;
    }
}
