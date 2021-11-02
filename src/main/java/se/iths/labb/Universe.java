package se.iths.labb;

public class Universe {

    private Cell[][] state;

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
        if (row > 0) {
            int rowAbove = row - 1;
            numberOfAliveNeighbours += getNumberOfAliveNeighboursInRow(state, row, col, rowAbove);
        }

        if (col > 0) {
            if (state[row][col - 1] == Cell.cellState.ALIVE)
                numberOfAliveNeighbours++;
        }
        if (col < state[row].length - 1) {
            if (state[row][col + 1] == Cell.cellState.ALIVE)
                numberOfAliveNeighbours++;
        }
        if (row < state.length - 1) {
            int rowBelow = row + 1;
                numberOfAliveNeighbours += getNumberOfAliveNeighboursInRow(state, row, col, rowBelow);
        }
        return numberOfAliveNeighbours;
    }

    private int getNumberOfAliveNeighboursInRow(Cell.cellState[][] state, int row, int col, int rowAbove) {
        int numberOfAliveNeighbours = 0;
        if (col > 0) {
            if (state[rowAbove][col - 1] == Cell.cellState.ALIVE)
                numberOfAliveNeighbours++;
        }
        if (state[rowAbove][col] == Cell.cellState.ALIVE)
            numberOfAliveNeighbours++;
        if (col < state[row].length - 1) {
            if (state[rowAbove][col + 1] == Cell.cellState.ALIVE)
                numberOfAliveNeighbours++;
        }
        return numberOfAliveNeighbours;
    }

}
