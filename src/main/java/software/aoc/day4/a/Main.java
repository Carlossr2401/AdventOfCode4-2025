package software.aoc.day4.a;

import java.io.IOException;

public class Main {
    static void main() throws IOException {
        Solver solver = SolverFactory.create("src/main/resources/map");
        System.out.println(solver.solve());
    }
}
