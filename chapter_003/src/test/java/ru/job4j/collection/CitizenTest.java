package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CitizenTest {

    @Test
    public void whenTestGetPassport() {
        Citizen citizen = new Citizen("12345678", "name");

        String result = citizen.getPassport();

        assertThat(result, is("12345678"));
    }

    @Test
    public void whenTestGetUserName() {
        Citizen citizen = new Citizen("12345678", "name");

        String result = citizen.getUsername();

        assertThat(result, is("name"));
    }

    @Test
    public void whenTestObjectsWithEqualPassport() {
        Citizen citizen = new Citizen("12345678", "name");
        Citizen citizen1 = new Citizen("12345678", "name2");

        boolean result = citizen.equals(citizen1);

        assertThat(result, is(true));
    }

    @Test
    public void whenTestEqualObjects() {
        Citizen citizen = new Citizen("12345678", "name");

        boolean result = citizen.equals(citizen);

        assertThat(result, is(true));
    }

    @Test
    public void whenTestObjectsVariousClass() {
        Citizen citizen = new Citizen("12345678", "name");
        UsageMap usageMap = new UsageMap();

        boolean result = citizen.equals(usageMap);

        assertThat(result, is(false));
    }

    @Test
    public void whenTestMethodToString() {
        Citizen citizen = new Citizen("12345678", "name");

        String result = citizen.toString();

        assertThat(result, is("Citizen: passport=12345678, username=name"));
    }

    @Test
    public void whenTestMethodHashCode() {
        Citizen citizen = new Citizen("12345678", "name");

        int result = citizen.hashCode();

        assertThat(result, is(-1861353309));
    }
}