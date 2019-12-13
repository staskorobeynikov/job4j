package ru.job4j.stream;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import java.util.List;

public class ProfilesTest {
    @Test
    public void whenThreeAddress() {
        Profiles profilesTest = new Profiles();
        List<Address> actual = profilesTest.collect(List.of(
                new Profile(new Address("Minsk", "Ozernaya", 10, 30)),
                new Profile(new Address("Brest", "Lesnaya", 20, 50)),
                new Profile(new Address("Gomel", "Narodnaya", 30, 60))
        ));
        List<Address> expected = List.of(
                new Address("Minsk", "Ozernaya", 10, 30),
                new Address("Brest", "Lesnaya", 20, 50),
                new Address("Gomel", "Narodnaya", 30, 60)
        );
        assertThat(actual, is(expected));
     }
}
