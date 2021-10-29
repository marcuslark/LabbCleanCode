package se.iths.labb;

public class GameOfLife {
    public GameOfLife(int vertical, int horizontal) {
        grid = new int[vertical][horizontal];
        this.vertical = grid.length;
    }
}
