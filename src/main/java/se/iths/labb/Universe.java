package se.iths.labb;

public class Universe {

    private final Cell[][] state;

    public Universe(Cell[][] cellStates) {
        state = new Cell[cellStates.length][];

        for (int row = 0; row < cellStates.length; row++) {
            state[row] = new Cell[cellStates[row].length];
            for (int col = 0; col < cellStates[row].length; col++) {
                state[row][col] = new Cell(cellStates[row][col].getState());
            }
        }
    }

    public Cell[][] getState() {
        Cell[][] cellStates = new Cell[state.length][];

        for (int row = 0; row < state.length; row++) {
            cellStates[row] = new Cell[state[row].length];
            for (int col = 0; col < state[row].length; col++) {
                cellStates[row][col] = state[row][col];
            }
        }
        return cellStates;
    }

    public void update() {
        updateState(getNeighbourCount());
    }

    private int[][] getNeighbourCount() {
        int[][] numbersOfAliveNeighbours = new int[state.length][];
        for (int row = 0; row < state.length; row++) {
            numbersOfAliveNeighbours[row] = new int[state[row].length];
            for (int col = 0; col < state[row].length; col++) {
                numbersOfAliveNeighbours[row][col] = getNumberOfAliveNeighbours(row, col);
            }
        }
        return numbersOfAliveNeighbours;
    }

    private void updateState(int[][] numbersOfAliveNeighbours) {
        for (int row = 0; row < state.length; row++) {
            for (int col = 0; col < state[row].length; col++) {
                state[row][col].update(numbersOfAliveNeighbours[row][col]);
            }
        }
    }

    private int getNumberOfAliveNeighbours(int row, int col) {
        int numberOfAliveNeighbours = 0;
        numberOfAliveNeighbours += getNumberOfAliveNeighboursInRow(row -1, col);
        if (getCell(row, col - 1).isAlive()) numberOfAliveNeighbours++;
        if (getCell(row, col + 1).isAlive()) numberOfAliveNeighbours++;
        numberOfAliveNeighbours += getNumberOfAliveNeighboursInRow(row + 1, col);
        return numberOfAliveNeighbours;
    }

    private int getNumberOfAliveNeighboursInRow(int row, int col) {
        int numberOfAliveNeighbours = 0;
        if(row >= 0 && row < state.length) {
            if (getCell(row, col -1).isAlive()) numberOfAliveNeighbours++;
            if (getCell(row, col).isAlive()) numberOfAliveNeighbours++;
            if (getCell(row, col +1).isAlive()) numberOfAliveNeighbours++;
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
}
