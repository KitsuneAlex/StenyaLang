package net.stenyalang.io.file.reader;

import net.stenyalang.units.CodeLine;
import net.stenyalang.units.sneak.SneakyThrow;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The type Context file reader.
 */
public class ContextFileReader implements ContextReader {

    private final File file;

    /**
     * Instantiates a new Context file reader.
     *
     * @param file the file
     */
    public ContextFileReader(File file) {
        this.file = file;
    }

    @Override
    public List<CodeLine> read() throws Throwable {
        final String fileName = file.getName();

        final List<CodeLine> lines = new ArrayList<>();

        final Scanner scanner = new Scanner(file);

        int lineBreak = 0;
        while (scanner.hasNextLine()) {
            final CodeLine singleLine = new CodeLine(lineBreak, scanner.nextLine());

            lines.add(singleLine);
            lineBreak++;
        }

        SneakyThrow.sneaky(scanner::close);

        return lines;
    }

}
