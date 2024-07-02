package org.avishek.toe;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private boolean isPlayer1Turn;

    private int m;
    private int n;

    private int moveCount;

    Game(int m, int n, Player player1, Player player2) {
        board = new Board(m, n);
        this.player1 = player1;
        this.player2 = player2;
        isPlayer1Turn = true;
        this.m = m;
        this.n = n;
        moveCount = 0;
    }

    public boolean move(Player player, int i, int j) throws GameoverException {
        try {
            moveCheck(i, j);
            playerCheck(player);
            Cell cell = this.board.getCell(i, j);
            CellType type = CellType.PLAYER1;
            if(player == player2) type = CellType.PLAYER2;
            cell.setType(type);
            isPlayer1Turn = !isPlayer1Turn;
            boolean gameOver = gameCheck(cell);
            if(gameOver) throw new GameoverException("Game Over! " + player.getName() + " has won the game.");
            moveCount++;
            if(moveCount == (m*n)) throw new GameoverException("Game Over! " + player.getName() + " Its a tie.");
            return true;
        } catch (InvalidMoveException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean gameCheck(Cell cell) {
        CellType type = cell.getType();
        int i = cell.getI();
        int j = cell.getJ();

        int k = 0;
        while(k != m) {
            if(board.getCell(k,j).getType() != type) {
                return false;
            }
            k++;
        }

        if(k == m) return true;

        k = 0;
        while(k != n) {
            if(board.getCell(i,k).getType() != type) {
                return false;
            }
            k++;
        }

        if(k == n) return true;

        i = cell.getI();
        j = cell.getJ();

        while(i >=0 && j >=0) {
            if(board.getCell(i,j).getType() != type) {
                return false;
            }
            i--; j--;
        }

        if(j ==0 && i == 0) return true;


        i = cell.getI();
        j = cell.getJ();

        while(i <= 0 && j <= 0) {
            if(board.getCell(i,j).getType() != type) {
                return false;
            }
            i++; j++;
        }

        if(i == m && j == n) return true;

        i = cell.getI();
        j = cell.getJ();
        while(i >=0 && j < n) {
            if(board.getCell(i,j).getType() != type) {
                return false;
            }
            i--; j++;
        }
        if(i == 0 && j == n) return true;

        i = cell.getI();
        j = cell.getJ();
        while(i < m && j >=0) {
            if(board.getCell(i,j).getType() != type) {
                return false;
            }
            i++; j--;
        }

        return true;
    }

    private void moveCheck(int i, int j) throws InvalidMoveException {
        if(i < 0 || j < 0 || i >= m || j >= n) throw new InvalidMoveException("Invalid move!");
        Cell cell = this.board.getCell(i, j);
        if(cell.getType() != CellType.VACANT) throw new InvalidMoveException("Invalid move!");
    }

    private void playerCheck(Player player) throws InvalidMoveException {
        if(player == player1 && !isPlayer1Turn) throw new InvalidMoveException("It is a chance of " + player2.getName());
        if(player == player2 && isPlayer1Turn) throw new InvalidMoveException("It is a chance of " + player1.getName());
    }

    public void view() {;
        String p1 = player1.getName().substring(0,1);
        String p2 = player2.getName().substring(0,1);

        for(int i=0; i < m; i++) {
            for(int j=0; j < n; j++) {
                Cell cell = board.getCell(i, j);
                CellType type = cell.getType();
                String output = "0";
                if(type == CellType.PLAYER1) output = p1;
                else if (type == CellType.PLAYER2) output = p2;
                System.out.print(output + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
