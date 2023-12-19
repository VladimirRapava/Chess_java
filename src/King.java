import static java.lang.Math.abs;
public class King extends ChessPiece {

    public King(String color) {
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
        if (((toLine - line == 0 && abs(toColumn - column) == 1)
                || (toColumn - column == 0 && abs(toLine - line) == 1)
                || (abs(toLine - line) == abs(toColumn - column) && abs(toLine - line) == 1))
                && (chessBoard.board[toLine][toColumn] == null)
                || (!chessBoard.board[toLine][toColumn].color.equals(this.color)
                && chessBoard.board[toLine][toColumn] != null))
            return true;
        else return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        if (line >= 0 &&  line <= 7 && column >= 0 && column <= 7) {
           for (int i = 0; i < 7; i++) {
               for (int j = 0; j < 7; j++) {
                   if (chessBoard.board[i][j] != null) {
                       if (!chessBoard.board[i][j].getColor().equals(color) && chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, line, column)) {
                                return false;
                       }
                   }
               }
           }
            return true;
        } else return false;

    }
}
