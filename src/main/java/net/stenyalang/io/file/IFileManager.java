package net.stenyalang.io.file;

import net.stenyalang.units.CodeLine;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * The interface File manager.
 */
public interface IFileManager {
    /**
     * Index file manager.
     *
     * @param runDir the run dir
     * @return the file manager
     */
    IFileManager index(File runDir);

    /**
     * Read all file manager.
     *
     * @return the file manager
     */
    IFileManager readAll();

    /**
     * To map map.
     *
     * @return the map
     */
    Map<String, List<CodeLine>> toMap();
}
