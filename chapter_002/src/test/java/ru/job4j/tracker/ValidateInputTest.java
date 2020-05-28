package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ValidateInputTest {
    private ByteArrayOutputStream mem = new ByteArrayOutputStream();

    private PrintStream out = System.out;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(mem));
    }

    @After
    public void tearDown() {
        System.setOut(out);
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"invalid", "0"})
        );
        input.askInt("Enter", 1);
        assertThat(
                new String(mem.toByteArray()),
                is(String.format("Please enter validate data again.%n"))
        );
    }

    @Test
    public void whenInvalidInputCallMethodWithOneArgument() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"invalid", "0"})
        );
        input.askInt("Enter");
        assertThat(
                new String(mem.toByteArray()),
                is(String.format("Please enter validate data again.%n"))
        );

    }

    @Test
    public void whenInvalid1Input() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"2", "0"})
        );
        input.askInt("Enter", 1);
        assertThat(
                new String(mem.toByteArray()),
                is(String.format("Please select key from menu %n"))
        );
    }
}
