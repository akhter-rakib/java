package org.rakib.design_patterns.strategies.example2;

public class Consultant implements Role {
    @Override
    public String description() {
        return Consultant.class.getName();
    }

    @Override
    public String responsibilities() {
        return "Consultant Responsibility";
    }
}
