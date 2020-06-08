package net.tonick.xplaneudp.codegen;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class CodeGen {
    public static void main(String... args) throws IOException {
        File definitions = new File(Objects.requireNonNull(CodeGen.class.getClassLoader().getResource("definitions.json")).getFile());

        ObjectMapper mapper = new ObjectMapper();
        Root myObjects = mapper.readValue(definitions, Root.class);

        System.out.println(myObjects);
    }

    public static class Root {
        public List<Group> groups;

        @Override
        public String toString() {
            return "Root{" +
                    "groups=" + groups +
                    '}';
        }
    }

    public static class Group {
        public String name;
        public String description;
        public int idx;
        public List<Field> fields;

        @Override
        public String toString() {
            return "Group{" +
                    "name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    ", idx=" + idx +
                    ", fields=" + fields +
                    '}';
        }
    }

    private static class Field {
        public String name;
        public String description;
        public String type;
        public String unit;

        @Override
        public String toString() {
            return "Field{" +
                    "name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    ", type='" + type + '\'' +
                    ", unit='" + unit + '\'' +
                    '}';
        }
    }
}
