package se.iths.labb;

public class Cell {

    private cellState state;

    public Cell(cellState state) {
        this.state = state;
    }

    public Cell.cellState getState() {
        return state;
    }

    boolean isAlive() {
        return getState() == cellState.ALIVE;
    }

    public enum cellState {
        ALIVE, DEAD
    }

    public void update(int i) {
        if (state == cellState.ALIVE) {
            state = i > 1 && i < 4 ? cellState.ALIVE : cellState.DEAD;
        } else {
            state = i == 3 ? cellState.ALIVE : cellState.DEAD;
        }
    }
}
