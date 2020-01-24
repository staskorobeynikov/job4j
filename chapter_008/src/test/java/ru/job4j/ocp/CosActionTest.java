package ru.job4j.ocp;

import org.junit.Test;
import ru.job4j.srp.Input;
import ru.job4j.srp.StubInput;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CosActionTest {
    @Test
    public void whenInputOneNumbersResultPreviousOperationIsNull() {
        CosAction cos = new CosAction();
        EngineeringCalculator engCalc = new EngineeringCalculator();
        double result;
        List<String> answers = Collections.singletonList("50");
        Input input = new StubInput(answers);
        double resultAdd = 0;
        result = cos.execute(input, engCalc, resultAdd);
        assertEquals(result, 0.643, 0.01);
    }

    @Test
    public void whenInputNotNumberResultPreviousOperationNotNull() {
        CosAction cos = new CosAction();
        EngineeringCalculator engCalc = new EngineeringCalculator();
        double result;
        List<String> answers = Collections.singletonList("y");
        Input input = new StubInput(answers);
        double resultAdd = 25;
        result = cos.execute(input, engCalc, resultAdd);
        assertEquals(result, 0.906, 0.01);
    }

    @Test
    public void whenGetName() {
        CosAction cos = new CosAction();

        String result = cos.name();

        assertThat(result, is("Cosine"));
    }
}