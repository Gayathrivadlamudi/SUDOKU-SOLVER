package sudoku;
import java.util.Random;

public class SudokuGenerator {
    private final Random random = new Random();
    private final Grid grid;

    public SudokuGenerator() {
        grid = new Grid();
        fillWithValidSolution();
    }

    private void fillWithValidSolution() {
        fillGrid(0, 0);
    }

    private boolean fillGrid(int row, int col) {
        if (row == 9) return true; // Finished filling
        if (col == 9) return fillGrid(row + 1, 0); // Move to next row

        for (int num = 1; num <= 9; num++) {
            Coord coord = new Coord(row, col);
            if (grid.isValid(coord, num)) {
                grid.setValue(coord, num);
                if (fillGrid(row, col + 1)) return true;
                grid.setValue(coord, 0); // backtrack
            }
        }

        return false;
    }

    public Grid getPuzzle(int numberOfPreFilledCells) {
        // Copy the filled grid to create the puzzle
        Grid puzzle = new Grid();
        for (int row = 0; row < 9; row++) {
            System.arraycopy(grid.getBoard()[row], 0, puzzle.getBoard()[row], 0, 9);
        }

        // Randomly remove cells
        for (int i = 0; i < 81 - numberOfPreFilledCells; i++) {
            int row = random.nextInt(9);
            int col = random.nextInt(9);
            if (puzzle.getBoard()[row][col] != 0) {
                puzzle.setValue(new Coord(row, col), 0);
            } else {
                i--; // Retry removing a different cell
            }
        }

        return puzzle;
    }

    public Grid getSolvedPuzzle() {
        return grid; // return the filled grid
    }
}
