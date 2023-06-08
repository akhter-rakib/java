package org.rakib.design_patterns.strategies.example2;

public class Main {
    public static void main(String[] args) {
        Employee ram = new Employee("Ram", new Consultant());
        Employee rahul = new Employee("Rahul", new Consultant());

        System.out.println("=======Before promotion=======\n");

        ram.doWork();
        rahul.doWork();

        ram.promote(new Consultant());
        rahul.promote(new LeadConsultant());

        System.out.println("\n=======After promotion=======\n");

        ram.doWork();
        rahul.doWork();
    }
}
