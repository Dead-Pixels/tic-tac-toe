package test.com.mundeeppurewal.gametable;

import main.com.mundeeppurewal.gametable.GameBoard;
import main.com.mundeeppurewal.gametable.GameBoardImpl;
import org.junit.Before;
import org.junit.Test;

import static org.testng.AssertJUnit.*;


public class GameBoardImplTest {
    private GameBoard gameBoard;

    @Before
    public void setUp() {
        gameBoard = new GameBoardImpl();
    }

    @org.junit.Test
    public void buildBoard_buildWithDash_ShouldPopulateGridWithDash() {
        boolean isBuilt = true;

        for (int y = 0; y < gameBoard.getGameBoard().length; y++) {
            for (int x = 0; x < gameBoard.getGameBoard().length; x++) {
                if (gameBoard.getGameBoard()[y][x] == "-") {
                    isBuilt = true;
                } else {
                    isBuilt = false;
                    break;
                }
            }
        }
        assertTrue(isBuilt);
    }

    @Test
    public void checkCellIsEmpty_checkingForXCharacter_ShouldReturnFalse() {
        gameBoard.getGameBoard()[0][0] = "X";

        boolean isCellEmpty = gameBoard.checkCellIsEmpty(0, 0);

        assertFalse(isCellEmpty);
    }

    @Test
    public void checkCellIsEmpty_checkingForOCharacter_ShouldReturnFalse() {
        gameBoard.getGameBoard()[0][0] = "O";

        boolean isCellEmpty = gameBoard.checkCellIsEmpty(0, 0);

        assertFalse(isCellEmpty);
    }

    @Test
    public void checkCellIsEmpty_checkingForDashCharacters_ShouldReturnTrue() {
        boolean isCellEmpty = gameBoard.checkCellIsEmpty(0, 0);

        assertTrue(isCellEmpty);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void checkCellIsEmpty_checkForInvalidMinusCoordinates_ShouldPassAsExceptionIsThrown() {
        gameBoard.checkCellIsEmpty(-1, -1);
        fail("Exception should be thrown");
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void checkCellIsEmpty_checkForInvalidNumOverEightCoordinates_ShouldPassAsExceptionIsThrown() {
        gameBoard.checkCellIsEmpty(10, 10);
        fail("Exception should be thrown");
    }

    @Test
    public void modifyCell_modifyWithX_ShouldReturnTrue() {
        gameBoard.modifyCell(0, 0, "X");
        assertTrue(gameBoard.searchGameBoard("X"));
    }

    @Test
    public void modifyCell_CheckForOCharacter_ShouldReturnTrue() {
        gameBoard.modifyCell(0, 0, "O");
        assertTrue(gameBoard.searchGameBoard("O"));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void modifyCell_checkForInvalidMinusCoordinates_ShouldPassAsExceptionIsThrown() {
        gameBoard.modifyCell(-1, -1, "X");
        fail("Exception should be thrown");
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void modifyCell_checkForInvalidNumOverEightCoordinates_ShouldPassAsExceptionIsThrown() {
        gameBoard.modifyCell(10, 10, "O");
        fail("Exception should be thrown");
    }

    @Test
    public void searchGameBoard_checkForSymbolX_ShouldReturnTrue() {
        gameBoard.modifyCell(1, 1, "X");
        assertTrue(gameBoard.searchGameBoard("X"));
    }

    @Test
    public void searchGameBoard_checkForSymbolo_ShouldReturnTrue() {
        gameBoard.modifyCell(1, 1, "O");
        assertTrue(gameBoard.searchGameBoard("O"));
    }

    @Test
    public void searchGameBoard_checkForSymbolThatDoesNotExist_ShouldReturnFalse() {
        gameBoard.modifyCell(1, 1, "X");
        assertFalse(gameBoard.searchGameBoard("V"));
    }

    @Test
    public void searchGameBoard_checkForNullSymbol_ShouldReturnFalse() {
        gameBoard.modifyCell(1, 1, "X");
        assertFalse(gameBoard.searchGameBoard(null));
    }


    @Test
    public void getGameBoard() {
        gameBoard.modifyCell(1, 1, "X");
        gameBoard.modifyCell(0, 0, "O");
        gameBoard.modifyCell(2, 2, "X");

        assertNotNull(gameBoard.getGameBoard());
    }

}