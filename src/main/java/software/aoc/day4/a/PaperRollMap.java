package software.aoc.day4.a;

import java.util.List;

public record PaperRollMap(List<List<String>> grid) {

    public int getRows() {
        return grid.size();
    }

    public int getCols() {
        if (grid.isEmpty()) return 0;
        return grid.get(0).size();
    }

    public String getValue(int r, int c) {
        return grid.get(r).get(c);
    }
}