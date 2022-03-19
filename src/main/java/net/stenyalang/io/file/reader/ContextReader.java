package net.stenyalang.io.file.reader;

import net.stenyalang.units.CodeLine;

import java.util.List;

/**
 * The interface Context reader.
 */
public interface ContextReader {
    /**
     * Read list.
     *
     * @return the list
     * @throws Throwable the throwable
     */
    List<CodeLine> read() throws Throwable;
}
