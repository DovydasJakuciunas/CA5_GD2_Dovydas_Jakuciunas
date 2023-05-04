package com.dkit.gd2.dovydas.dto;

public class People
{
    //Name,Record, age for all the poeple in the database
    private String firstName;
    private String lastName;
    private int record;
    private int age;

    public People(String firstName, String lastName, int record, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.record = record;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getRecord() {
        return record;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "People{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", record=" + record +
                ", age=" + age +
                '}';
    }
}
