package main.com.mundeeppurewal.gameservice;

import main.com.mundeeppurewal.gamestate.GameState;
import main.com.mundeeppurewal.gamestate.GameStateImpl;
import main.com.mundeeppurewal.gametable.GameBoard;
import main.com.mundeeppurewal.gametable.GameBoardImpl;

import java.util.Scanner;

public class GameServiceImpl implements GameService {

    private String player1, player2;
    private GameBoard gameBoard;
    private GameState gameState;

    String playerSymbol = "X";
    Scanner scanner = new Scanner(System.in);
    boolean isGameStart = true;

    public GameServiceImpl(String playerOne, String playerTwo) {
        this.player1 = playerOne;
        this.player2 = playerTwo;
        gameBoard = new GameBoardImpl();
        gameState = new GameStateImpl();
    }

    @Override
    public void startGame() {
        System.out.println("Hello " + player1 + ", " + player2);
        System.out.println("To play the game please enter numbers in the following format y,x " +
                "corresponding to y and x coordinates");

        while (isGameStart) {
            takeTurn();
            if (playerSymbol.equalsIgnoreCase("X")) {
                playerSymbol = "O";
            } else if (playerSymbol.equalsIgnoreCase("O")) {
                playerSymbol = "X";
            }
        }
    }

    @Override
    public void endGame() {
        isGameStart = false;
    }

    @Override
    public void takeTurn() {

        gameBoard.printBoard();
        System.out.println("Please enter your selection in y,x format");
        String userInput = scanner.nextLine();

        if (userInput.equalsIgnoreCase("end")) {
            endGame();
        } else if (userInput.equalsIgnoreCase("restart")) {
            restartGame();
        }

        String[] yAndXCoordinates = userInput.split(",");

        int y = 0;
        int x = 0;
        try {
            y = Integer.valueOf(yAndXCoordinates[0]);
            x = Integer.valueOf(yAndXCoordinates[1]);
        } catch (NumberFormatException e) {
            System.out.println("Incorrect format entered. Please enter as y,x (e.g. 1,0");
            takeTurn();
        }

        boolean isCellEmpty = gameBoard.modifyCell(Integer.valueOf(yAndXCoordinates[0]),
                Integer.valueOf(yAndXCoordinates[1]), playerSymbol);
        if (!isCellEmpty) {
            System.out.println("The cell you have chosen has already been occupied...");
            takeTurn();
        } else if ((y < 0) || (x < 0) || (y > 8) || (x > 8)) {
            System.out.println("The input you provided is out of bounds. Please enter values between 0 and 8");
            takeTurn();
        }
        checkGameState();
    }

    @Override
    public void restartGame() {
        gameBoard.buildBoard();
        playerSymbol = "X";
    }

    @Override
    public void checkGameState() {
        String winner = "";

        try {
            if (gameState.checkForWin(gameBoard)) {
                if (playerSymbol == "X") {
                    winner = player1;
                } else {
                    winner = player2;
                }

                System.out.println("\n==================================================================" +
                        "\nWe have a winner!" + " " + winner
                        + " please collect your prize!" +
                        "\n==================================================================\n");

                gameBoard.printBoard();
                endGame();
            }
        } catch (NullPointerException | IllegalArgumentException e) {

        }

        if (gameState.checkForDraw(gameBoard)) {
            System.out.println("Ladies and Gentlemen, we have a tie game!");
            endGame();
        }
    }
}
