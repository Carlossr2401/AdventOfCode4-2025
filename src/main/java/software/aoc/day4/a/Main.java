package software.aoc.day4.a;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Solver solver = SolverFactory.create("src/main/resources/map.txt");
        System.out.println(solver.solve());
    }
}
