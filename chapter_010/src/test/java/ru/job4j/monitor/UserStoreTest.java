package ru.job4j.monitor;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserStoreTest {

    @Test
    public void whenAddIsTrue() {
        UserStore userStore = new UserStore();

        boolean result = userStore.add(new User(1, 100));

        assertThat(result, is(true));
    }

    @Test
    public void whenAddIsFalse() {
        UserStore userStore = new UserStore();
        userStore.add(new User(1, 100));

        boolean result = userStore.add(new User(1, 200));

        assertThat(result, is(false));
    }

    @Test
    public void whenUpdateIsTrue() {
        UserStore userStore = new UserStore();
        userStore.add(new User(1, 100));

        boolean result = userStore.update(new User(1, 200));

        assertThat(result, is(true));
    }

    @Test
    public void whenUpdateIsFalse() {
        UserStore userStore = new UserStore();
        userStore.add(new User(1, 100));

        boolean result = userStore.update(new User(2, 200));

        assertThat(result, is(false));
    }

    @Test
    public void whenDeleteIsTrue() {
        UserStore userStore = new UserStore();
        userStore.add(new User(1, 100));
        userStore.add(new User(2, 200));
        userStore.add(new User(3, 300));

        boolean result = userStore.delete(new User(2, 200));

        assertThat(result, is(true));
    }

    @Test
    public void whenDeleteIsFalse() {
        UserStore userStore = new UserStore();
        userStore.add(new User(1, 100));

        boolean result = userStore.delete(new User(2, 100));

        assertThat(result, is(false));
    }

    @Test
    public void whenTransfer100ThenBalanceUserOneIs0() {
        UserStore userStore = new UserStore();
        User user1 = new User(1, 100);
        User user2 = new User(2, 200);
        userStore.add(user1);
        userStore.add(user2);
        userStore.transfer(1, 2, 100);

        int result1 = user1.getAmount();
        int result2 = user2.getAmount();

        assertThat(result1, is(0));
        assertThat(result2, is(300));
    }

    @Test
    public void whenTransfer200ThenBalanceUsersNotChange() {
        UserStore userStore = new UserStore();
        User user1 = new User(1, 100);
        User user2 = new User(2, 200);
        userStore.add(user1);
        userStore.add(user2);
        userStore.transfer(1, 2, 200);

        int result1 = user1.getAmount();
        int result2 = user2.getAmount();

        assertThat(result1, is(100));
        assertThat(result2, is(200));
    }

    @Test
    public void whenTransfer100ToUserThatNoInStoreThenBalanceUsersNotChange() {
        UserStore userStore = new UserStore();
        User user1 = new User(1, 100);
        User user2 = new User(2, 200);
        userStore.add(user1);
        userStore.add(user2);
        userStore.transfer(1, 3, 100);

        int result1 = user1.getAmount();
        int result2 = user2.getAmount();

        assertThat(result1, is(100));
        assertThat(result2, is(200));
    }

    @Test
    public void whenTransfer100UserThatNoInStoreThenBalanceUsersNotChange() {
        UserStore userStore = new UserStore();
        User user1 = new User(1, 100);
        User user2 = new User(2, 200);
        userStore.add(user1);
        userStore.add(user2);
        userStore.transfer(3, 1, 100);

        int result1 = user1.getAmount();
        int result2 = user2.getAmount();

        assertThat(result1, is(100));
        assertThat(result2, is(200));
    }

    @Test
    public void whenTestToString() {
        User user = new User(1, 100);

        String result = user.toString();

        assertThat(result, is("User: id=1, amount=100."));
    }
}