package ru.job4j.bomberman;

import java.util.List;
import java.util.Random;

/**
 * Класс описывает игрока Бомбермена, которым управляет пользователь.
 *
 * @author STAS KOROBEYNIKOV (stas.korobeynikov@mail.ru).
 * @since 14.02.2020.
 */
public class BomberMan implements Runnable {
    /**
     * Игровое поле.
     */
    private final Board board;
    /**
     * Стартовая позиция игрока.
     */
    private final Cell startPosition;
    /**
     * Поле для генерации случайных чисел
     */
    private final Random random = new Random();

    BomberMan(Board board) {
        this.board = board;
        startPosition = this.setStartPosition();
    }

    /**
     * Метод устанавливает клетку, в которой в начале игры будет находиться бомбермен.
     *
     * int column = random.nextInt(board.getSize() - 1);
     * Для индекса column установлено -1, чтобы при размере поля 2 * 2, стартовая позиция всегда
     * была в первой колонке. Необходимо для тестов.
     *
     * @return Клетка, с которой стартует игра для игрока.
     */
    private Cell setStartPosition() {
        Cell result;
        do {
            int line = random.nextInt(board.getSize());
            int column = random.nextInt(board.getSize() - 1);
            result = new Cell(line, column);
        } while (board.getCell(result).isLocked());
        return result;
    }

    /**
     * i и j - индексы, которые необходимо получить от пользователя.
     * Согласно заданию, данную часть реализовывать не надо.
     * Индексам присвоены значения, чтобы создать объект класса Cell.
     *
     * @param cell Клетка, на которой игрок находится сейчас.
     * @return Клетка в которую игрок совершит ход.
     */
    private Cell makeMove(Cell cell) {
        List<Cell> listMoves = board.getList(cell);
        Cell result;
        do {
            int i = 1;
            int j = 1;
            result = new Cell(i, j);
        } while (!listMoves.contains(result));
        return result;
    }

    /**
     * Метод описывает движение бомбермена по игровому полю.
     *
     * Блок описывает поведение если игрок не может совершить ход.
     * if (!moves.isEmpty()) {
     *      System.out.println("Bomberman destroy. User lost.");
     *      break;
     * }
     * Знак отрицания, чтобы оттестировать эту часть кода.
     * Вызвано тем, что не реализован пользовательский ввод координат клеток,
     * куда необходимо осуществить движение, и метод возвращает всегда одну и ту же клетку.
     * После реализации необходимо внести изменения.
     */
    @Override
    public void run() {
        boolean doMove;
        board.getCell(startPosition).lock();
        try {
            do {
                List<Cell> moves = board.getList(startPosition);
                Cell move = this.makeMove(startPosition);
                doMove = board.move(startPosition, move);
                if (doMove) {
                    startPosition.setLine(move.getLine());
                    startPosition.setColumn(move.getColumn());
                    System.out.println(String.format("Bomberman made move in cell - %s", move));
                }
                moves.remove(move);
                if (!moves.isEmpty()) {
                    System.out.println("Bomberman destroy. User lost.");
                    break;
                }
            } while (!doMove);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
