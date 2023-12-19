import static java.lang.Math.abs;
public class Rook extends ChessPiece {

    public Rook(String color) {
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
        if (((toLine - line == 0 && abs(toColumn - column) > 0)
            || (toColumn - column == 0 && abs(toLine - line) > 0))
            && (chessBoard.board[toLine][toColumn] == null
            || (!chessBoard.board[toLine][toColumn].color.equals(this.color)
            && chessBoard.board[toLine][toColumn] != null)))
            return true;
        else return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
