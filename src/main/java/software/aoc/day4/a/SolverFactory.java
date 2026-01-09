package software.aoc.day4.a;

import java.io.IOException;

public class SolverFactory {
    public static Solver create(String filePath) throws IOException {
        InstructionReader<PaperRollMap> reader = new FileInstructionReader(filePath);
        PaperRollMap paperRollMap = reader.readAllLines();
        return new MapFinder(paperRollMap);
    }
}
