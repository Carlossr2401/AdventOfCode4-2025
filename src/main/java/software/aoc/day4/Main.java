package software.aoc.day4;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String filePath = "src/main/resources/map.txt";
        
        System.out.println("--- Day 4 Solution ---");
        
        // Strategy for Part A
        System.out.println("Solving Part A...");
        Solver solverA = SolverFactory.createSolver("A", filePath);
        System.out.println("Result Part A: " + solverA.solve());

        // Strategy for Part B
        System.out.println("Solving Part B...");
        Solver solverB = SolverFactory.createSolver("B", filePath);
        System.out.println("Result Part B: " + solverB.solve());
    }
}
