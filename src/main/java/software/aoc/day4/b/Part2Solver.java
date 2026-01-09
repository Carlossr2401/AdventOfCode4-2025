package software.aoc.day4.b;

import java.util.ArrayList;
import java.util.List;
import software.aoc.day4.Coordinate;
import software.aoc.day4.PaperRollMap;
import software.aoc.day4.Solver;

public record Part2Solver(PaperRollMap initialMap) implements Solver {

    @Override
    public int solve() {
        int totalRemoved = 0;
        // La referencia al mapa mutable (puntero)
        PaperRollMap currentMap = this.initialMap;

        while (true) {

            // 1. Encontrar todos los rollos viables en el estado actual del mapa
            MapFinderResult iterationResult = findViableRollsInIteration(currentMap);

            int removedInThisStep = iterationResult.removedCount();

            // 2. Condición de Terminación: Si no se encontró ninguno, el proceso ha finalizado.
            if (removedInThisStep == 0) {
                break;
            }

            // 3. Acumular el total
            totalRemoved += removedInThisStep;

            // 4. Crear el nuevo mapa inmutable para la siguiente iteración,
            // reemplazando los rollos viables por '.' (espacio vacío).
            currentMap = currentMap.updateMap(iterationResult.removableCoordinates(), ".");
        }

        return totalRemoved;
    }

    /**
     * Realiza una sola iteración: identifica todos los rollos viables para la eliminación.
     */
    private MapFinderResult findViableRollsInIteration(PaperRollMap currentMap) {
        List<Coordinate> coordinatesToRemove = new ArrayList<>();
        int R = currentMap.getRows();
        int C = currentMap.getCols();

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {

                // Solo considerar rollos que aún estén presentes ('@')
                if (currentMap.getValue(r, c).equals("@")) {

                    // Si cumple la condición de accesibilidad (menos de 4 vecinos '@')
                    if (countAdjacentRolls(currentMap, r, c) < 4) {
                        coordinatesToRemove.add(new Coordinate(r, c));
                    }
                }
            }
        }
        return new MapFinderResult(coordinatesToRemove.size(), coordinatesToRemove);
    }

    private int countAdjacentRolls(PaperRollMap map, int row, int col) {
        int rollCount = 0;

        for (int dR = -1; dR <= 1; dR++) {
            for (int dC = -1; dC <= 1; dC++) {

                if (dR == 0 && dC == 0) continue;

                int newR = row + dR;
                int newC = col + dC;

                if (checkOutOfBounds(map, newR, newC)) {
                    // Contar si la celda es un rollo EN EL MAPA ACTUAL
                    if (map.getValue(newR, newC).equals("@")) {
                        rollCount++;
                    }
                }
            }
        }
        return rollCount;
    }

    private boolean checkOutOfBounds(PaperRollMap map, int r, int c) {
        int R = map.getRows();
        int C = map.getCols();

        return r >= 0 && r < R && c >= 0 && c < C;
    }

    // Record auxiliar para devolver múltiples valores de una iteración
    private record MapFinderResult(int removedCount, List<Coordinate> removableCoordinates) {}
}
