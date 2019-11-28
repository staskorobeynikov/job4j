package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MultiMaxTest {
    @Test
    public void whenSecondMax(){
        MultiMax check = new MultiMax();
        int result = check.max(1,4,2);
        assertThat(result, is(4));
    }
    @Test
    public void whenFirstMax(){
        MultiMax check = new MultiMax();
        int result = check.max(5,2,4);
        assertThat(result, is(5));
    }
    @Test
    public void whenThirdMax(){
        MultiMax check = new MultiMax();
        int result = check.max(1,8,10);
        assertThat(result, is(10));
    }
    @Test
    public void whenAllEquals(){
        MultiMax check = new MultiMax();
        int result = check.max(6,6,6);
        assertThat(result, is(6));
    }
}
