package net.stenyalang.parsing;

import net.stenyalang.parsing.exception.ParsingException;
import net.stenyalang.units.CodeLine;

/**
 * The type Single line parser.
 *
 * @param <R> the type parameter
 */
public abstract class SingleLineParser<R> implements LineParser{

    private final ClassParser classParser;


    /**
     * Instantiates a new Single line parser.
     *
     * @param classParser the class parser
     */
    protected SingleLineParser(ClassParser classParser) {
        this.classParser = classParser;
    }

    /**
     * Is valid line to parse boolean.
     *
     * @param entry the entry
     * @return the boolean
     */
    public abstract boolean isValidLineToParse(CodeLine entry);

    /**
     * Parse line.
     *
     * @param entry the entry
     * @throws ParsingException the parsing exception
     */
    public abstract void parseLine(CodeLine entry) throws ParsingException;

    /**
     * Gets class parser.
     *
     * @return the class parser
     */
    public ClassParser getClassParser() {
        return classParser;
    }

}
