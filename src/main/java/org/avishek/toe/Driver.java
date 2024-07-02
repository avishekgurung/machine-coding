package org.avishek.toe;

public class Driver {
    public static void main(String[] args) {
        Player player1 = new Player(1, "Avishek");
        Player player2 = new Player(2, "Shoaib");
        Game game = new Game(3,3, player1, player2);
        game.view();

        game.move(player1, 0,0);
        game.view();

        game.move(player2, 2,2);
        game.view();

        game.move(player1, 1,1);
        game.view();

        game.move(player2, 1,2);
        game.view();

        game.move(player1, 2,1);
        game.view();

        game.move(player2, 2,0);
        game.view();

        game.move(player1, 0,1);
        game.view();

    }
}
