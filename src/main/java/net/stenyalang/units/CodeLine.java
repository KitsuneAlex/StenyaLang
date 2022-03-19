package net.stenyalang.units;

import java.util.Objects;

/**
 * The type Code line.
 */
public final class CodeLine {

    private final Integer lineNumber;
    private final String lineContent;

    /**
     * Instantiates a new Code line.
     *
     * @param lineNumber  the line number
     * @param lineContent the line content
     */
    public CodeLine(Integer lineNumber, String lineContent) {
        this.lineNumber = lineNumber;
        this.lineContent = lineContent;
    }

    @Override
    public boolean equals(Object instance) {
        if (instance instanceof CodeLine) {
            final CodeLine codeLine = (CodeLine) instance;
            return Objects.equals(codeLine.lineContent, this.lineContent)
                    && Objects.equals(codeLine.lineNumber, this.lineNumber);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineNumber, lineContent);
    }

    /**
     * Gets line number.
     *
     * @return the line number
     */
    public Integer getLineNumber() {
        return lineNumber;
    }

    /**
     * Gets line content.
     *
     * @return the line content
     */
    public String getLineContent() {
        return lineContent;
    }

    @Override
    public String toString() {
        return "CodeLine{" +
                "lineNumber=" + lineNumber +
                ", lineContent='" + lineContent + '\'' +
                '}';
    }
}
