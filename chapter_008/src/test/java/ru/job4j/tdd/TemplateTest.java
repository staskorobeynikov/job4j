package ru.job4j.tdd;

import org.junit.Test;

import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TemplateTest {

    @Test
    public void whenTemplateContainsOneValueForReplace() throws Exception {
        Template template = new SimpleGenerator();
        String text = "Hello, ${name}.";
        Map<String, String> data = Map.of(
                "${name}", "Stas"
        );

        String checked = "Hello, Stas.";
        String result = template.generate(text, data);

        assertThat(result, is(checked));
    }

    @Test
    public void whenTemplateContainsManyValuesForReplaceWithIdenticalKeys() throws Exception {
        Template template = new SimpleGenerator();
        String text = "Help, ${sos}, ${sos}, ${sos}";
        Map<String, String> data = Map.of(
                "${sos}", "Aaaa"
        );

        String checked = "Help, Aaaa, Aaaa, Aaaa";
        String result = template.generate(text, data);

        assertThat(result, is(checked));
    }

    @Test
    public void whenTemplateContainsManyValuesForReplaceWithDifferentKeys() throws Exception {
        Template template = new SimpleGenerator();
        String text = "Hello, ${name}, Who are ${subject}?";
        Map<String, String> data = Map.of(
                "${name}", "Stas",
                "${subject}", "you"
        );

        String checked = "Hello, Stas, Who are you?";
        String result = template.generate(text, data);

        assertThat(result, is(checked));
    }

    @Test(expected = Exception.class)
    public void whenTemplateContainsOneValueForReplaceAndMapNotContainsKeysThenException() throws Exception {
        Template template = new SimpleGenerator();
        String text = "Hello, ${name}.";
        Map<String, String> data = Map.of();

        String checked = "Hello, Stas.";
        String result = template.generate(text, data);

        assertThat(result, is(checked));
    }

    @Test(expected = Exception.class)
    public void whenTemplateContainsOneValueForReplaceAndMapContainsManyKeysThenException() throws Exception {
        Template template = new SimpleGenerator();
        String text = "Hello, ${name}.";
        Map<String, String> data = Map.of(
                "${name}", "Stas",
                "${subject}", "you"
        );

        String checked = "Hello, Stas.";
        String result = template.generate(text, data);

        assertThat(result, is(checked));
    }
}