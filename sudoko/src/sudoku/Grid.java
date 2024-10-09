package sudoku;


public class Grid {
    private final int[][] board = new int[9][9];

    public int[][] getBoard() {
        return board;
    }

    public boolean isValid(Coord coord, int value) {
        for (int i = 0; i < 9; i++) {
            // Check row and column
            if (board[coord.getRow()][i] == value || board[i][coord.getCol()] == value) {
                return false;
            }
        }

        // Check 3x3 grid
        int gridRow = coord.getRow() / 3 * 3;
        int gridCol = coord.getCol() / 3 * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[gridRow + i][gridCol + j] == value) {
                    return false;
                }
            }
        }

        return true;
    }

    public void setValue(Coord coord, int value) {
        board[coord.getRow()][coord.getCol()] = value;
    }
}
