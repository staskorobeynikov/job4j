package ru.job4j.ocp;

import org.junit.Test;
import ru.job4j.srp.*;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class TanActionTest {
    @Test
    public void whenInputOneNumbersResultPreviousOperationIsNull() {
        TanAction tn = new TanAction();
        EngineeringCalculator engCalc = new EngineeringCalculator();
        double result;
        List<String> answers = Collections.singletonList("10");
        Input input = new StubInput(answers);
        double resultAdd = 0;
        result = tn.execute(input, engCalc, resultAdd);
        assertEquals(result, 0.176, 0.01);
    }

    @Test
    public void whenInputNotNumberResultPreviousOperationNotNull() {
        TanAction tn = new TanAction();
        EngineeringCalculator engCalc = new EngineeringCalculator();
        double result;
        List<String> answers = Collections.singletonList("y");
        Input input = new StubInput(answers);
        double resultAdd = 25;
        result = tn.execute(input, engCalc, resultAdd);
        assertEquals(result, 0.466, 0.01);
    }
}