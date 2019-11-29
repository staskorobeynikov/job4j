package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SqMaxTest {
    // тесты с максимальным значением первого значения
    // разные комбинации остальным чисел
    @Test
    public void whenFirstMax(){
        SqMax check = new SqMax();
        int result = check.max(4,1,2,3);
        assertThat(result, is(4));
    }
    @Test
    public void whenFirstMax1(){
        SqMax check = new SqMax();
        int result = check.max(4,1,3,2);
        assertThat(result, is(4));
    }
    @Test
    public void whenFirstMax2(){
        SqMax check = new SqMax();
        int result = check.max(4,2,1,3);
        assertThat(result, is(4));
    }
    @Test
    public void whenFirstMax3(){
        SqMax check = new SqMax();
        int result = check.max(4,2,3,1);
        assertThat(result, is(4));
    }
    @Test
    public void whenFirstMax4(){
        SqMax check = new SqMax();
        int result = check.max(4,3,1,2);
        assertThat(result, is(4));
    }
    @Test
    public void whenFirstMax5(){
        SqMax check = new SqMax();
        int result = check.max(4,3,2,1);
        assertThat(result, is(4));
    }
    // тесты с максимальным значением второго значения
    // разные комбинации остальным чисел
    @Test
    public void whenSecondMax(){
        SqMax check = new SqMax();
        int result = check.max(1,4,2,3);
        assertThat(result, is(4));
    }
    @Test
    public void whenSecondMax1(){
        SqMax check = new SqMax();
        int result = check.max(1,4,3,2);
        assertThat(result, is(4));
    }
    @Test
    public void whenSecondMax2(){
        SqMax check = new SqMax();
        int result = check.max(2,4,1,3);
        assertThat(result, is(4));
    }
    @Test
    public void whenSecondMax3(){
        SqMax check = new SqMax();
        int result = check.max(2,4,3,1);
        assertThat(result, is(4));
    }
    @Test
    public void whenSecondMax4(){
        SqMax check = new SqMax();
        int result = check.max(3,4,1,2);
        assertThat(result, is(4));
    }
    @Test
    public void whenSecondMax5(){
        SqMax check = new SqMax();
        int result = check.max(3,4,2,1);
        assertThat(result, is(4));
    }
    // тесты с максимальным значением третьего значения
    // разные комбинации остальным чисел
    @Test
    public void whenThirdMax(){
        SqMax check = new SqMax();
        int result = check.max(1,2,4,3);
        assertThat(result, is(4));
    }
    @Test
    public void whenThirdMax1(){
        SqMax check = new SqMax();
        int result = check.max(1,3,4,2);
        assertThat(result, is(4));
    }
    @Test
    public void whenThirdMax2(){
        SqMax check = new SqMax();
        int result = check.max(2,1,4,3);
        assertThat(result, is(4));
    }
    @Test
    public void whenThirdMax3(){
        SqMax check = new SqMax();
        int result = check.max(2,3,4,1);
        assertThat(result, is(4));
    }
    @Test
    public void whenThirdMax4(){
        SqMax check = new SqMax();
        int result = check.max(3,1,4,2);
        assertThat(result, is(4));
    }
    @Test
    public void whenThirdMax5(){
        SqMax check = new SqMax();
        int result = check.max(3,2,4,1);
        assertThat(result, is(4));
    }
    // тесты с максимальным значением четвертого значения
    // разные комбинации остальным чисел
    @Test
    public void whenForthMax(){
        SqMax check = new SqMax();
        int result = check.max(1,2,3,4);
        assertThat(result, is(4));
    }
    @Test
    public void whenForthMax1(){
        SqMax check = new SqMax();
        int result = check.max(1,3,2,4);
        assertThat(result, is(4));
    }
    @Test
    public void whenForthMax2(){
        SqMax check = new SqMax();
        int result = check.max(2,1,3,4);
        assertThat(result, is(4));
    }
    @Test
    public void whenForthMax3(){
        SqMax check = new SqMax();
        int result = check.max(2,3,1,4);
        assertThat(result, is(4));
    }
    @Test
    public void whenForthMax4(){
        SqMax check = new SqMax();
        int result = check.max(3,1,2,4);
        assertThat(result, is(4));
    }
    @Test
    public void whenForthMax5(){
        SqMax check = new SqMax();
        int result = check.max(3,2,1,4);
        assertThat(result, is(4));
    }
    // пример который выполнен согласно комментарию.
    @Test
    public void whenThird12Max(){
        SqMax check = new SqMax();
        int result = check.max(10,7,12,1);
        assertThat(result, is(12));
    }
}
