package test.com.mundeeppurewal.gamestate;

import main.com.mundeeppurewal.gamestate.GameState;
import main.com.mundeeppurewal.gamestate.GameStateImpl;
import main.com.mundeeppurewal.gametable.GameBoard;
import main.com.mundeeppurewal.gametable.GameBoardImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameStateImplTest {
    private GameState gameState;
    private GameBoard gameBoard;

    @Before
    public void setUp() {
        gameState = new GameStateImpl();
        gameBoard = new GameBoardImpl();
    }

    @Test
    public void checkForWin_checkingForAllXWinOnBottomRowHorizontal_shouldReturnTrue() {
        gameBoard.buildBoard();
        gameBoard.modifyCell(2, 0, "X");
        gameBoard.modifyCell(2, 1, "X");
        gameBoard.modifyCell(2, 2, "X");

        assertTrue(gameState.checkForWin(gameBoard));
    }

    @Test
    public void checkForWin_checkingForAllOWinOnBottomRowHorizontal_shouldReturnTrue() {
        gameBoard.buildBoard();
        gameBoard.modifyCell(2, 0, "O");
        gameBoard.modifyCell(2, 1, "O");
        gameBoard.modifyCell(2, 2, "O");

        assertTrue(gameState.checkForWin(gameBoard));
    }

    @Test
    public void checkForWin_checkingForAllXWinOnRightRowVertical_shouldReturnTrue() {
        gameBoard.buildBoard();
        gameBoard.modifyCell(0, 2, "X");
        gameBoard.modifyCell(1, 2, "X");
        gameBoard.modifyCell(2, 2, "X");

        assertTrue(gameState.checkForWin(gameBoard));
    }

    @Test
    public void checkForWin_checkingForAllOWinOnRightRowVertical_shouldReturnTrue() {
        gameBoard.buildBoard();
        gameBoard.modifyCell(0, 2, "X");
        gameBoard.modifyCell(1, 2, "X");
        gameBoard.modifyCell(2, 2, "X");

        assertTrue(gameState.checkForWin(gameBoard));
    }

    @Test
    public void checkForWin_checkingForAllXWinDiagonalTopLeftToBottomRight_shouldReturnTrue() {
        gameBoard.buildBoard();
        gameBoard.modifyCell(0, 0, "X");
        gameBoard.modifyCell(1, 1, "X");
        gameBoard.modifyCell(2, 2, "X");

        assertTrue(gameState.checkForWin(gameBoard));
    }

    @Test
    public void checkForWin_checkingForAllOWinDiagonalTopLeftToBottomRight_shouldReturnTrue() {
        gameBoard.buildBoard();
        gameBoard.modifyCell(0, 0, "O");
        gameBoard.modifyCell(1, 1, "O");
        gameBoard.modifyCell(2, 2, "O");

        assertTrue(gameState.checkForWin(gameBoard));
    }

    @Test
    public void checkForWin_checkingForAllXWinDiagonalTopRightToBottomLeft_shouldReturnTrue() {
        gameBoard.buildBoard();
        gameBoard.modifyCell(0, 0, "X");
        gameBoard.modifyCell(1, 1, "X");
        gameBoard.modifyCell(2, 2, "X");

        assertTrue(gameState.checkForWin(gameBoard));
    }

    @Test
    public void checkForWin_checkingForAllOWinDiagonalTopRightToBottomLeft_shouldReturnTrue() {
        gameBoard.buildBoard();
        gameBoard.modifyCell(0, 2, "O");
        gameBoard.modifyCell(1, 1, "O");
        gameBoard.modifyCell(2, 0, "O");

        assertTrue(gameState.checkForWin(gameBoard));
    }

    @Test
    public void checkForWin_NoWinHorizontoal_shouldReturnFalse() {
        gameBoard.buildBoard();
        gameBoard.modifyCell(0, 0, "O");
        gameBoard.modifyCell(0, 1, "X");
        gameBoard.modifyCell(0, 2, "O");

        assertFalse(gameState.checkForWin(gameBoard));
    }

    @Test
    public void checkForWin_NoWinVertical_shouldReturnFalse() {
        gameBoard.buildBoard();
        gameBoard.modifyCell(0, 0, "O");
        gameBoard.modifyCell(1, 0, "X");
        gameBoard.modifyCell(2, 0, "O");

        assertFalse(gameState.checkForWin(gameBoard));
    }

    @Test
    public void checkForWin_NoWinDiagonalTopLeftToBottomRight_shouldReturnFalse() {
        gameBoard.buildBoard();
        gameBoard.modifyCell(0, 0, "O");
        gameBoard.modifyCell(1, 1, "X");
        gameBoard.modifyCell(2, 2, "O");

        assertFalse(gameState.checkForWin(gameBoard));
    }


    @Test
    public void checkForWin_NoWinDiagonalTopRightToBottomLeft_shouldReturnFalse() {
        gameBoard.buildBoard();
        gameBoard.modifyCell(0, 2, "O");
        gameBoard.modifyCell(1, 1, "X");
        gameBoard.modifyCell(2, 0, "O");

        assertFalse(gameState.checkForWin(gameBoard));
    }

    @Test
    @SuppressWarnings("All")
    public void checkForDraw_allCellsFilled_ShouldReturnTrue() {
        gameBoard.buildBoard();
        gameBoard.modifyCell(0, 0, "O");
        gameBoard.modifyCell(0, 1, "X");
        gameBoard.modifyCell(0, 2, "O");
        gameBoard.modifyCell(1, 0, "O");
        gameBoard.modifyCell(1, 1, "X");
        gameBoard.modifyCell(1, 2, "O");
        gameBoard.modifyCell(2, 0, "O");
        gameBoard.modifyCell(2, 1, "X");
        gameBoard.modifyCell(2, 2, "O");

        assertTrue(gameState.checkForDraw(gameBoard));
    }

    @Test
    @SuppressWarnings("All")
    public void checkForDraw_AllCellsButOneFilled_ShoulReturnFalse() {
        gameBoard.buildBoard();
        gameBoard.modifyCell(0, 0, "O");
        gameBoard.modifyCell(0, 1, "X");
        gameBoard.modifyCell(0, 2, "O");
        gameBoard.modifyCell(1, 0, "O");
        gameBoard.modifyCell(1, 1, "-");
        gameBoard.modifyCell(1, 2, "O");
        gameBoard.modifyCell(2, 0, "O");
        gameBoard.modifyCell(2, 1, "X");
        gameBoard.modifyCell(2, 2, "O");

        assertFalse(gameState.checkForDraw(gameBoard));
    }
}