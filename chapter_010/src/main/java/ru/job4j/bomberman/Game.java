package ru.job4j.bomberman;

/**
 * @author STAS KOROBEYNIKOV (stas.korobeynikov@mail.ru).
 * @since 15.02.2020.
 */
public class Game {
    /**
     * Игровое поле.
     */
    private final Board board;

    Game(Board board) {
        this.board = board;
    }

    /**
     * Метод запускает игру.
     */
    void start() throws InterruptedException {
        Blocks blocks = new Blocks(board);
        BomberMan bomberMan = new BomberMan(board);
        Monsters monsters = new Monsters(board);
        blocks.setBlockCell();
        Thread threadBomberMan = new Thread(bomberMan);
        Thread threadMonsters = new Thread(monsters);
        threadBomberMan.start();
        threadBomberMan.join();
        threadMonsters.start();
        threadMonsters.join();
    }

    public static void main(String[] args) throws InterruptedException {
        new Game(new Board(10)).start();
    }
}
