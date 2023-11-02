package edu.austral.ingsis.math.compose;

import edu.austral.ingsis.math.composite.*;

import edu.austral.ingsis.math.composite.Module;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldPrintFunction1() {
        Function func = new Sum(new Literal(1), new Literal(6));
        final String expected = "(1 + 6)";
        final String result = func.print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldPrintFunction2() {
        Function func = new Division(new Literal(12), new Literal(2));
        final String expected = "(12 / 2)";
        final String result = func.print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldPrintFunction3() {
        Function func_1 = new Division(new Literal(9), new Literal(2));
        Function func_2 = new Multiplication(func_1, new Literal(3));
        final String expected = "((9 / 2) * 3)";
        final String result = func_2.print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldPrintFunction4() {
        Function func_1 = new Division(new Literal(27), new Literal(6));
        Function func_2 = new Power(func_1, new Literal(2));
        final String expected = "((27 / 6) ^ 2)";
        final String result = func_2.print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction6() {
        Function func_1 = new Module(new Variable("value", 6));
        Function func_2 = new Substract(func_1, new Literal(8));
        final String expected = "(|value| - 8)";
        final String result = func_2.print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction7() {
        Function func_1 = new Module(new Variable("value", 6));
        Function func_2 = new Substract(func_1, new Literal(8));
        final String expected = "(|value| - 8)";
        final String result = func_2.print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldPrintFunction8() {
        Function func_1 = new Substract(new Literal(5), new Variable("i", 6));
        Function func_2 = new Multiplication(func_1, new Literal(8));
        final String expected = "((5 - i) * 8)";
        final String result = func_2.print();

        assertThat(result, equalTo(expected));
    }
}
