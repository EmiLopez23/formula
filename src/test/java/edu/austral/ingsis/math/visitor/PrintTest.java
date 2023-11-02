package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.behaviours.ListVariableVisitor;
import edu.austral.ingsis.math.visitor.behaviours.PrinterVisitor;
import edu.austral.ingsis.math.visitor.functions.*;
import edu.austral.ingsis.math.visitor.functions.Module;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {
    private PrinterVisitor printerVisitor;

    @Before
    public void setUp() {
        printerVisitor = new PrinterVisitor();
    }

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldPrintFunction1() {
        Function function = new Sum(new Literal(1), new Literal(6));
        final String expected = "( 1.0 + 6.0 )";
        final String result = printerVisitor.print(function);

        assertThat(result, equalTo(expected));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldPrintFunction2() {
        Function function = new Division(new Literal(12), new Literal(2));
        final String expected = "( 12.0 / 2.0 )";
        final String result = printerVisitor.print(function);

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldPrintFunction3() {
        Function function = new Multiplication(new Division(new Literal(9), new Literal(2)), new Literal(3));
        final String expected = "( ( 9.0 / 2.0 ) * 3.0 )";
        final String result = printerVisitor.print(function);

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldPrintFunction4() {
        Function function = new Power(new Division(new Literal(27), new Literal(6)), new Literal(2));
        final String expected = "( ( 27.0 / 6.0 ) ^ 2.0 )";
        final String result = printerVisitor.print(function);

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction6() {
        Function function = new Subtract(new Module(new Variable("value",1.0)), new Literal(8));
        final String expected = "( |value| - 8.0 )";
        final String result = printerVisitor.print(function);

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction7() {
        Function function = new Subtract(new Module(new Variable("value",1.0)), new Literal(8));
        final String expected = "( |value| - 8.0 )";
        final String result = printerVisitor.print(function);

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldPrintFunction8() {
        Function function = new Multiplication(new Subtract(new Literal(5), new Variable("i",1.0)), new Literal(8));
        final String expected = "( ( 5.0 - i ) * 8.0 )";
        final String result = printerVisitor.print(function);

        assertThat(result, equalTo(expected));
    }
}
