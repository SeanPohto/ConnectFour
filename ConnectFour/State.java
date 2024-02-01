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
    private int[][] board = new int[Constants.BOARD_SIZE_ROWS][Constants.BOARD_SIZE_COLUMNS];

    public boolean isWinner() {
        int total;
        for (int col = 0; col < 4; col++) {
            for (int row = 0; row < Constants.BOARD_SIZE_ROWS; row++) {
                total = getBoardCell (row,0+vCount) + getBoardCell (row,1+col) + getBoardCell (row,2+col) + getBoardCell (row,3+col);
                if (total == -4 || total == 4) {
                    return true;
                }
            }
        }
        for (int row = 0; row < 4; row++) {
            for (int col=0; col < Constants.BOARD_SIZE_COLUMNS; col++) {
                total = getBoardCell (0+row,col) + getBoardCell (1+row,col) + getBoardCell (2+row,col) + getBoardCell (3+row,col);
                if (total == -3 || total == 3) {
                    return true;
                }
            }
        }
        total = getBoardCell(0,0) + getBoardCell(1,1) + getBoardCell(2,2);
        if (total == -3 || total == 3) {
            return true;
        }
        total = getBoardCell(0,2) + getBoardCell(1,1) + getBoardCell(2,0);
        if (total == -3 || total == 3) {
            return true;
        } else {
            return false;
        }

        public boolean isTie() {
            for (int row=0; row < Constants.BOARD_SIZE; row++) {
                for (int col=0; col < Constants.BOARD_SIZE; col++) {
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
        return this.board[row][col];
    }

    public void setBoardCell(int row, int col, int value) {
        this.board[row][col] = value;
    }

    public void resetBoard() {
        gameState= Constants.STANDBY;
        board = new int[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
    }
}