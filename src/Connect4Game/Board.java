package Connect4Game;

public class Board {

    public Cell[][] board = new Cell[Connect4Frame.NR_ROW][Connect4Frame.NR_COL];

    public Board() {
        for (int row = Connect4Frame.NR_ROW - 1; row >= 0; --row) {
            for (int col = 0; col < Connect4Frame.NR_COL; ++col) {
                board[row][col] = Cell.EMPTY;
            }
        }
    }

    public void makeBackEndMove(boolean who, int col) {
        int rowNum = getRowNumber(col);
        board[rowNum][col] = who == Player.RED_PLAYER ? Cell.RED : Cell.YELLOW;
    }

    public int getRowNumber(int col) {
        int rowNum = Connect4Frame.NR_ROW - 1;

        while (board[rowNum][col] != Cell.EMPTY && rowNum > 0) {
            rowNum = --rowNum;
        }
        if (board[0][col] != Cell.EMPTY) {
            rowNum = -1;
        }
        return rowNum;
    }

    public boolean canMove (int col) {
        boolean retVal = false;
        int row = getRowNumber(col);
        if (row < Connect4Frame.NR_ROW && row >= 0) {
            retVal = true;
        }
        return retVal;
    }
}
