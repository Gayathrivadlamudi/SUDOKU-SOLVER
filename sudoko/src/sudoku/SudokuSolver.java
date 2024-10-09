package sudoku;
public class SudokuSolver {
    public boolean solve(Grid grid) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (grid.getBoard()[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        Coord coord = new Coord(row, col);
                        if (grid.isValid(coord, num)) {
                            grid.setValue(coord, num);
                            if (solve(grid)) {
                                return true;
                            }
                            grid.setValue(coord, 0); // backtrack
                        }
                    }
                    return false; // if no number is valid
                }
            }
        }
        return true; // solved
    }
}
