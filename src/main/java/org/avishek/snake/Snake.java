package org.avishek.snake;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;


@Data
public class Snake {
    private List<Cell> body;
    Snake(Cell cell) {
        body = new LinkedList<>();
        body.add(cell);
    }

    public Cell getHead() {
        return body.get(0);
    }
}
