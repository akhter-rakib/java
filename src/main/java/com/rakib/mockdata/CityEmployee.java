package com.rakib.mockdata;

public class CityEmployee extends Employee {
    private String city;
    private int age;


    public CityEmployee(String name, Integer salary, String city, int age) {
        super(name, salary);
        this.city = city;
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
