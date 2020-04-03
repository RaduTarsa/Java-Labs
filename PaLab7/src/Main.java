import Game.Game;
import Game.Board;
import Game.Player;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Player p1 = new Player("Player 1");
        Player p2 = new Player("Player 2");
        Player p3 = new Player("Player 3");
//        Player p4 = new Player("Player 4");
        Board b = new Board(10);
        Game game = new Game(b, 10, p1, p2, p3);
        game.start();
        game.showStats();

        System.out.println("Game Over!");
    }
}