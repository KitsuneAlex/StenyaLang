package net.stenyalang.parsing.impl.header;

import net.stenyalang.parsing.ClassParser;
import net.stenyalang.parsing.SingleLineParser;
import net.stenyalang.parsing.exception.ParsingException;
import net.stenyalang.parsing.impl.header.type.ClassHeader;
import net.stenyalang.parsing.impl.header.type.ClassType;
import net.stenyalang.units.MultiReplacement;
import net.stenyalang.units.CodeLine;

import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * The type Header line parser.
 */
public class HeaderLineParser extends SingleLineParser<ClassHeader> {

    /**
     * The constant HEADER_CONTENT.
     */
    public static final String HEADER_CONTENT = "(@Header\\[name = \")([A-Za-z0-9])\\w+(\", type = )([A-Za-z0-9])\\w+(])";
    /**
     * The constant HEADER_PATTERN.
     */
    public static final Pattern HEADER_PATTERN = Pattern.compile(HEADER_CONTENT);

    private final ClassParser classParser;

    /**
     * Instantiates a new Header line parser.
     *
     * @param classParser the class parser
     */
    public HeaderLineParser(ClassParser classParser) {
        super(classParser);
        this.classParser = classParser;
    }

    @Override
    public boolean isValidLineToParse(CodeLine entry) {
        return HEADER_PATTERN.matcher(entry.getLineContent().trim()).matches();
    }

    @Override
    public void parseLine(CodeLine entry) throws ParsingException {
        if (!isValidLineToParse(entry))
            return;

        final String[] split = MultiReplacement.strip(entry.getLineContent(), "]", " ", "\"",  "@Header[name", "=", "type")
                .replace(",", "-")
                .split("-");

        final String className = split[0], typeName = split[1];

        if (Arrays.stream(ClassType.values())
                .noneMatch(classType -> classType.name().toUpperCase(Locale.ROOT).equalsIgnoreCase(typeName)))
            throw new InvalidClassHeaderException("Invalid Class Type");


        this.classParser.classFile.classHeader = new ClassHeader(className, ClassType.valueOf(typeName));
    }

}
