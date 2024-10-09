package sudoku;
public class Coord {
    private final int row;
    private final int col;

    public Coord(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Coord)) return false;
        Coord coord = (Coord) obj;
        return row == coord.row && col == coord.col;
    }

    @Override
    public int hashCode() {
        return 31 * row + col;
    }
}
