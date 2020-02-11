package ru.job4j.bomberman;

import java.util.Objects;

public class Cell {

    private int line;

    private int column;

    Cell(int line, int column) {
        this.line = line;
        this.column = column;
    }

    int getLine() {
        return line;
    }

    int getColumn() {
        return column;
    }

    void setLine(int line) {
        this.line = line;
    }

    void setColumn(int column) {
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cell cell = (Cell) o;
        return line == cell.line
                && column == cell.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(line, column);
    }

    @Override
    public String toString() {
        return String.format("Cell: line=%d, column=%d.", line, column);
    }
}
