package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.behaviours.ListVariableVisitor;
import edu.austral.ingsis.math.visitor.functions.*;
import edu.austral.ingsis.math.visitor.functions.Module;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;


public class ListVariablesTest {
    private ListVariableVisitor variableListerVisitor;

    @Before
    public void setUp() {
        variableListerVisitor = new ListVariableVisitor();
    }

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldListVariablesFunction1() {
        Function function = new Sum(new Literal(1), new Literal(6));
        final List<String> result = variableListerVisitor.getVariables(function);

        assertThat(result, empty());
    }

    /**
     * Case 12 / div
     */
    @Test
    public void shouldListVariablesFunction2() {
        Function function = new Sum(new Literal(12), new Variable("div",1.0));
        final List<String> result = variableListerVisitor.getVariables(function);

        assertThat(result, containsInAnyOrder("div"));
    }

    /**
     * Case (9 / x) * y
     */
    @Test
    public void shouldListVariablesFunction3() {
        Function function = new Sum(new Division(new Literal(9), new Variable("x",1.0)), new Variable("y",1.0));
        final List<String> result = variableListerVisitor.getVariables(function);

        assertThat(result, containsInAnyOrder("x", "y"));
    }

    /**
     * Case (27 / a) ^ b
     */
    @Test
    public void shouldListVariablesFunction4() {
        Function function = new Sum(new Division(new Literal(27), new Variable("a",1.0)), new Variable("b",1.0));
        final List<String> result = variableListerVisitor.getVariables(function);

        assertThat(result, containsInAnyOrder("a", "b"));
    }

    /**
     * Case z ^ (1/2)
     */
    @Test
    public void shouldListVariablesFunction5() {
        Function function = new Sum(new Variable("z",1.0), new Division(new Literal(1), new Literal(2)));
        final List<String> result = variableListerVisitor.getVariables(function);

        assertThat(result, containsInAnyOrder("z"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction6() {
        Function function = new Subtract(new Module(new Variable("value",1.0)), new Literal(8));
        final List<String> result = variableListerVisitor.getVariables(function);

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction7() {
        Function function = new Subtract(new Module(new Variable("value",1.0)), new Literal(8));
        final List<String> result = variableListerVisitor.getVariables(function);

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldListVariablesFunction8() {
        Function function = new Multiplication(new Subtract(new Literal(5), new Variable("i",1.0)), new Literal(8));
        final List<String> result = variableListerVisitor.getVariables(function);

        assertThat(result, containsInAnyOrder("i"));
    }
}
