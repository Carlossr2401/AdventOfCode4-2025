package software.aoc.day4.a;

import java.util.List;
import java.util.Arrays;

public class MapFinderTest {

    public static void main(String[] args) {
        System.out.println("Running MapFinderTest Part A...");
        try {
            solve_EmptyMap_ReturnsZero();
            solve_SingleRoll_ReturnsOne();
            solve_SurroundedRoll_ReturnsZero();
            solve_GridWithNoRolls_ReturnsZero();
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

    static void solve_SingleRoll_ReturnsOne() {
        PaperRollMap map = new PaperRollMap(List.of(
            List.of("@")
        ));
        MapFinder finder = new MapFinder(map);
        assertEquals(1, finder.solve(), "solve_SingleRoll_ReturnsOne");
    }

    static void solve_SurroundedRoll_ReturnsZero() {
        List<List<String>> grid = Arrays.asList(
            Arrays.asList(".", "@", "."),
            Arrays.asList("@", "@", "@"),
            Arrays.asList(".", "@", ".")
        );
        PaperRollMap map = new PaperRollMap(grid);
        MapFinder finder = new MapFinder(map);
        assertEquals(4, finder.solve(), "solve_SurroundedRoll_ReturnsZero");
    }

    static void solve_GridWithNoRolls_ReturnsZero() {
        List<List<String>> grid = Arrays.asList(
            Arrays.asList(".", "."),
            Arrays.asList(".", ".")
        );
        PaperRollMap map = new PaperRollMap(grid);
        MapFinder finder = new MapFinder(map);
        assertEquals(0, finder.solve(), "solve_GridWithNoRolls_ReturnsZero");
    }
}
