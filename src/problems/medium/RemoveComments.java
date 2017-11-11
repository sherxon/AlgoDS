package problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Why Did you create this class? what does it do?
 */
public class RemoveComments {
    public static void main(String[] args) {
        System.out.println(removeComments(new String[] {
                "/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */",
                "a = b + c;", "}"
        }));
    }

    static public List<String> removeComments(String[] source) {
        List<String> list = new ArrayList<>();
        if (source == null || source.length == 0)
            return list;

        boolean blockCommentExists = false;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < source.length; i++) {
            builder.append(source[i]).append("\n");
        }
        int index, index2;
        while (true) {
            index = builder.indexOf("//");
            index2 = builder.indexOf("/*");
            if (index < index2) {
                if (index == -1) {
                    int limit = builder.indexOf("*/", index2 + 2) + 2;
                    builder.delete(index2, limit);
                } else {
                    int limit = builder.indexOf("\n", index);
                    if (index > 0 && builder.charAt(index - 1) == '\n') {
                        limit += 1;
                    }
                    builder.delete(index, limit);
                }
            } else if (index > index2) {
                if (index2 == -1) {
                    int limit = builder.indexOf("\n", index);
                    if (limit > 0 && builder.charAt(limit - 1) == '\n') {
                        limit += 1;
                    }
                    builder.delete(index, limit);
                } else {
                    int limit = builder.indexOf("*/", index2 + 2) + 2;
                    builder.delete(index2, limit);
                }
            } else {
                break;
            }

        }
        return Arrays.stream(builder.toString().split("\n")).filter(s -> s.length() > 0).collect(Collectors.toList());
    }
}
