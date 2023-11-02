package edu.austral.ingsis.math.composite;

import java.util.List;

public class Module implements Function{
    private final Function function;

    public Module(Function function) {
        this.function = function;
    }
    @Override
    public double resolution() {
        return Math.abs(function.resolution());
    }

    @Override
    public String print() {
        return "|" + function.print() + "|";
    }

    @Override
    public List<String> listVariables() {
        return function.listVariables();
    }
}
