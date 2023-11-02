package edu.austral.ingsis.math.composite;

public class Power extends ComposeFunction{
    public Power(Function first_argument, Function second_argument) {
        super(first_argument, second_argument);
    }

    @Override
    String getOperator() {
        return "^";
    }

    @Override
    public double resolution() {
        return Math.pow(getFirstArgument().resolution(), getSecondArgument().resolution());
    }
}
