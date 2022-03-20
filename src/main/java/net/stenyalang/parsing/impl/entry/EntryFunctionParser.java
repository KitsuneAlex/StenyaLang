package net.stenyalang.parsing.impl.entry;

import net.stenyalang.parsing.ClassParser;
import net.stenyalang.parsing.MultiLineParser;
import net.stenyalang.units.CodeLine;
import net.stenyalang.units.MultiReplacement;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class EntryFunctionParser extends MultiLineParser<EntryPoint> {

    public static final String ENTRY_POINT_REGEX = "(fun) (main)*(\\()(args: \\[string]\\))( -> i32 \\{)([^$])*(})";
    public static final Pattern ENTRY_POINT_PATTERN = Pattern.compile(ENTRY_POINT_REGEX);

    public EntryFunctionParser(ClassParser classParser) {
        super(classParser);
    }


    @Override
    public boolean isValidLineToParse(CodeLine... blocks) {
        return ENTRY_POINT_PATTERN.matcher(wrapAndConnect(blocks)).matches();
    }

    @Override
    public void parseLines(CodeLine... blocks) {
        if (!isValidLineToParse(blocks))
            return;

        final String content = this.wrapAndConnect(blocks);

        System.out.println(content);
    }

    public String wrapAndConnect(final CodeLine... blocks) {
        final List<CodeLine> lines = new ArrayList<>();
        int start = -1, end = -1;

        for (CodeLine block : blocks) {
            if (block.getLineContent().startsWith("fun main")) {
                start = block.getLineNumber();
            }
            if (block.getLineContent().startsWith("}")) {
                end = block.getLineNumber();
                break;
            }
        }
        for (CodeLine block : blocks) {
            if (block.getLineContent().isEmpty())
                continue;
            if (block.getLineNumber() >= start && block.getLineNumber() <= end) {
                lines.add(block);
            }
        }

        final StringBuilder content = new StringBuilder();

        for (CodeLine line : lines) {
            content.append(MultiReplacement.strip(line.getLineContent(), "\n"));
        }

        return content.toString();
    }

}
