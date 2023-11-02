package edu.austral.ingsis.math.compose;
import edu.austral.ingsis.math.composite.*;
import edu.austral.ingsis.math.composite.Module;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionWithVariablesTest {

    /**
     * Case 1 + x where x = 3
     */
    @Test
    public void shouldResolveFunction1() {
        Function func = new Sum(new Literal(1), new Variable("x",3));
        final Double result = func.resolution();

        assertThat(result, equalTo(4d));
    }

    /**
     * Case 12 / div where div = 4
     */
    @Test
    public void shouldResolveFunction2() {
        Function func = new Division(new Literal(12), new Variable("div", 4));
        final Double result = func.resolution();

        assertThat(result, equalTo(3d));
    }

    /**
     * Case (9 / x) * y where x = 3 and y = 4
     */
    @Test
    public void shouldResolveFunction3() {
        Function func_1 = new Division(new Literal(9), new Variable("x", 3));
        Function func_2 = new Multiplication(func_1, new Variable("y", 4));
        final Double result = func_2.resolution();

        assertThat(result, equalTo(12d));
    }

    /**
     * Case (27 / a) ^ b where a = 9 and b = 3
     */
    @Test
    public void shouldResolveFunction4() {
        Function func_1 = new Division(new Literal(27), new Variable("a", 9));
        Function func_2 = new Power(func_1, new Variable("b", 3));
        final Double result = func_2.resolution();

        assertThat(result, equalTo(27d));
    }

    /**
     * Case z ^ (1/2) where z = 36
     */
    @Test
    public void shouldResolveFunction5() {
        Function func = new Power(new Variable("z", 36), new Literal(0.5));
        final Double result = func.resolution();

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction6() {
        Function func_1 = new Module(new Variable("value", 8));
        Function func_2 = new Substract(func_1, new Literal(8));
        final Double result = func_2.resolution();

        assertThat(result, equalTo(0d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction7() {
        Function func_1 = new Module(new Variable("value", 8));
        Function func_2 = new Substract(func_1, new Literal(8));
        final Double result = func_2.resolution();

        assertThat(result, equalTo(0d));
    }

    /**
     * Case (5 - i) * 8 where i = 2
     */
    @Test
    public void shouldResolveFunction8() {
        Function func_1 = new Substract(new Literal(5), new Variable("i", 2));
        Function func_2 = new Multiplication(func_1, new Literal(8));
        final Double result = func_2.resolution();

        assertThat(result, equalTo(24d));
    }
}
