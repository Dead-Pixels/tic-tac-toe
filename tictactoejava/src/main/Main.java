package main;

import main.com.mundeeppurewal.gameservice.GameService;
import main.com.mundeeppurewal.gameservice.GameServiceImpl;

public class Main {

    public static void main(String[] args) {

        GameService gameService = new GameServiceImpl("Joe Bloggs", "Bob Ross");
        gameService.startGame();
    }
}
