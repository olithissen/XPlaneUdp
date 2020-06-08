package net.tonick.xplaneudp.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TestDataSlicer {
    public static List<byte[]> slice(String filename) throws IOException {
        Path resourceDirectory = Paths.get("src", "test", "resources", filename);
        byte[] allBytes = Files.readAllBytes(resourceDirectory);
        return split("DATA".getBytes(), allBytes);
    }

    public static boolean isMatch(byte[] pattern, byte[] input, int pos) {
        for (int i = 0; i < pattern.length; i++) {
            if (pattern[i] != input[pos + i]) {
                return false;
            }
        }
        return true;
    }

    public static List<byte[]> split(byte[] pattern, byte[] input) {
        List<byte[]> l = new LinkedList<byte[]>();
        int blockStart = 0;
        for (int i = 0; i < input.length; i++) {
            if (isMatch(pattern, input, i) && i > 0) {
                l.add(Arrays.copyOfRange(input, blockStart, i));
                blockStart = i;
                i = blockStart + pattern.length;
            }
        }
        l.add(Arrays.copyOfRange(input, blockStart, input.length));
        return l;
    }
}
