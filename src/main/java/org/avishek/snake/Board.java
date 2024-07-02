package org.avishek.snake;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Map;
import java.util.Set;

@Data
@EqualsAndHashCode
public class Board {
    private int m;
    private int n;
    boolean isFoodPresent;
    private Cell[][] cells;

    Board(int m, int n) {
        this.m = m;
        this.n = n;
        cells = new Cell[m][n];
        for(int i=0; i <m; i++) {
            for(int j=0; j < n; j++) {
                cells[i][j] = new Cell(i, j, CellType.VACANT);
            }
        }
        isFoodPresent = false;
    }


    public Cell getCell(int i, int j) {
        if(i < 0 || j < 0 && i >= m || j >= m) return null;
        return cells[i][j];
    }
}
