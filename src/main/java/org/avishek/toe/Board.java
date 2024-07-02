package org.avishek.toe;

import lombok.Getter;

@Getter
public class Board {
    private int m;
    private int n;
    private Cell[][] cells;

    Board(int m, int n) {
        this.m = m ;
        this.n = n;
        cells = new Cell[m][n];
        for(int i=0; i < m; i++) {
            for(int j=0; j < n; j++) {
                cells[i][j] = new Cell(i, j, CellType.VACANT);
            }
        }

    }

    public Cell getCell(int i, int j) {
        return cells[i][j];
    }
}
