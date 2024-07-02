package org.avishek.toe;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Cell {
    private int i;
    private int j;
    private CellType type;
}
