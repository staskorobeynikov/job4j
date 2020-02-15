package ru.job4j.bomberman;

import java.util.List;

public class Hero implements Runnable {

    private final Board board;

    private final Cell startPosition;

    Hero(Board board, Cell startPosition) {
        this.board = board;
        this.startPosition = startPosition;
    }

    @Override
    public void run() {
        boolean doMove = true;
        board.getCell(startPosition).lock();
        try {
            List<Cell> movesHero = board.getList(startPosition);
            for (Cell move : movesHero) {
                doMove = board.move(startPosition, move);
                if (doMove) {
                    System.out.println(
                            String.format("Hero moves to another cell, Thread=%s.",
                                    startPosition.getColumn())
                    );
                    startPosition.setLine(move.getLine());
                    startPosition.setColumn(move.getColumn());
                    break;
                }
            }
            if (!doMove) {
                System.out.println(
                        String.format("Hero cannot move, Thread=%s.",
                                startPosition.getColumn())
                );
            }
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
