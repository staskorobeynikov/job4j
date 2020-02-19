package ru.job4j.exam;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PostTest {

    @Test
    public void whenInFiveUsersAndSevenEmailsThenOutTwoUsers() {
        HashMap<String, String> input = new HashMap<>();
        input.put("user1", "xxx@ya.ru,foo@gmail.com,lol@mail.ru");
        input.put("user2", "foo@gmail.com,ups@pisem.net");
        input.put("user3", "xyz@pisem.net,vasya@pupkin.com");
        input.put("user4", "ups@pisem.net,aaa@bbb.ru");
        input.put("user5", "xyz@pisem.net");

        Post post = new Post();
        Map<String, Set<String>> result = post.combine(input);

        Map<String, Set<String>> expected = Map.of(
                "user1", Set.of("ups@pisem.net", "aaa@bbb.ru", "foo@gmail.com", "xxx@ya.ru", "lol@mail.ru"),
                "user3", Set.of("vasya@pupkin.com", "xyz@pisem.net")
        );

        assertThat(result, is(expected));
    }
}