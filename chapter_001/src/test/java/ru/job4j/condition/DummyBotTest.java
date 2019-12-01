package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DummyBotTest {
    @Test
    public void whenGreetBot() {
        assertThat(DummyBot.answer("Привет, Бот."),
                is("Привет, умник."));
    }
    @Test
    public void whenGreetBotErr() {
        // не совпадает формулировка вопроса,
        // но в ответе мы указываем правильный ответ бота
        assertThat(DummyBot.answer("Привет, Бот"),
                is("Это ставит меня в тупик. Задайте другой вопрос."));
    }
    @Test
    public void whenByeBot() {
        assertThat(DummyBot.answer("Пока."),
                is("До скорой встречи!"));
    }
    @Test
    public void whenByeBotErr() {
        assertThat(DummyBot.answer("Пока."),
                is("Привет, умник."));
        // вопрос задан правильно, однако ответ из другого блока.
        // тест кидает ошибку.
    }
    @Test
    public void whenUnknownBot() {
        assertThat(DummyBot.answer("Сколько будет 2+2?"),
                is("Это ставит меня в тупик. "
                        +
                        "Задайте другой вопрос."));
    }

}
