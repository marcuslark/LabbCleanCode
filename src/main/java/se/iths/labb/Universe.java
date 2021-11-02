package se.iths.labb;

public class Universe {

    private final Cell[][] state;

    public Universe(Cell.cellState[][] cellStates) {
        state = new Cell[cellStates.length][];

        for (int row = 0; row < cellStates.length; row++) {
            state[row] = new Cell[cellStates[row].length];
            for (int col = 0; col < cellStates[row].length; col++) {
                state[row][col] = new Cell(cellStates[row][col]);
            }
        }
    }

    public Cell.cellState[][] getState() {
        Cell.cellState[][] cellStates = new Cell.cellState[state.length][];

        for (int row = 0; row < state.length; row++) {
            cellStates[row] = new Cell.cellState[state[row].length];
            for (int col = 0; col < state[row].length; col++) {
                cellStates[row][col] = state[row][col].getState();
            }
        }
        return cellStates;
    }

    public void update() {
        Cell.cellState[][] cellStates = getState();
        for (int row = 0; row < state.length; row++) {
            for (int col = 0; col < state[row].length; col++) {
                int numberOfAliveNeighbours = getNumberOfAliveNeighbours(cellStates, row, col);
                state[row][col].update(numberOfAliveNeighbours);
            }
        }
    }

    private int getNumberOfAliveNeighbours(Cell.cellState[][] state, int row, int col) {
        int numberOfAliveNeighbours = 0;
        numberOfAliveNeighbours += getNumberOfAliveNeighboursInRow(state, row -1, col);
        numberOfAliveNeighbours += getCountIfCellIsAlive(state, row, col - 1);
        numberOfAliveNeighbours += getCountIfCellIsAlive(state, row, col +1);
        numberOfAliveNeighbours += getNumberOfAliveNeighboursInRow(state, row + 1, col);
        return numberOfAliveNeighbours;
    }

    private int getNumberOfAliveNeighboursInRow(Cell.cellState[][] state, int row, int col) {
        int numberOfAliveNeighbours = 0;
        if(row >= 0 && row < state.length) {
            numberOfAliveNeighbours += getCountIfCellIsAlive(state, row, col - 1);
            numberOfAliveNeighbours += getCountIfCellIsAlive(state, row, col);
            numberOfAliveNeighbours += getCountIfCellIsAlive(state, row, col + 1);
        }
        return numberOfAliveNeighbours;
    }

    private int getCountIfCellIsAlive(Cell.cellState[][] state, int row, int col) {
        if (col >= 0 && col < state[row].length) {
            if (state[row][col] == Cell.cellState.ALIVE)
                return 1;
        }
        return 0;
    }
}
