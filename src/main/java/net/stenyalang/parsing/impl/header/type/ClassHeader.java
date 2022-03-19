package net.stenyalang.parsing.impl.header.type;

/**
 * The type Class header.
 */
public class ClassHeader {

    private final String className;
    private final ClassType type;

    /**
     * Instantiates a new Class header.
     *
     * @param className the class name
     * @param type      the type
     */
    public ClassHeader(String className, ClassType type) {
        this.className = className;
        this.type = type;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public ClassType getType() {
        return type;
    }

    /**
     * Gets class name.
     *
     * @return the class name
     */
    public String getClassName() {
        return className;
    }

    @Override
    public String toString() {
        return "ClassHeader{" +
                "className='" + className + '\'' +
                ", type=" + type +
                '}';
    }
}
