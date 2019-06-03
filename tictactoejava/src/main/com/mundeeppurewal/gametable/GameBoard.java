package main.com.mundeeppurewal.gametable;

public interface GameBoard {

    void buildBoard();

    boolean checkCellIsEmpty(int y, int x);

    boolean modifyCell(int y, int x, String playerSymbol);

    //get board
    String[][] getGameBoard();

    boolean searchGameBoard(String symbol);

    void printBoard();
}
