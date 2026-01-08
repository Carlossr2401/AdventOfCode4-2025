package software.aoc.day4.b;

import java.util.List;
import java.util.Arrays;

public class MapFinderTest {

    public static void main(String[] args) {
        System.out.println("Running MapFinderTest Part B...");
        try {
            solve_EmptyMap_ReturnsZero();
            solve_SingleRoll_RemovedInFirstStep();
            solve_ChainReaction_3x3Block();
            System.out.println("ALL TESTS PASSED");
        } catch (Exception e) {
            System.err.println("TEST FAILED: " + e.getMessage());
            e.printStackTrace();
        }
    }

    static void assertEquals(int expected, int actual, String testName) {
        if (expected != actual) {
            throw new RuntimeException(testName + " failed. Expected " + expected + " but got " + actual);
        } else {
            System.out.println("  [OK] " + testName);
        }
    }

    static void solve_EmptyMap_ReturnsZero() {
        PaperRollMap emptyMap = new PaperRollMap(List.of());
        MapFinder finder = new MapFinder(emptyMap);
        assertEquals(0, finder.solve(), "solve_EmptyMap_ReturnsZero");
    }

    static void solve_SingleRoll_RemovedInFirstStep() {
        PaperRollMap map = new PaperRollMap(List.of(
            List.of("@")
        ));
        MapFinder finder = new MapFinder(map);
        assertEquals(1, finder.solve(), "solve_SingleRoll_RemovedInFirstStep");
    }

    static void solve_ChainReaction_3x3Block() {
        List<List<String>> grid = Arrays.asList(
            Arrays.asList("@", "@", "@"),
            Arrays.asList("@", "@", "@"),
            Arrays.asList("@", "@", "@")
        );
        PaperRollMap map = new PaperRollMap(grid);
        MapFinder finder = new MapFinder(map);
        assertEquals(9, finder.solve(), "solve_ChainReaction_3x3Block");
    }
}
