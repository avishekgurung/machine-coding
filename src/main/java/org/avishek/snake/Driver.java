package org.avishek.snake;

public class Driver {
    public static void main(String[] args) {
        Game game = new Game(4,4);
        game.display();

        game.addFood(0,2);
        game.display();

        game.move(Direction.RIGHT);
        game.display();

        game.move(Direction.RIGHT);
        game.display();

        game.move(Direction.DOWN);
        game.display();

        game.move(Direction.DOWN);
        game.display();

        game.addFood(2,1);
        game.display();

        game.move(Direction.LEFT);
        game.display();
    }
}
