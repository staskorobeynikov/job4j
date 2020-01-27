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
                new Address("Brest", "Lesnaya", 20, 50),
                new Address("Gomel", "Narodnaya", 30, 60),
                new Address("Minsk", "Ozernaya", 10, 30)
        );
        assertThat(actual, is(expected));
     }

     @Test
    public void whenUseFunctionDistinct() {
        Profiles profilesTest = new Profiles();
        List<Address> actual = profilesTest.collect(List.of(
                new Profile(new Address("Minsk", "Ozernaya", 10, 30)),
                new Profile(new Address("Brest", "Lesnaya", 20, 50)),
                new Profile(new Address("Vitebsk", "Zapadnaya", 56, 243)),
                new Profile(new Address("Gomel", "Narodnaya", 30, 60)),
                new Profile(new Address("Minsk", "Ozernaya", 10, 30)),
                new Profile(new Address("Mogilev", "Poplavskaya", 20, 35)),
                new Profile(new Address("Brest", "Lesnaya", 20, 50)),
                new Profile(new Address("Grodno", "Krasnaya", 18, 97)),
                new Profile(new Address("Vitebsk", "Zapadnaya", 56, 243))
        ));
        List<Address> expected = List.of(
                new Address("Brest", "Lesnaya", 20, 50),
                new Address("Gomel", "Narodnaya", 30, 60),
                new Address("Grodno", "Krasnaya", 18, 97),
                new Address("Minsk", "Ozernaya", 10, 30),
                new Address("Mogilev", "Poplavskaya", 20, 35),
                new Address("Vitebsk", "Zapadnaya", 56, 243)
        );
        assertThat(actual, is(expected));
    }

    @Test
    public void whenTestMethodToString() {
        Address address = new Address("Brest", "Lesnaya", 20, 50);

        String result = address.toString();

        assertThat(result, is("Address: city = Brest, street = Lesnaya, home = 20, apartment = 50"));
    }

    @Test
    public void whenTestMethodEqualsIsFalse() {
        Address address = new Address("Brest", "Lesnaya", 20, 50);
        Address address1 = new Address("Brest", "Lesnaya", 20, 40);

        boolean result = address.equals(address1);

        assertThat(result, is(false));
    }

    @Test
    public void whenTestMethodEqualsIsFalse2() {
        Address address = new Address("Brest", "Lesnaya", 20, 50);
        Address address1 = new Address("Gomel", "Narodnaya", 30, 60);

        boolean result = address.equals(address1);

        assertThat(result, is(false));
    }

    @Test
    public void whenTestMethodEqualsIsTrue() {
        Address address = new Address("Brest", "Lesnaya", 20, 50);
        Address address1 = new Address("Brest", "Lesnaya", 20, 50);

        boolean result = address.equals(address1);

        assertThat(result, is(true));
    }

    @Test
    public void whenTestMethodEqualsIsTrue1() {
        Address address = new Address("Brest", "Lesnaya", 20, 50);

        boolean result = address.equals(address);

        assertThat(result, is(true));
    }

    @Test
    public void whenTestMethodEqualsIsFalse1() {
        Address address = new Address("Brest", "Lesnaya", 20, 50);

        boolean result = address.equals(new Student(10));

        assertThat(result, is(false));
    }
}
