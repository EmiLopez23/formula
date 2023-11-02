package edu.austral.ingsis.math.composite;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Variable implements Function {

    private final String name;
    private final double value;

    public Variable(String name, double value) {
        this.name = name;
        this.value = value;
    }
    @Override
    public double resolution() {
        return value;
    }

    @Override
    public String print() {
        return name;
    }

    @Override
    public List<String> listVariables() {
        return List.of(name);
    }
}
