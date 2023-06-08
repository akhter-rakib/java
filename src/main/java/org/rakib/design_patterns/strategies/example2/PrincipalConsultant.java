package org.rakib.design_patterns.strategies.example2;

public class PrincipalConsultant implements Role {
    @Override
    public String description() {
        return PrincipalConsultant.class.getName();
    }

    @Override
    public String responsibilities() {
        return "Talk to clients";
    }
}
