package ru.job4j.tictactoegame;

/**
 * Class for working with the playing field.
 *
 * @author STAS KOROBEYNIKOV
 * @since 17.01.2020
 */
public class PlayingField implements Field {
    /**
     * Size playing field.
     */
    private int size;
    /**
     * Array string symbol for playing field.
     */
    private String[][] cell;
    /**
     * Default value cell.
     */
    private static final String DEFAULT_FIELD_VALUE = "*";
    /**
     * Default size playing field.
     */
    private static final int DEFAULT_SIZE = 3;

    /**
     * Initializes playing field.
     * @param input input parameters.
     */
    @Override
    public void initBoard(Input input) {
        if ("y".equals(input.askString("Use default size playing field (y/any key): "))) {
            this.size = DEFAULT_SIZE;
        } else {
            this.size = input.askInt("Enter size playing field: ", DEFAULT_SIZE * 100);
        }
        this.cell = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cell[i][j] = DEFAULT_FIELD_VALUE;
            }
        }
    }

    /**
     * Print the playing field.
     */
    @Override
    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(cell[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * Method return playing field size.
     *
     * @return size playing field.
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Method adds figure on the playing field.
     *
     * @param x number line on board.
     * @param y number column on board.
     * @param symbol symbol to add.
     */
    @Override
    public void addFigure(int x, int y, String symbol) {
        cell[x - 1][y - 1] = symbol;
    }

    /**
     * Method checks if the cell is empty.
     *
     * @param x number line on board.
     * @param y number column on board.
     * @return true - cell can be filled with player symbol.
     */
    @Override
    public boolean isValidCell(int x, int y) {
        boolean result = false;
        if (cell[x - 1][y - 1].equals(DEFAULT_FIELD_VALUE)) {
            result = true;
        }
        return result;
    }

    /**
     * Method checks for empty cells in the playing field.
     *
     * @return true - playing field has empty cell.
     */
    @Override
    public boolean isFreeCell() {
        boolean result = false;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (cell[i][j].equals(DEFAULT_FIELD_VALUE)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Method checks winning combination on playing field.
     *
     * @param symbol symbol of gamer.
     * @return true - on the playing field is winning combination.
     */
    @Override
    public boolean checkCombination(String symbol) {
        return checkLine(symbol)
                || checkColumn(symbol)
                || checkLeftDiagonal(symbol)
                || checkRightDiagonal(symbol);
    }

    /**
     * Helper method checks winning combination on line.
     *
     * @param symbol symbol of gamer.
     * @return true - on line is winning combination.
     */
    private boolean checkLine(String symbol) {
        boolean result = false;
        for (int i = 0; i < size; i++) {
            int countSymbol = 0;
            for (int j = 0; j < size; j++) {
                if (cell[i][j].equals(symbol)) {
                    countSymbol++;
                }

            }
            if (countSymbol == size) {
                result = true;
            }
        }
        return result;
    }

    /**
     * Helper method checks winning combination on column.
     *
     * @param symbol symbol of gamer.
     * @return true - on column is winning combination.
     */
    private boolean checkColumn(String symbol) {
        boolean result = false;
        for (int i = 0; i < size; i++) {
            int countSymbol = 0;
            for (int j = 0; j < size; j++) {
                if (cell[j][i].equals(symbol)) {
                    countSymbol++;
                }
            }
            if (countSymbol == size) {
                result = true;
            }
        }
        return result;
    }

    /**
     * Helper method checks winning combination on left diagonal.
     * Left diagonal: upper left corner - lower right corner.
     *
     * @param symbol symbol of gamer.
     * @return true - on left diagonal is winning combination.
     */
    private boolean checkLeftDiagonal(String symbol) {
        boolean result = false;
        int countSymbol = 0;
        for (int i = 0; i < size; i++) {
            if (cell[i][i].equals(symbol)) {
                countSymbol++;
            }
        }
        if (countSymbol == size) {
            result = true;
        }
        return result;
    }

    /**
     * Helper method checks winning combination on right diagonal.
     * Right diagonal: upper right corner - lower left corner.
     *
     * @param symbol symbol of gamer.
     * @return true - on right diagonal is winning combination.
     */
    private boolean checkRightDiagonal(String symbol) {
        boolean result = false;
        int countSymbol = 0;
        for (int i = 0, j = size - 1; i < size && j >= 0; i++, j--) {
            if (cell[i][j].equals(symbol)) {
                countSymbol++;
            }
        }
        if (countSymbol == size) {
            result = true;
        }
        return result;
    }
}
