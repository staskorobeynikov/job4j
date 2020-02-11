package ru.job4j.bomberman;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class Board {

    private final ReentrantLock[][] board;

    Board(int size) {
        this.board = new ReentrantLock[size][size];
        this.init();
    }

    int getSize() {
        return board.length;
    }

    private void init() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = new ReentrantLock();
            }
        }
    }

    ReentrantLock getCell(Cell cell) {
        return board[cell.getLine()][cell.getColumn()];
    }

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
}
