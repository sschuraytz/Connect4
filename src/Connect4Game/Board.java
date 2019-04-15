package Connect4Game;

import javax.swing.*;

public class Board {

    public Cell[][] board = new Cell[Connect4Frame.NR_ROW][Connect4Frame.NR_COL];

    public Board() {
        for (int row = Connect4Frame.NR_ROW - 1; row >= 0; --row) {
            for (int col = 0; col < Connect4Frame.NR_COL; ++col) {
                board[row][col] = Cell.EMPTY;
            }
        }
    }

    public void makeBackEndMove(boolean who, int col, JLabel winLabel) {
        int rowNum = getRowNumber(col);
        board[rowNum][col] = who == Player.RED_PLAYER ? Cell.RED : Cell.YELLOW;

        Cell color = board[rowNum][col];
        if (isWinConfiguration(color, rowNum, col)) {
            winLabel.setText("\nPLAYER " + color + " WINS!");
        }
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

    public boolean canMove(int col) {
        boolean retVal = false;
        int row = getRowNumber(col);
        if (row < Connect4Frame.NR_ROW && row >= 0) {
            retVal = true;
        }
        return retVal;
    }

    private boolean isWinConfiguration(Cell color, int row, int col) {
        boolean isWin = false;
        if ( checkHorizontal(color, row) || checkVertical(color, col)
                || checkDiagonalUp(color, row, col) || checkDiagonalDown(color, row, col) ) {
            isWin = true;
        }
        return isWin;
    }

    private boolean checkHorizontal(Cell color, int row) {
        boolean isWin = false;
        int counter = 0;

        for (int col = 0; col < Connect4Frame.NR_COL; col++) {
            if (board[row][col] == color) {
                counter++;
                if (counter == 4) {
                    isWin = true;
                    break;
                }
            } else {
                counter = 0;
            }
        }
        return isWin;
    }

    private boolean checkVertical(Cell color, int col) {
        boolean isWin = false;
        int counter = 0;

        for (int row = 0; row < Connect4Frame.NR_ROW; row++) {
            if (board[row][col] == color) {
                counter++;
                if (counter == 4) {
                    isWin = true;
                    break;
                }
            } else {
                counter = 0;
            }
        }
        return isWin;
    }

    private boolean checkDiagonalUp(Cell color, int rowNum, int colNum) {
        boolean isWin = false;
        int counter = 0;

        int add = (Connect4Frame.NR_ROW - 1) - rowNum;
        if (colNum - add >= 0) {
            colNum -= add;

            for (int row = Connect4Frame.NR_ROW - 1; row >= 0; row--) {
                if (board[row][colNum] == color) {
                    counter++;
                    if (counter == 4) {
                        isWin = true;
                        break;
                    }
                } else {
                    counter = 0;
                }
                if (colNum < (Connect4Frame.NR_COL - 1)) {
                    colNum++;
                } else {
                    break;
                }
            }
        } else {
            add = colNum;
            if (rowNum - add >= 0) {
                rowNum -= add;

                for (int col = 0; col < Connect4Frame.NR_COL; col++) {
                    if (board[rowNum][col] == color) {
                        counter++;
                        if (counter == 4) {
                            isWin = true;
                            break;
                        }
                    } else {
                        counter = 0;
                    }
                    if (rowNum > 0) {
                        rowNum--;
                    } else {
                        break;
                    }
                }
            }
        }
        return isWin;
    }

    private boolean checkDiagonalDown(Cell color, int rowNum, int colNum) {
        boolean isWin = false;
        int counter = 0;

        int subtract = colNum;
        if (rowNum - subtract >= 0) {
            rowNum -= subtract;

            for (int col = 0; col < Connect4Frame.NR_COL; col++) {
                if (board[rowNum][col] == color) {
                    counter++;
                    if (counter == 4) {
                        isWin = true;
                        break;
                    }
                } else {
                    counter = 0;
                }
                if (rowNum < (Connect4Frame.NR_ROW - 1)) {
                    rowNum++;
                } else {
                    break;
                }
            }
        } else {
            subtract = rowNum;
            if (colNum - subtract >= 0) {
                colNum -= subtract;

                for (int row = 0; row < Connect4Frame.NR_ROW; row++) {
                    if (board[row][colNum] == color) {
                        counter++;
                        if (counter == 4) {
                            isWin = true;
                            break;
                        }
                    } else {
                        counter = 0;
                    }
                    if (colNum < Connect4Frame.NR_COL - 1) {
                        colNum++;
                    } else {
                        break;
                    }
                }
            }
        }
        return isWin;
    }
}