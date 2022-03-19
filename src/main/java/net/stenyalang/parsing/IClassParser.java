package net.stenyalang.parsing;

import net.stenyalang.parsing.exception.ParsingException;
import net.stenyalang.units.CodeLine;

import java.util.List;

/**
 * The interface Class parser.
 */
public interface IClassParser {
    /**
     * Parse.
     *
     * @param content the content
     * @throws ParsingException the parsing exception
     */
    ClassParser parse(List<CodeLine> content) throws ParsingException;
}
