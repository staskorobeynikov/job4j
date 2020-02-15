package ru.job4j.bomberman;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author STAS KOROBEYNIKOV (stas.korobeynikov@mail.ru).
 * @since 13.02.2020.
 */
class Board {
    /**
     * Игровое поле.
     * Представляет собой двумерный массив объектов класса ReentrantLock.
     */
    private final ReentrantLock[][] board;

    Board(int size) {
        this.board = new ReentrantLock[size][size];
        this.init();
    }

    int getSize() {
        return board.length;
    }

    /**
     * Метод инициализирует игровое поле.
     */
    private void init() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = new ReentrantLock();
            }
        }
    }

    /**
     * Метод позволяет получить объект класса ReentrantLock.
     *
     * @param cell Клетка, которую необходимо найти.
     * @return объект типа ReentrantLock.
     */
    ReentrantLock getCell(Cell cell) {
        return board[cell.getLine()][cell.getColumn()];
    }

    /**
     * Метод устанавливает возможность игрока соверщить ход.
     * - true - игрок может совершить ход;
     * - false - клетка занята другим игроком.
     *
     * @param source клетка, в которой находится игрок.
     * @param dest клетка, в которую игрок желает совершить ход.
     * @return переменную типа boolean.
     */
    boolean move(Cell source, Cell dest) throws InterruptedException {
        boolean result = false;
        if (board[dest.getLine()][dest.getColumn()].tryLock(500, TimeUnit.MILLISECONDS)) {
            if (board[source.getLine()][source.getColumn()].isLocked()) {
                board[source.getLine()][source.getColumn()].unlock();
            }
            board[dest.getLine()][dest.getColumn()].lock();
            result = true;
        }
        return result;
    }

    /**
     * Метод предназначен для установления списка клеток, в которые игрок может совершить ходы,
     * если двигается:
     * - вверх (индекс i + 1);
     * - вниз (индекс i - 1);
     * - влево (индекс j - 1);
     * - вправо (индекс j + 1).
     * Список может содержать клетки, которые заблокированы при инициализации
     * игры, или другим потоком.
     *
     * @param cell клетка, из которой игрок будет совершать ход.
     * @return список клеток, в которые игрок может совершить ходы.
     */
    List<Cell> getList(Cell cell) {
        List<Cell> result = new ArrayList<>();
        int i = cell.getLine();
        int j = cell.getColumn();
        if ((i - 1) >= 0) {
            result.add(new Cell(i - 1, j));
        }
        if ((i + 1) < this.getSize()) {
            result.add(new Cell(i + 1, j));
        }
        if ((j - 1) >= 0) {
            result.add(new Cell(i, (j - 1)));
        }
        if ((j + 1) < this.getSize()) {
            result.add(new Cell(i, (j + 1)));
        }
        return result;
    }
}
