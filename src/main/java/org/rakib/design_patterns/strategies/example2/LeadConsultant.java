package org.rakib.design_patterns.strategies.example2;

public class LeadConsultant implements Role {
    @Override
    public String description() {
        return LeadConsultant.class.getName();
    }

    @Override
    public String responsibilities() {
        return "Leading the Team";
    }
}
