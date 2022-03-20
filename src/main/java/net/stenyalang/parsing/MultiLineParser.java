package net.stenyalang.parsing;

import net.stenyalang.units.CodeLine;

/**
 * The type Multi line parser.
 *
 * @param <R> the type parameter
 */
public abstract class MultiLineParser<R> implements LineParser {

    private final ClassParser classParser;

    protected MultiLineParser(ClassParser classParser) {
        this.classParser = classParser;
    }

    /**
     * Is valid line to parse boolean.
     *
     * @param block the block
     * @return the boolean
     */
    public abstract boolean isValidLineToParse(final CodeLine... block);

    /**
     * Parse lines r.
     *
     * @param block the block
     */
    public abstract void parseLines(final CodeLine... block);

}
