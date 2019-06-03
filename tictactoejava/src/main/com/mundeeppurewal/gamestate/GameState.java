package main.com.mundeeppurewal.gamestate;

import main.com.mundeeppurewal.gametable.GameBoard;

public interface GameState {

    boolean checkForWin(GameBoard gameBoard);

    boolean checkForDraw(GameBoard gameBoard);
}