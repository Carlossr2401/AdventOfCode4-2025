package software.aoc.day4.a;

public record MapFinder(PaperRollMap rollMap) implements Solver {

    @Override
    public int solve() {
        int accessibleRolls = 0;
        int R = rollMap.getRows();
        int C = rollMap.getCols();

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {

                // 1. Solo evaluamos las celdas que son rollos de papel ('@')
                if (rollMap.getValue(r, c).equals("@")) {

                    // 2. Comprobamos la regla de accesibilidad (menos de 4 vecinos '@')
                    if (countAdjacentRolls(r, c) < 4) {
                        accessibleRolls += 1;
                    }
                }
            }
        }
        return accessibleRolls;
    }

    private int countAdjacentRolls(int row, int col) {
        int rollCount = 0;

        // Iterar sobre los 8 posibles desplazamientos (-1 a 1)
        for (int dR = -1; dR <= 1; dR++) {
            for (int dC = -1; dC <= 1; dC++) {

                // 1. Omitir la celda central
                if (dR == 0 && dC == 0) continue;

                int newR = row + dR;
                int newC = col + dC;

                // 2. Verificar límites antes de acceder al mapa
                if (checkOutOfBounds(newR, newC)) {

                    // 3. Contar si la posición vecina contiene un rollo '@'
                    if (rollMap.getValue(newR, newC).equals("@")) {
                        rollCount++;
                    }
                }
            }
        }
        return rollCount;
    }

    private boolean checkOutOfBounds(int r, int c) {
        int R = rollMap.getRows();
        int C = rollMap.getCols();

        // El Record MapFinder usa los métodos del PaperRollMap
        return r >= 0 && r < R && c >= 0 && c < C;
    }
}