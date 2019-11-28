package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenMax4To2Then4(){
        // первое значение больше второго
        // и равно заданному значению для проверки
        int result = Max.max(4,2);
        assertThat(result, is(4));
    }
    @Test
    public void whenMax5To8Then8(){
        // второе значение больше первого
        // и равно заданному значению для проверки
        int result = Max.max(5,8);
        assertThat(result, is(8));
    }
    @Test
    public void whenMax7To7Then7(){
        // значения равны
        // и равны заданному значению для проверки
        int result = Max.max(7,7);
        assertThat(result, is(7));
    }
    @Test
    public void whenMax7To7Then4(){
        // значения равны
        // и не равны заданному значению для проверки
        // проверка кидает ошибку, метод возвращает значение 7
        int result = Max.max(7,7);
        assertThat(result, is(4));
    }

}
