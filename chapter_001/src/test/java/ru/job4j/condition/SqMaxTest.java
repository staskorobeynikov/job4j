package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SqMaxTest {
    @Test
    public void whenFirstMax(){
        SqMax check = new SqMax();
        int result = check.max(10,7,4,1);
        assertThat(result, is(10));
    }
    @Test
    public void whenSecondMax(){
        SqMax check = new SqMax();
        int result = check.max(7,10,4,1);
        assertThat(result, is(10));
    }
    @Test
    public void whenThirdMax(){
        SqMax check = new SqMax();
        int result = check.max(4,7,10,1);
        assertThat(result, is(10));
    }
    @Test
    public void whenForthMax(){
        SqMax check = new SqMax();
        int result = check.max(7,4,1,10);
        assertThat(result, is(10));
    }
}
