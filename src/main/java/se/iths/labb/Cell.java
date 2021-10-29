package se.iths.labb;

public class Cell {

    private cellState state;

    public Cell(cellState state) {
        this.state = state;
    }

    public enum cellState {
        ALIVE, DEAD
    }

    public cellState getNextState(int i) {
        return i>1 && i<4 ? cellState.ALIVE : cellState.DEAD;
    }
}
