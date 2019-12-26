package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("name"),
                is("Petr Arsentev")
        );
        assertThat(config.value("first"),
                is("Stas Korobeynikov"));
        assertThat(config.value("1"),
                is("green"));
        assertThat(config.value("second"),
                is("Begemot"));
    }

    @Test
    public void whenPairWithComment() {
        String path = "./data/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("name"),
                is("Petr Arsentev")
        );
        assertThat(config.value("first"),
                is("Stas Korobeynikov"));
        assertThat(config.value("1"),
                is("green"));
        assertThat(config.value("second"),
                is("Begemot"));
    }
}