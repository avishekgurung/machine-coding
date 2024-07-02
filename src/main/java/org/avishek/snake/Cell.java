package org.avishek.snake;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@Data
@EqualsAndHashCode
public class Cell {
    private int i;
    private int j;
    private CellType type;
}
