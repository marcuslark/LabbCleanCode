package se.iths.labb;

import java.util.Objects;

public class Cell {

    private cellState state;

    public Cell(cellState state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return state == cell.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(state);
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
