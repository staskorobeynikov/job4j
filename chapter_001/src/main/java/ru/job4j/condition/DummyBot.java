package ru.job4j.condition;

public class DummyBot {
    public static String answer(String question) {
        String result = "Это ставит меня в тупик. Задайте другой вопрос.";
        if ("Привет, Бот.".equals(question)) {
            result = "Привет, умник.";
        }  else if ("Пока.".equals(question)) {
            result = "До скорой встречи!";
        }
        return result;
    }
}
