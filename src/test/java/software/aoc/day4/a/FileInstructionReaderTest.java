package software.aoc.day4.a;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileInstructionReaderTest {

    public static void main(String[] args) {
        System.out.println("Running FileInstructionReaderTest...");
        try {
            readAllLines_ValidFile_ReturnsCorrectMap();
            System.out.println("ALL TESTS PASSED");
        } catch (Exception e) {
            System.err.println("TEST FAILED: " + e.getMessage());
            e.printStackTrace();
        }
    }

    static void assertEquals(Object expected, Object actual, String testName) {
        if (!expected.equals(actual)) {
            throw new RuntimeException(testName + " failed. Expected " + expected + " but got " + actual);
        } else {
            System.out.println("  [OK] " + testName);
        }
    }

    static void readAllLines_ValidFile_ReturnsCorrectMap() throws IOException {
        Path tempFile = Files.createTempFile("test_map", ".txt");
        try {
            Files.writeString(tempFile, "@.\r\n.@");

            FileInstructionReader reader = new FileInstructionReader(tempFile.toString());
            PaperRollMap map = reader.readAllLines();

            assertEquals(2, map.getRows(), "Check Rows");
            assertEquals(2, map.getCols(), "Check Cols");
            assertEquals("@", map.getValue(0, 0), "Check (0,0)");
            assertEquals(".", map.getValue(0, 1), "Check (0,1)");
            assertEquals(".", map.getValue(1, 0), "Check (1,0)");
            assertEquals("@", map.getValue(1, 1), "Check (1,1)");

        } finally {
            Files.deleteIfExists(tempFile);
        }
    }
}
