package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.behaviours.EvaluateVisitor;
import edu.austral.ingsis.math.visitor.functions.*;
import edu.austral.ingsis.math.visitor.functions.Module;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldResolveSimpleFunction1() {
        EvaluateVisitor evaluateVisitor = new EvaluateVisitor();
        Function function = new Sum(new Literal(1), new Literal(6));
        final Double result = evaluateVisitor.evaluate(function);

        assertThat(result, equalTo(7d));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldResolveSimpleFunction2() {
        EvaluateVisitor evaluateVisitor = new EvaluateVisitor();
        Function function = new Division(new Literal(12), new Literal(2));
        final Double result = evaluateVisitor.evaluate(function);

        assertThat(result, equalTo(6d));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldResolveSimpleFunction3() {
        EvaluateVisitor evaluateVisitor = new EvaluateVisitor();
        Function function = new Multiplication(new Division(new Literal(9), new Literal(2)), new Literal(3));
        final Double result = evaluateVisitor.evaluate(function);

        assertThat(result, equalTo(13.5d));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldResolveSimpleFunction4() {
        EvaluateVisitor evaluateVisitor = new EvaluateVisitor();
        Function function = new Power(new Division(new Literal(27), new Literal(6)), new Literal(2));
        final Double result = evaluateVisitor.evaluate(function);

        assertThat(result, equalTo(20.25d));
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    public void shouldResolveSimpleFunction5() {
        EvaluateVisitor evaluateVisitor = new EvaluateVisitor();
        Function function = new Power(new Literal(36), new Division(new Literal(1), new Literal(2)));
        final Double result = evaluateVisitor.evaluate(function);

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |136|
     */
    @Test
    public void shouldResolveSimpleFunction6() {
        EvaluateVisitor evaluateVisitor = new EvaluateVisitor();
        Function function = new Module(new Literal(136));
        final Double result = evaluateVisitor.evaluate(function);

        assertThat(result, equalTo(136d));
    }

    /**
     * Case |-136|
     */
    @Test
    public void shouldResolveSimpleFunction7() {
        EvaluateVisitor evaluateVisitor = new EvaluateVisitor();
        Function function = new Module(new Literal(-136));
        final Double result = evaluateVisitor.evaluate(function);

        assertThat(result, equalTo(136d));
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    public void shouldResolveSimpleFunction8() {
        EvaluateVisitor evaluateVisitor = new EvaluateVisitor();
        Function function = new Multiplication(new Subtract(new Literal(5), new Literal(5)), new Literal(8));
        final Double result = evaluateVisitor.evaluate(function);

        assertThat(result, equalTo(0d));
    }
}
