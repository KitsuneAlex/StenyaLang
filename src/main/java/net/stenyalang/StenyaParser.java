package net.stenyalang;

import net.stenyalang.io.file.FileManager;
import net.stenyalang.parsing.ClassParser;
import net.stenyalang.parsing.exception.ParsingException;
import net.stenyalang.parsing.object.ClassFile;
import net.stenyalang.units.CodeLine;

import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

/**
 * The type Stenya parser.
 */
public class StenyaParser {

    /**
     * Instantiates a new Stenya parser.
     */
    public StenyaParser() {
        final Map<String, List<CodeLine>> classFiles = new FileManager()
                .index(Paths.get("./run_dir/").toFile())
                .readAll()
                .toMap();

        classFiles.forEach((name, pairs) -> {
            try {
                final ClassFile classFile = new ClassParser(name).parse(pairs).getClassFile();

            } catch (ParsingException e) {
                e.printStackTrace();
            }
        });

    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        try {
            new StenyaParser();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }


}
