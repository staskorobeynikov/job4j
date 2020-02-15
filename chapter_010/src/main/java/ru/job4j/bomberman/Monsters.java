package ru.job4j.bomberman;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author STAS KOROBEYNIKOV (stas.korobeynikov@mail.ru).
 * @since 15.02.2020.
 */
public class Monsters implements Runnable {
    /**
     * Игровое поле.
     */
    private final Board board;
    /**
     * Количество чудовищ на поле.
     */
    private final int countMonsters;
    /**
     * Список стартовых позиций чудовищ.
     */
    private final List<Cell> startPositions;
    /**
     * Поле для генерации случайных чисел.
     */
    private final Random random = new Random();

    Monsters(Board board) {
        this.board = board;
        countMonsters = this.getCountMonsters();
        startPositions = this.setStartPositions();
    }

    /**
     * Метод рассчитывает количество чудовищ.
     * Основа расчета - размер игрового поля.
     *
     * @return количество чудовищ на игровом поле.
     */
    private int getCountMonsters() {
        int result;
        if (board.getSize() < 7) {
            result = board.getSize() - 1;
        } else {
            result = Math.round((int) (2 * (board.getSize() + 1) / 3));
        }
        return result;
    }

    /**
     * Метод устанавливает стартовые позиции чудовищ.
     *
     * int line = random.nextInt(board.getSize() - 1);
     * Для индекса line установлено -1, чтобы при размере поля 2 * 2, стартовая позиция всегда
     * была в первом ряду. Необходимо для тестов.
     *
     * @return Список клеток, в которых находятся чудовища.
     */
    private List<Cell> setStartPositions() {
        List<Cell> result = new ArrayList<>();
        Cell positionMonster;
        for (int i = 1; i == countMonsters; i++) {
            do {
                int line = random.nextInt(board.getSize() - 1);
                int column = random.nextInt(board.getSize());
                positionMonster = new Cell(line, column);
            } while (board.getCell(positionMonster).isLocked());
            result.add(positionMonster);
        }
        return result;
    }

    /**
     * Метод определяет движение чудовищ по игровому полю.
     * Чудовища двигаются автоматически.
     */
    @Override
    public void run() {
        boolean doMove = false;
        for (Cell startPosition : startPositions) {
            board.getCell(startPosition).lock();
        }
        try {
            for (Cell startPosition : startPositions) {
                List<Cell> movesMonster = board.getList(startPosition);
                for (Cell toMove : movesMonster) {
                    doMove = board.move(startPosition, toMove);
                    if (doMove) {
                        System.out.println(
                                String.format(
                                        "Monster made a move from cell - %s to cell - %s",
                                        startPosition,
                                        toMove
                                )
                        );
                        startPosition.setLine(toMove.getLine());
                        startPosition.setColumn(toMove.getColumn());
                        break;
                    }

                }
                if (!doMove) {
                    System.out.println(
                            String.format(
                                    "Monster cannot move from cell - %s",
                                    startPosition
                            )
                    );
                }
            }
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
