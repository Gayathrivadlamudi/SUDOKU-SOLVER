package sudoku;
public class Main {
    public static void main(String[] args) {
        SudokuGenerator generator = new SudokuGenerator();
        Grid puzzle = generator.getPuzzle(30); // Generates a Sudoku puzzle with 30 pre-filled cells
        Grid solvedPuzzle = generator.getSolvedPuzzle();

        // Print the generated puzzle
        System.out.println("Generated Sudoku Puzzle:");
        printGrid(puzzle);

        // Print the solved puzzle
        System.out.println("Solved Sudoku Puzzle:");
        printGrid(solvedPuzzle);
    }

    private static void printGrid(Grid grid) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                System.out.print(grid.getBoard()[row][col] + " ");
            }
            System.out.println();
        }
    }
}
