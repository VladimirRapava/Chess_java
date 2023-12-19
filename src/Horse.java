import static java.lang.Math.abs;

public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7)
        return false;
        if ((toLine == line) && (toColumn == column))
        return false;
        if (((abs(toLine-line) == 2 && abs(toColumn-column) == 1)
            || (abs(toLine-line) == 1 && abs(toColumn-column) == 2))
            && (chessBoard.board[toLine][toColumn] == null
            || (!chessBoard.board[toLine][toColumn].color.equals(this.color))
                && chessBoard.board[toLine][toColumn] != null))
        return true;
        else return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }

}
