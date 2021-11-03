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
        int[][] numbersOfAliveNeighbours = new int[state.length][];
        for (int row = 0; row < state.length; row++) {
            numbersOfAliveNeighbours[row] = new int[state[row].length];
            for (int col = 0; col < state[row].length; col++) {
                numbersOfAliveNeighbours[row][col] = getNumberOfAliveNeighbours(row, col);
            }
        }

        for (int row = 0; row < state.length; row++) {
            for (int col = 0; col < state[row].length; col++) {
                state[row][col].update(numbersOfAliveNeighbours[row][col]);
            }
        }
    }

    private int getNumberOfAliveNeighbours(int row, int col) {
        int numberOfAliveNeighbours = 0;
        numberOfAliveNeighbours += getNumberOfAliveNeighboursInRow(row -1, col);
        numberOfAliveNeighbours += getCountIfCellIsAlive(row, col - 1);
        numberOfAliveNeighbours += getCountIfCellIsAlive(row, col +1);
        numberOfAliveNeighbours += getNumberOfAliveNeighboursInRow(row + 1, col);
        return numberOfAliveNeighbours;
    }

    private int getNumberOfAliveNeighboursInRow(int row, int col) {
        int numberOfAliveNeighbours = 0;
        if(row >= 0 && row < state.length) {
            numberOfAliveNeighbours += getCountIfCellIsAlive(row, col - 1);
            numberOfAliveNeighbours += getCountIfCellIsAlive(row, col);
            numberOfAliveNeighbours += getCountIfCellIsAlive(row, col + 1);
        }
        return numberOfAliveNeighbours;
    }

    private Cell getCell(int row, int col) {
        if (col >= 0 && col < state[row].length) {
            return state[row][col];
        } else {
            return new Cell(Cell.cellState.DEAD);
        }
    }

    private int getCountIfCellIsAlive(int row, int col) {
        return getCell(row, col).getState() == Cell.cellState.ALIVE ? 1 : 0;
    }
}
