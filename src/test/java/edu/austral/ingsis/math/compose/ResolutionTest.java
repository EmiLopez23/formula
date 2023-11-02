package edu.austral.ingsis.math.compose;

import edu.austral.ingsis.math.composite.*;
import edu.austral.ingsis.math.composite.Module;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldResolveSimpleFunction1() {
        Function func = new Sum(new Literal(1), new Literal(6));
        final Double result = func.resolution();

        assertThat(result, equalTo(7d));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldResolveSimpleFunction2() {
        Function func = new Division(new Literal(12), new Literal(2));
        final Double result = func.resolution();

        assertThat(result, equalTo(6d));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldResolveSimpleFunction3() {
        Function func_1 = new Division(new Literal(9), new Literal(2));
        Function func_2 = new Multiplication(func_1, new Literal(3));
        final Double result = func_2.resolution();

        assertThat(result, equalTo(13.5d));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldResolveSimpleFunction4() {
        Function func_1 = new Division(new Literal(27), new Literal(6));
        Function func_2 = new Power(func_1, new Literal(2));
        final Double result = func_2.resolution();

        assertThat(result, equalTo(20.25d));
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    public void shouldResolveSimpleFunction5() {
        Function func_1 = new Power(new Literal(36), new Division(new Literal(1), new Literal(2)));
        final Double result = func_1.resolution();

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |136|
     */
    @Test
    public void shouldResolveSimpleFunction6() {
        Function func = new Module(new Literal(136));
        final Double result = func.resolution();

        assertThat(result, equalTo(136d));
    }

    /**
     * Case |-136|
     */
    @Test
    public void shouldResolveSimpleFunction7() {
        Function func = new Module(new Literal(-136));
        final Double result = func.resolution();

        assertThat(result, equalTo(136d));
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    public void shouldResolveSimpleFunction8() {
        Function func_1 = new Substract(new Literal(5), new Literal(5));
        Function func_2 = new Multiplication(func_1, new Literal(8));
        final Double result = func_2.resolution();

        assertThat(result, equalTo(0d));
    }
}
