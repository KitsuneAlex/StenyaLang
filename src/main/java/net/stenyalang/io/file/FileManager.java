package net.stenyalang.io.file;

import net.stenyalang.io.file.index.DirectoryIndex;
import net.stenyalang.io.file.reader.ContextFileReader;
import net.stenyalang.units.CodeLine;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The type File manager.
 */
public class FileManager implements IFileManager {

    private final List<File> indexRunDir = new ArrayList<>();
    private final Map<String, List<CodeLine>> fullyParsedFiles = new ConcurrentHashMap<>();

    @Override
    public FileManager index(final File runDir) {

        if (!runDir.exists() && !runDir.mkdirs())
            throw new RuntimeException("Error while creating Run-Directory");

        if (runDir.exists() && runDir.isDirectory()) {

            final DirectoryIndex index = new DirectoryIndex();

            indexRunDir.addAll(index.index(runDir).getFoundFiles());
        }
        return this;
    }

    @Override
    public FileManager readAll() {
        for (File file : this.indexRunDir) {
            if (file.getName().endsWith(".stenya") || file.getName().endsWith(".sta")) {

                final ContextFileReader fileReader = new ContextFileReader(file);
                try {
                    fullyParsedFiles.put(file.getName(), fileReader.read());
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }

    @Override
    public Map<String, List<CodeLine>> toMap() {
        return fullyParsedFiles;
    }

}
