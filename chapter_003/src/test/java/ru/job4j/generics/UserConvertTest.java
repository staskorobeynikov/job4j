package ru.job4j.generics;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {

    private static final String LN = System.lineSeparator();

    @Test
    public void whenTestUserConvert() {
        List<User> listUsers = List.of(new User(1, "Stas", "Minsk"));
        User user = new User(1, "Stas", "Minsk");
        HashMap<Integer, User> result = UserConvert.process(listUsers);
        HashMap<Integer, User> map = new HashMap<>();
        map.put(user.getId(), user);
        assertThat(result, is(map));
    }

    @Test
    public void whenTestMainMethod() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        String[] args = new String[0];
        UserConvert.main(args);

        String expect = String.format(
                "{1=User: id = 1, name = Stas, city = Minsk, "
                        + "2=User: id = 2, name = Petr, city = Bryansk, "
                        + "3=User: id = 3, name = Igor, city = Brest}%s",
                LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}
