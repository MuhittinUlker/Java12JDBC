package com.muhittinu.entitiy;

import java.util.Date;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private Date joinedDate;
    private String eMail;

    public Person() {
    }

    public Person(String firstName, String lastName, String eMail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
    }

    public Person(int id, String firstName, String lastName, Date joinedDate, String eMail) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.joinedDate = joinedDate;
        this.eMail = eMail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", joinedDate=" + joinedDate +
                ", eMail='" + eMail + '\'' +
                '}';
    }
}
