package ru.job4j.statistic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import ru.job4j.statistic.Analize.User;
import ru.job4j.statistic.Analize.Info;

import java.util.ArrayList;
import java.util.Arrays;

public class AnalizeTest {

    @Test
    public void whenThreeUsersAdd() {
        Info result = new Analize().diff(new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new User(0, "Stas"),
                        new User(1, "Igor"), new User(2, "Sergey"))));
        assertThat(result.getAdded(), is(3));
        assertThat(result.getChanged(), is(0));
        assertThat(result.getDeleted(), is(0));
    }

    @Test
    public void whenThreeUsersChanged() {
        Info result = new Analize().diff(new ArrayList<>(Arrays.asList(new User(0, "Stas"),
                new User(1, "Igor"), new User(2, "Sergey"))),
                new ArrayList<>(Arrays.asList(new User(0, "Igor"),
                        new User(1, "Sergey"), new User(2, "Stas"))));
        assertThat(result.getAdded(), is(0));
        assertThat(result.getChanged(), is(3));
        assertThat(result.getDeleted(), is(0));
    }

    @Test
    public void whenThreeUsersDelete() {
        Info result = new Analize().diff(new ArrayList<>(Arrays.asList(new User(0, "Stas"),
                new User(1, "Igor"), new User(2, "Sergey"))),
                new ArrayList<>());
        assertThat(result.getAdded(), is(0));
        assertThat(result.getChanged(), is(0));
        assertThat(result.getDeleted(), is(3));
    }

    @Test
    public void whenSixElementsOneAddTwoChangeThreeDelete() {
        Info result = new Analize().diff(new ArrayList<>(Arrays.asList(
                new User(0, "Stas"),
                new User(1, "Igor"),
                new User(2, "Sergey"),
                new User(3, "Vladislav"),
                new User(4, "Iryna"),
                new User(5, "Michael"))),
                new ArrayList<>(Arrays.asList(
                        new User(6, "Vladislav"),
                        new User(0, "Stas"),
                        new User(1, "Michael"),
                        new User(2, "Iryna"))));
        assertThat(result.getAdded(), is(1));
        assertThat(result.getChanged(), is(2));
        assertThat(result.getDeleted(), is(3));
    }

    @Test
    public void whenTenElementsOneAddTwoChangeThreeDelete() {
        Info result = new Analize().diff(new ArrayList<>(Arrays.asList(
                new User(0, "Stas"),
                new User(1, "Igor"),
                new User(2, "Sergey"),
                new User(3, "Vladislav"),
                new User(4, "Iryna"),
                new User(5, "Michael"),
                new User(6, "Nadya"),
                new User(7, "Oleg"),
                new User(8, "Anna"),
                new User(9, "Elena"))),
                new ArrayList<>(Arrays.asList(
                        new User(0, "Nadya"),
                        new User(1, "Elena"),
                        new User(4, "Vladislav"),
                        new User(5, "Oleg"),
                        new User(10, "Kristina"),
                        new User(11, "Timofey"))));
        assertThat(result.getAdded(), is(2));
        assertThat(result.getChanged(), is(4));
        assertThat(result.getDeleted(), is(6));
    }
}