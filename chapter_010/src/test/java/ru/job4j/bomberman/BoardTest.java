package ru.job4j.bomberman;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BoardTest {

    private static final String LN = System.lineSeparator();

    @Test
    public void whenBoardMoveIsTrue() throws InterruptedException {
        Board board = new Board(3);
        Cell cell = new Cell(1, 1);
        Cell go = new Cell(2, 1);
        ReentrantLock r = board.getCell(cell);
        r.lock();

        boolean result = board.move(cell, go);

        assertThat(result, is(true));
    }

    @Test
    public void whenHeroMoveWithOneCellIsBlockThenTrue() throws InterruptedException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        Cell start = new Cell(0, 0);
        Board board = new Board(3);
        Cell go = new Cell(1, 0);
        board.getCell(go).lock();

        Hero hero = new Hero(board, start);
        Thread thread = new Thread(hero);
        thread.start();
        thread.join();

        String expect = String.format(
                "Hero moves to another cell, Thread=0.%s",
                LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }

    @Test
    public void whenHeroMoveWithTwoCellsIsBlockThenFalse() throws InterruptedException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        Cell start = new Cell(0, 0);
        Board board = new Board(3);
        Cell go = new Cell(0, 1);
        board.getCell(go).lock();
        Cell go2 = new Cell(1, 0);
        board.getCell(go2).lock();

        Hero hero = new Hero(board, start);
        Thread thread = new Thread(hero);
        thread.start();
        thread.join();

        String expect = String.format(
                "Hero cannot move, Thread=0.%s",
                LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }

    @Test
    public void whenHeroMoveWithTwoCellsIsBlockThenFalse1() throws InterruptedException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        Cell start = new Cell(0, 0);
        Cell start1 = new Cell(0, 2);
        Board board = new Board(3);
        Cell go = new Cell(1, 0);
        board.getCell(go).lock();
        Cell go1 = new Cell(1, 2);
        board.getCell(go1).lock();

        Hero hero = new Hero(board, start);
        Hero hero1 = new Hero(board, start1);
        Thread thread = new Thread(hero);
        Thread thread1 = new Thread(hero1);
        thread.start();
        thread.join();
        thread1.start();
        thread1.join();

        String expect = String.format(
                "Hero moves to another cell, Thread=0.%s"
                        + "Hero cannot move, Thread=2.%s",
                LN,
                LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }

    @Test
    public void whenGetList() {
        Board board = new Board(3);
        Cell go = new Cell(0, 0);
        Hero hero = new Hero(board, go);

        List<Cell> result = hero.getList(go);

        assertThat(result.size(), is(2));
    }

    @Test
    public void whenGetList1() {
        Board board = new Board(3);
        Cell go = new Cell(1, 1);
        Hero hero = new Hero(board, go);

        List<Cell> result = hero.getList(go);

        assertThat(result.size(), is(4));
    }

}