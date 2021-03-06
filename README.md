# Учебный репозиторий по курсу [job4j](https://job4j.ru/courses/java_with_zero_to_job.html).
[![Build Status](https://travis-ci.com/staskorobeynikov/job4j.svg?branch=master)](https://travis-ci.com/staskorobeynikov/job4j)
[![codecov](https://codecov.io/gh/staskorobeynikov/job4j/branch/master/graph/badge.svg)](https://codecov.io/gh/staskorobeynikov/job4j)

### Chapter_001. Базовый синтаксис.
1. **Типы данных:**
    - Элеменарный калькулятор;
    - Конвертер валют;
    - Площадь треугольника.
2. **Тестирование:** 
    - Модульные тесты;
    - Тесты для площади треугольника.
3. **Автоматическая сборка, Maven:**
    - Подключение сборщика Maven;
    - Зависимости;
    - Интеграция Maven и IDEA.
4. **Хранение исходного кода. GIT:**
    - Создание репозитория, привязка к GitHub;
    - Создание коммитов;
    - Интеграция Git и IDEA.
5. **Условные операторы:**
    - Глубый бот;
    - Максимум из двух-трех чисел;
    - Отладка программы в IDEA.
6. **Циклы:**
    - Подсчет суммы четных чисел;
    - Вычисление факториала;
    - Подсчет количества простых чисел;
    - JavaDoc. Code convention.
7. **Массивы:**
    - Заполнение массива степенями чисел;
    - Отражение массива в обратном порядке;
    - Слово начинается/заканчивается символом;
    - Поиск минимального числа в массиве/диапазоне элементов массива;
    - Двухмерный массив;
    - Checkstyle.
8. **Контрольные вопросы и тестовое задание:**
    - Сокобан: выигрышные комбинации, реализация логики.
    - Объединение двух массивов. [|click|](https://github.com/staskorobeynikov/job4j/commit/f8ba82b66072bdd357cf61e8c1968743bbe561e8)

### Chapter_002. Объектно-ориентированное программирование.
1. **Инструменты:**
    - Создание веток в Git;
    - Объединение коммитов;
    - Слияние веток, разрешение конфликтов слияния;
2. **Классы:**
    - Создание объектов класса;
    - Вызов метода:метод с аргументами, метод с возвращаемым типом;
    - Локальные переменные и поля, зона видимости переменных.
3. **Наследование:**
    - Конструкторы: по умолчанию, перегрузка конструктора;
    - Переопределение, аннотация @Override.
4.  **Инкапсуляция:**
    - Модель данных;
    - Сравнение моделей, метод equals;
    - Реализация класса Tracker.
5. **Полиморфизм:**
    - Класс Scanner и чтение с консоли;
    - Интерфейс Input для проекта Tracker;
    - Приведение типов: нисходящее и восходящее;
    - Создание Manifest для проекта Tracker;
    - Тестирование проекта Tracker с использованием шаблона Стратегия.
    - Использование в тестах аннотаций @Before и @After.
6. **Исключения:**
    - Пользовательские исключения;
    - Иерархия исключений;
    - Тестирование исключение с JUnit;
    - Обеспечение бесперебойной работы приложения Tracker.
7. **Шаблоны проектирования:**
    - Singleton;
    - Фабричный метод, абстрактная фабрика.
8. **Контрольные вопросы и тестовое задание:**
    - Каркас шахматной доски: реализация логики;
    - Автомат по выдаче сдачи. [|click|](https://github.com/staskorobeynikov/job4j/commit/ca6068cfd5dcbcf96372d775b9aa4c8069aec1ac)

### Chapter_003. Collections. Lite.
1. **Collections Framework:**
    - Очередь с приоритетом на LinkedList;
    - Конвертация ArrayList в двухмерный массив и обратно.
2. **Обобщения:**
    - Преобразование List в Map.
3. **Сортировка:**
    - Сортировка User: реализация интерфейса Comparable;
    - Сортировка User: использование интерфейса Comparator;
    - Компаратор для строк.
4. **Инструменты:**
    - Jacoco. Процент покрытия проекта тестами;
    - Travis CI.
5. **Контрольные вопросы и тестовое задание:**
    - Реализация сервиса банковских переводов; [|click|](https://github.com/staskorobeynikov/job4j/tree/master/chapter_003/src/main/java/ru/job4j/collection/bank)
    - Реализация класса по сортировке департаментов. [|click|](https://github.com/staskorobeynikov/job4j/commit/b4a2119a133dbdc085fe22d933b554709fefd01d)

### Chapter_004. Функциональное программирование. Lambda. Stream API.
1. **Lambda:**
    - Функциональные интерфейсы, ссылки на методы;
    - Зона видимости в лямбда и исключения;
    - Подсчет функции в диапазоне.
2. **Stream API:**
    - Фильтрация и сортировка;
    - Преобразование List в Map;
    - Преобразование матрицы чисел в список чисел.
3. **JDK 1.9, 1.10:**
    - Local-Variable Type Inference;
    - Улучшения Stream API и Collection API.
4. **Контрольные вопросы и тестовое задание:**
    - Крестики-нолики на JavaFX: реализация логики;
    - Группировка студентов по интересам. [|click|](https://github.com/staskorobeynikov/job4j/commit/a6fac4bbf73c34c3e20e653a353274f61fffcf7b)

### Chapter_005. Collections. Pro.  
1. **Iterator:**
    - Итератор для двумерного массива;
    - Итератор для четных чисел.
2. **Generic:**
    - Реализация SimpleArray<T>;
3. **List:**
    - Динамический список на базе массива;
    - Контейнер [LinkedListContainer<E>](https://github.com/staskorobeynikov/job4j/blob/master/chapter_005/src/main/java/ru/job4j/list/LinkedListContainer.java) на базе связаного списка;
    - Контейнер [SimpleStack<E>](https://github.com/staskorobeynikov/job4j/blob/master/chapter_005/src/main/java/ru/job4j/list/SimpleStack.java) на базе контейнера LinkedListContainer<E>;
    - Очередь [SimpleQueue<E>](https://github.com/staskorobeynikov/job4j/blob/master/chapter_005/src/main/java/ru/job4j/list/SimpleQueue.java) на двух стеках SimpleStack<E>.
4. **Set:**
    - Коллекция [SimpleSet<E>](https://github.com/staskorobeynikov/job4j/blob/master/chapter_005/src/main/java/ru/job4j/set/SimpleSet.java) реализация на массиве.
5. **Map:**
    - Переопределение методов equals() и hashcode();
    - Коллизии Map;
    - Реализация структуры [SimpleHashMap<K, V>](https://github.com/staskorobeynikov/job4j/blob/master/chapter_005/src/main/java/ru/job4j/map/SimpleHashMap.java).
6. **Tree:**
    - Создание элементарной структуры дерева.
7. **Контрольные вопросы и тестовое задание:**
    - Статистика по коллекции: определить разницу между начальным и измененным состоянием массива;
    - Задание [Почта](https://github.com/staskorobeynikov/job4j/blob/master/chapter_005/src/main/java/ru/job4j/exam/Post.java): объединить пользователей, у которых совпадают email.