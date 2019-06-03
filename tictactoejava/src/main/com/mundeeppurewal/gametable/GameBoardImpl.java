package main.com.mundeeppurewal.gametable;

public class GameBoardImpl implements GameBoard {

    private String[][] gameBoard;

    public GameBoardImpl() {
        this.gameBoard = new String[3][3];
        buildBoard();
    }

    @Override
    public void buildBoard() {
        //build out default state for board
        for (int y = 0; y < gameBoard.length; y++) {
            for (int x = 0; x < gameBoard.length; x++) {
                gameBoard[y][x] = "-";
            }
        }
    }

    @Override
    public boolean checkCellIsEmpty(int y, int x) throws ArrayIndexOutOfBoundsException {
        if (gameBoard[y][x].equalsIgnoreCase("-")) {
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyCell(int y, int x, String playerSymbol) throws ArrayIndexOutOfBoundsException {
        if (checkCellIsEmpty(y, x) == true) {
            gameBoard[y][x] = playerSymbol;
            return true;
        } else {
            return false;
        }
    }

    public boolean searchGameBoard(String symbol) {
        boolean isFound = false;

        for (int y = 0; y < gameBoard.length; y++) {
            for (int x = 0; x < gameBoard.length; x++) {
                if(gameBoard[y][x].equalsIgnoreCase(symbol)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void printBoard() {
        System.out.println(this.toString());
    }

    public String[][] getGameBoard() {
        return gameBoard;
    }

    @Override
    public String toString() {
        String boardAsString = "";

        for (int y = 0; y < gameBoard.length; y++) {
            for (int x = 0; x < gameBoard.length; x++) {

                if (x == gameBoard.length - 1) {
                    boardAsString += gameBoard[y][x] + "\n";
                    continue;
                }
                boardAsString += gameBoard[y][x] + " | ";
            }
        }
        return boardAsString;
    }
}
