package edu.austral.ingsis.math.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class ComposeFunction implements Function{
    private final Function first_argument;
    private final Function second_argument;
    public ComposeFunction(Function first_argument, Function second_argument) {
        this.first_argument = first_argument;
        this.second_argument = second_argument;
    }

    @Override
    public String print() {
        return "(" + first_argument.print() + " " +  getOperator() + " " + second_argument.print() + ")";
    }

    @Override
    public List<String> listVariables() {
        List<String> variables = new ArrayList<>(first_argument.listVariables());
        variables.addAll(second_argument.listVariables());
        return variables;
    }

    public Function getFirstArgument() {
        return first_argument;
    }

    public Function getSecondArgument() {
        return second_argument;
    }

    abstract String getOperator();
}
