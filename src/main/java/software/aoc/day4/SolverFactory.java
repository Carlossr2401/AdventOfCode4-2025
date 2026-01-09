package software.aoc.day4;

import java.io.IOException;
import software.aoc.day4.a.Part1Solver;
import software.aoc.day4.b.Part2Solver;

public class SolverFactory {

    public static Solver createSolver(String part, String filePath) throws IOException {
        FileInstructionReader reader = new FileInstructionReader(filePath);
        PaperRollMap map = reader.readAllLines();

        switch (part.toUpperCase()) {
            case "A":
                return new Part1Solver(map);
            case "B":
                return new Part2Solver(map);
            default:
                throw new IllegalArgumentException("Unknown part: " + part);
        }
    }
}
