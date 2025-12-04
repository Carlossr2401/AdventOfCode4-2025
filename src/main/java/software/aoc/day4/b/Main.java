package software.aoc.day4.b;

import java.io.IOException;

public class Main {
    static void main() throws IOException {
        FileInstructionReader reader = new FileInstructionReader("src/main/resources/map");
        PaperRollMap paperRollMap = reader.readAllLines();

        MapFinder mapFinder = new MapFinder(paperRollMap);

        System.out.println(mapFinder.findTotalAccessibleAndRemoveAll());
    }
}
