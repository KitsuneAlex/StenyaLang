package net.stenyalang.parsing.object;

import net.stenyalang.parsing.impl.header.type.ClassHeader;

import java.util.List;

public class ClassFile {

    public ClassHeader classHeader;
    public List<String> imports;

    @Override
    public String toString() {
        return "ClassFile{" +
                "classHeader=" + classHeader +
                ", imports=" + imports +
                '}';
    }
}
