package ru.job4j.ocp;

import org.junit.Test;
import ru.job4j.srp.Input;
import ru.job4j.srp.StubInput;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class SinActionTest {
    @Test
    public void whenInputOneNumbersResultPreviousOperationIsNull() {
        SinAction sin = new SinAction();
        EngineeringCalculator engCalc = new EngineeringCalculator();
        double result;
        List<String> answers = Collections.singletonList("50");
        Input input = new StubInput(answers);
        double resultAdd = 0;
        result = sin.execute(input, engCalc, resultAdd);
        assertEquals(result, 0.766, 0.01);
    }

    @Test
    public void whenInputNotNumberResultPreviousOperationNotNull() {
        SinAction sin = new SinAction();
        EngineeringCalculator engCalc = new EngineeringCalculator();
        double result;
        List<String> answers = Collections.singletonList("y");
        Input input = new StubInput(answers);
        double resultAdd = 25;
        result = sin.execute(input, engCalc, resultAdd);
        assertEquals(result, 0.423, 0.01);
    }
}