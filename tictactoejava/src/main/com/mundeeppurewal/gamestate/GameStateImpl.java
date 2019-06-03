package main.com.mundeeppurewal.gamestate;

import main.com.mundeeppurewal.gametable.GameBoard;

public class GameStateImpl implements GameState {

    private final String XXX = "XXX";
    private final String OOO = "OOO";

    int[][] rowSets = {{0, 0, 0}, {1, 1, 1}, {2, 2, 2}};
    int[] cols = {0, 1, 2};


    @Override
    public boolean checkForWin(GameBoard gameBoard) {
        boolean isWin = false;

        for (int[] row : rowSets) {
            //check all rows
            isWin = checkRowsAndColumns(row, cols, gameBoard);
            if (isWin == true) {
                return true;
            }

            //check all columns
            isWin = checkRowsAndColumns(cols, row, gameBoard);
            if (isWin == true) {
                return true;
            }
        }

        isWin = checkDiagonals(gameBoard);
        if (isWin == true) {
            return true;
        }
        return false;
    }

    public boolean checkRowsAndColumns(int[] row, int[] cols, GameBoard gameBoard) {
        String symbols = gameBoard.getGameBoard()[row[0]][cols[0]] +
                gameBoard.getGameBoard()[row[1]][cols[1]] +
                gameBoard.getGameBoard()[row[2]][cols[2]];

        if (symbols.equalsIgnoreCase(XXX) || symbols.equalsIgnoreCase(OOO)) {
            return true;
        }
        return false;
    }

    public boolean checkDiagonals(GameBoard gameBoard) {

        String lineFromTLToBR = gameBoard.getGameBoard()[0][0] +
                gameBoard.getGameBoard()[1][1] +
                gameBoard.getGameBoard()[2][2];

        String lineFromTRToBL = gameBoard.getGameBoard()[0][2] +
                gameBoard.getGameBoard()[1][1] +
                gameBoard.getGameBoard()[2][0];

        if (lineFromTLToBR.equalsIgnoreCase(XXX) || lineFromTLToBR.equalsIgnoreCase(OOO)
                || lineFromTRToBL.equalsIgnoreCase(XXX) || lineFromTRToBL.equalsIgnoreCase(OOO)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean checkForDraw(GameBoard gameBoard) {

        if (!gameBoard.searchGameBoard("-")) {
            return true;
        }
        return false;
    }
}
