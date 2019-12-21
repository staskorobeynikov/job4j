package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class GeneralStoreTest {
    UserStore us;
    RoleStore rs;
    User user1;
    User user2;
    User user3;
    User user4;
    Role role1;
    Role role2;
    Role role3;
    Role role4;

    @Before
    public void init() {
        us = new UserStore(3);
        user1 = new User("1");
        user2 = new User("2");
        user3 = new User("3");
        user4 = new User("4");
        us.add(user1);
        us.add(user2);
        us.add(user3);
        rs = new RoleStore(3);
        role1 = new Role("1");
        role2 = new Role("2");
        role3 = new Role("3");
        role4 = new Role("4");
        rs.add(role1);
        rs.add(role2);
        rs.add(role3);
    }

    @Test
    public void whenFindModelById() {
        assertThat(us.findById("1"), is(user1));
        assertThat(rs.findById("1"), is(role1));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenAddNewModelThenException() {
        us.add(user4);
        rs.add(role4);
    }

    @Test
    public void whenReplaceModelInStore() {
        assertThat(us.replace("2", user4), is(true));
        assertThat(us.findById("4"), is(user4));

        assertThat(rs.replace("2", role4), is(true));
        assertThat(rs.findById("4"), is(role4));
    }

    @Test
    public void whenReplaceModelNotExist() {
        assertThat(us.replace("5", user4), is(false));
        assertThat(rs.replace("5", role4), is(false));
    }

    @Test
    public void whenRemoveModelThenTrue() {
        assertThat(us.delete("2"), is(true));
        assertNull(us.findById("2"));

        assertThat(rs.delete("2"), is(true));
        assertNull(rs.findById("2"));
    }
}