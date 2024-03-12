package ConnectFour;
import java.util.Scanner;

/**
 * UI class
 */
public class UI
{

    Scanner scanner;
    State state = new State();

    public UI() {
        scanner = new Scanner(System.in);         
    }
    // Utility methods
    public String getXOrO(int whoseMove) {
        if (whoseMove == -1) {
            return "X";
        } else if (whoseMove == 1) {
            return "O";
        } else {
            return " ";
        }
    }

    public String getPlayerName(int whoseMove, String xName, String oName) {
        return (whoseMove == -1) ? xName : oName;
    }

    public boolean isLegalMove(State state, int col) {
        return 1 <= col && col <= Constants.BOARD_SIZE_COL && 
        state.getBoardCell(col, 1) == Constants.BLANK;
    }

    // Prompt for input methods
    public String promptForName(String player) {
        System.out.printf(Constants.GET_PLAYER_NAME, player);
        return scanner.next();
    }

    public int getMoveCol(int whoseMove, String xName, String oName) {
        int col = 0;
        while (col <= 0 || col >= Constants.BOARD_SIZE_COL) {
            try {
                System.out.printf(Constants.GET_COL_MOVE, getXOrO(whoseMove), getPlayerName(whoseMove, xName, oName));
                col = scanner.nextInt();
            } catch (Exception e) {
                System.out.println(Constants.INVALID_COLUMN);
                scanner.next();
                continue; 
            }
            if (col < 0 || col > Constants.BOARD_SIZE_COL) {
                System.out.println(Constants.INVALID_COLUMN);
            }
        }
        return col;
    }

    public boolean startNewGame() {
        System.out.println(Constants.START_NEW_GAME);
        String yesOrNo = scanner.next();
        if (yesOrNo.equals("Y") || yesOrNo.equals("y")) {
            state.resetBoard();
            return true;
        } else {
            return false;
        }
    }

    // Printing text methods
    public void printWelcome() {
        System.out.println(Constants.TITLE);
    }

    public void printBoard(State state) {
        System.out.println(Constants.DIVIDER_STRING);
        for (int row = 0; row < Constants.BOARD_SIZE_ROW; row++) {
            System.out.printf(Constants.BOARD_STRING, getXOrO(state.getBoardCell(row, 0)), getXOrO(state.getBoardCell(row, 1)), 
                getXOrO(state.getBoardCell(row, 2)), getXOrO(state.getBoardCell(row, 3)), 
                getXOrO(state.getBoardCell(row, 4)), getXOrO(state.getBoardCell(row, 5)),
                getXOrO(state.getBoardCell(row, 6)));
            System.out.println();
            System.out.println(Constants.DIVIDER_STRING);
        }
    }

    public void printInvalidColumn() {
        System.out.printf(Constants.INVALID_COLUMN);
    }

    public void printInvalidMove(int col) {
        System.out.printf(Constants.INVALID_MOVE_ERROR, col);
    }

    public void printMove(State state, int col) {
        System.out.printf(Constants.PRINT_MOVE, getXOrO(state.getWhoseMove()), getPlayerName(state.getWhoseMove(), state.getXName(), state.getOName()), col);
        System.out.println();
    } 

    public void printWinner(State state) {
        System.out.printf(Constants.WINNER, getXOrO(state.getWhoseMove()), getPlayerName(state.getWhoseMove(), state.getXName(), state.getOName()));
        System.out.println();
    }

    public void printTieGame() {
        System.out.println(Constants.TIE_GAME);
    }
}