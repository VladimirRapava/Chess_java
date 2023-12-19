import static java.lang.Math.abs;

public class Pawn extends ChessPiece {

    public Pawn(String color) {
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
        if ((color.equals("White") && (line == 1) && (toLine - line > 0)
            && (toLine - line <= 2) && (toColumn-column == 0))
            && chessBoard.board[toLine][toColumn] == null)
        return true;
        if ((color.equals("White") && (line > 1)
                && (toLine - line > 0) && (toLine - line == 1) && (toColumn-column == 0))
                && chessBoard.board[toLine][toColumn] == null)
        return true;
        if ((color.equals("Black") && (line == 6)
                && (toLine - line < 0) && (toLine - line >= -2) && (toColumn-column == 0))
                && chessBoard.board[toLine][toColumn] == null)
        return true;
        if ((color.equals("Black") && (line < 6)
                && (toLine - line < 0) && (toLine - line == -1) && (toColumn-column == 0))
                && chessBoard.board[toLine][toColumn] == null)
        return true;
        if (color.equals("White") && !chessBoard.board[toLine][toColumn].color.equals(this.color)
                && chessBoard.board[toLine][toColumn] != null
                && abs(toColumn - column) == 1
                && toLine - line == 1)
        return true;
        if (color.equals("Black") && !chessBoard.board[toLine][toColumn].color.equals(this.color)
                && chessBoard.board[toLine][toColumn] != null
                &&  abs(toColumn - column) == 1
                && toLine - line == -1)
            return true;
        else return false;
    }
    @Override
    public String getSymbol() {
        return "P";
    }
}
