package org.avishek.snake;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Game {
    private static Logger log = LogManager.getLogger(Game.class);
    private Board board;
    private Snake snake;

    Game(int m, int n) {
        board = new Board(m, n);
        Cell start = board.getCell(0,0);
        start.setType(CellType.OCCUPIED);
        snake = new Snake(start);
    }

    public boolean addFood(int i, int j) {
        if(board.isFoodPresent()) {
            log.warn("Food already present! Cannot add new food");
            return false;
        }
        Cell food = board.getCell(i, j);
        food.setType(CellType.FOOD);
        this.board.isFoodPresent = true;
        return true;
    }

    public void move(Direction direction) throws Termination {
        Cell head = snake.getHead();
        Cell nextCell;

        if(direction == Direction.TOP) {
            nextCell = board.getCell(head.getI() - 1, head.getJ());
        } else if(direction == Direction.DOWN) {
            nextCell = board.getCell(head.getI() + 1, head.getJ());
        } else if(direction == Direction.LEFT) {
            nextCell = board.getCell(head.getI(), head.getJ()-1);
        } else {
            nextCell = board.getCell(head.getI(), head.getJ()+1);
        }
        move(nextCell);
    }

    private void move(Cell nextCell) {
        List<Cell> body = snake.getBody();
        if(nextCell == null || nextCell.getType() == CellType.OCCUPIED) throw new Termination("Game terminated!");
        else if(nextCell.getType() == CellType.FOOD) {
            nextCell.setType(CellType.OCCUPIED);
            body.add(0, nextCell);
            this.board.isFoodPresent = false;
        }
        else {
            nextCell.setType(CellType.OCCUPIED);
            body.add(0, nextCell);
            Cell tail = body.remove(body.size()-1); //Removing the tail
            tail.setType(CellType.VACANT);
        }
    }

    public void display() {
        System.out.println();
        Cell[][] cells = board.getCells();
        for(int i=0; i < cells.length; i++) {
            for(int j=0; j < cells[i].length; j++) {
                String dc = "O";
                if(cells[i][j].getType() == CellType.FOOD) dc = "X";
                else if(cells[i][j].getType() == CellType.OCCUPIED) dc = "S";
                System.out.print(dc + " ");
            }
            System.out.println();
        }
    }

}
