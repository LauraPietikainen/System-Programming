package com.example.systemprogramming.lecture4;

public class Person {

    private Integer firstName;
    private String lastName;

    private int bornYear;

    public Integer getFirstName() {
        return firstName;
    }

    public void setThreadId(int firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setProgress(String lastName) {
        this.lastName = lastName;
    }

    public int getBornYear() {
        return bornYear;
    }

    public void setBornYear(int bornYear) {
        this.bornYear = bornYear;
    }

    @Override
    public String toString() {
        return "Thread Id: " + firstName + " " + "Progress: " ;
    }
}
