package net.stenyalang.io.file.index;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * The type Directory index.
 */
public final class DirectoryIndex {

    private final List<File> foundFiles = new CopyOnWriteArrayList<>();

    /**
     * Index directory index.
     *
     * @param directory the directory
     * @return the directory index
     */
    public DirectoryIndex index(final File directory) {
        File[] files = null;
        if ((files = directory.listFiles()) != null)
            Arrays.stream(files).forEachOrdered(this::indexSub);
        return this;
    }

    private void indexSub(final File parent) {
        if (parent.isFile()) {
            foundFiles.add(parent);
        } else {
            File[] files;
            if ((files = parent.listFiles()) != null)
                Arrays.stream(files).forEachOrdered(file -> {
                    if (file.isDirectory())
                        indexSub(file);
                     else
                        foundFiles.add(file);
                });
        }
    }

    /**
     * Gets found files.
     *
     * @return the found files
     */
    public List<File> getFoundFiles() {
        return foundFiles;
    }
}
