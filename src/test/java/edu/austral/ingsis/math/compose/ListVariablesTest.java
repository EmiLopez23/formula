package edu.austral.ingsis.math.compose;

import edu.austral.ingsis.math.composite.*;
import edu.austral.ingsis.math.composite.Module;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;


public class ListVariablesTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldListVariablesFunction1() {
        Function func_1 = new Literal(1);
        Function func_2 = new Literal(6);
        Function func_3 = new Sum(func_1, func_2);
        final List<String> result = func_3.listVariables();

        assertThat(result, empty());
    }

    /**
     * Case 12 / div
     */
    @Test
    public void shouldListVariablesFunction2() {
        Function func_1 = new Literal(12);
        Function func_2 = new Variable("div", 6);
        Function func_3 = new Division(func_1, func_2);
        final List<String> result = func_3.listVariables();

        assertThat(result, containsInAnyOrder("div"));
    }

    /**
     * Case (9 / x) * y
     */
    @Test
    public void shouldListVariablesFunction3() {
        Function func_1 = new Literal(9);
        Function func_2 = new Variable("x", 6);
        Function func_3 = new Division(func_1, func_2);
        Function func_4 = new Variable("y", 6);
        Function func_5 = new Multiplication(func_3, func_4);
        final List<String> result = func_5.listVariables();

        assertThat(result, containsInAnyOrder("x", "y"));
    }

    /**
     * Case (27 / a) ^ b
     */
    @Test
    public void shouldListVariablesFunction4() {
        Function func_1 = new Literal(27);
        Function func_2 = new Variable("a", 6);
        Function func_3 = new Division(func_1, func_2);
        Function func_4 = new Variable("b", 6);
        Function func_5 = new Power(func_3, func_4);
        final List<String> result = func_5.listVariables();

        assertThat(result, containsInAnyOrder("a", "b"));
    }

    /**
     * Case z ^ (1/2)
     */
    @Test
    public void shouldListVariablesFunction5() {
        Function func_1 = new Variable("z", 6);
        Function func_2 = new Literal(2);
        Function func_3 = new Division(new Literal(1), func_2);
        Function func_4 = new Power(func_1, func_3);
        final List<String> result = func_4.listVariables();

        assertThat(result, containsInAnyOrder("z"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction6() {
        Function func_1 = new Module(new Variable("value", 6));
        Function func_2 = new Literal(8);
        Function func_3 = new Substract(func_1, func_2);
        final List<String> result = func_3.listVariables();

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction7() {
        Function func_1 = new Module(new Variable("value", 6));
        Function func_2 = new Literal(8);
        Function func_3 = new Substract(func_1, func_2);
        final List<String> result = func_3.listVariables();

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldListVariablesFunction8() {
        Function func_1 = new Literal(5);
        Function func_2 = new Variable("i", 6);
        Function func_3 = new Substract(func_1, func_2);
        Function func_4 = new Literal(8);
        Function func_5 = new Multiplication(func_3, func_4);
        final List<String> result = func_5.listVariables();

        assertThat(result, containsInAnyOrder("i"));
    }
}
