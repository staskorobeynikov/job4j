package ru.job4j.bomberman;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author STAS KOROBEYNIKOV (stas.korobeynikov@mail.ru).
 * @since 14.02.2020
 */
class Blocks {
    /**
     * Игровое поле.
     */
    private final Board board;
    /**
     * Поле для генерации случайных чисел.
     */
    private final Random random = new Random();

    Blocks(Board board) {
        this.board = board;
    }

    /**
     * Метод устанавливает блоки на клетки, в которые игрок не может ходить.
     */
    void setBlockCell() {
        int count = board.getSize() - 2;
        int exitCycle = 0;
        if (count > 0) {
            while (exitCycle != count) {
                int i = random.nextInt(board.getSize());
                int j = random.nextInt(board.getSize());
                Cell cell = new Cell(i, j);
                if (!board.getCell(cell).isLocked()) {
                    board.getCell(cell).lock();
                    exitCycle++;
                }
            }
        }
    }

    /**
     * Метод для получения клеток, которые заблокированы при инициализации игры в виде списка.
     *
     * @return List - список заблокированных клеток.
     */
    List<Cell> getLockCells() {
        List<Cell> result = new ArrayList<>();
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                Cell cell = new Cell(i, j);
                if (board.getCell(cell).isLocked()) {
                    result.add(cell);
                }
            }
        }
        return result;
    }
}
