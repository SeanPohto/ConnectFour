package ConnectFour;
/**
 * Tic-Tac-Toe state variables.
 */
public class State
{
    private int gameState = Constants.STANDBY;
    private int whoseMove = Constants.X;
    private String xName = "";
    private String oName = "";
    private int[][] board = new int[Constants.BOARD_SIZE_ROW][Constants.BOARD_SIZE_COL];

    public boolean isWinner() {
        int total;
        //check rows
        for (int row = 0; row < Constants.BOARD_SIZE_ROW; row++) {
            total = getBoardCell (row,0) + getBoardCell (row,1) + getBoardCell (row,2) + getBoardCell (row,3);
            if (total == -4 || total == 4) {
                return true;
            }
            total = getBoardCell (row,1) + getBoardCell (row,2) + getBoardCell (row,3) + getBoardCell (row,4);
            if (total == -4 || total == 4) {
                return true;
            }
            total = getBoardCell (row,2) + getBoardCell (row,3) + getBoardCell (row,4) + getBoardCell (row,5);
            if (total == -4 || total == 4) {
                return true;
            }
            total = getBoardCell (row,3) + getBoardCell (row,4) + getBoardCell (row,5) + getBoardCell (row,6);
            if (total == -4 || total == 4) {
                return true;
            }
        }
        //check columns
        for (int col=0; col < Constants.BOARD_SIZE_COL; col++) {
            total = getBoardCell (0,col) + getBoardCell (1,col) + getBoardCell (2,col) + getBoardCell (3,col);
            if (total == -4 || total == 4) {
                return true;
            }
            total = getBoardCell (1,col) + getBoardCell (2,col) + getBoardCell (3,col) + getBoardCell (4,col);
            if (total == -4 || total == 4) {
                return true;
            }
            total = getBoardCell (2,col) + getBoardCell (3,col) + getBoardCell (4,col) + getBoardCell (5,col);
            if (total == -4 || total == 4) {
                return true;
            }
        }
        //check diagonals (TopLeft to BottomRight)
        for (int row = 0; row < Constants.BOARD_SIZE_ROW - 3; row++) {
            for (int col = 0; col < Constants.BOARD_SIZE_COL - 4; col++) {
                total = getBoardCell(row, col) + getBoardCell(row + 1, col + 1) + getBoardCell(row + 2, col + 2) + getBoardCell(row + 3, col + 3);
                if (total == -4 || total == 4) {
                    return true;
                }
            }
        }
        //check diagonals (BottomLeft to TopRight)
        for (int row = 0; row < Constants.BOARD_SIZE_ROW - 3; row++) {
            for (int col = 3; col < Constants.BOARD_SIZE_COL - 4; col++) {
                total = getBoardCell(row, col) + getBoardCell(row + 1, col - 1) + getBoardCell(row + 2, col - 2) + getBoardCell(row + 3, col - 3);
                if (total == -4 || total == 4) {
                    return true;
                }
            }
        } return false;
    } 

    public boolean isTie() {
        for (int row=0; row < Constants.BOARD_SIZE_ROW; row++) {
            for (int col=0; col < Constants.BOARD_SIZE_COL; col++) {
                if (getBoardCell(row,col) == Constants.BLANK) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getGameState() {
        return this.gameState;
    }

    public void setGameState(int gameState) {
        this.gameState = gameState;
    }

    public int getWhoseMove() {
        return this.whoseMove;
    }

    public void setWhoseMove(int whoseMove) {
        this.whoseMove = whoseMove;
    }

    public String getXName() {
        return this.xName;
    }

    public void setXName(String xName) {
        this.xName = xName;
    }

    public String getOName() {
        return this.oName;
    }

    public void setOName(String oName) {
        this.oName = oName;
    }

    public int getBoardCell(int row, int col) {
        if (row>=0 && row < Constants.BOARD_SIZE_ROW) {
            if (col >= 0 && col < Constants.BOARD_SIZE_COL){
                return this.board[row][col];
            }
        }
        return 0;
    }

    public boolean setBoardCell(int col, int value) {
        for (int row = Constants.BOARD_SIZE_ROW-1; row >= 0; row--) {
            if (board[row][col] == Constants.BLANK) {
                board[row][col] = value;
                return true;
            }
        }
        return false;
    }

    public void resetBoard() {
        gameState= Constants.STANDBY;
        board = new int[Constants.BOARD_SIZE_ROW][Constants.BOARD_SIZE_COL];
    }
}