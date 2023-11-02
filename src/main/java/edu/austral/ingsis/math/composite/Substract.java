package edu.austral.ingsis.math.composite;

public class Substract extends ComposeFunction{
    public Substract(Function first_argument, Function second_argument) {
        super(first_argument, second_argument);
    }

    @Override
    String getOperator() {
        return "-";
    }

    @Override
    public double resolution() {
        return getFirstArgument().resolution() - getSecondArgument().resolution();
    }
}
