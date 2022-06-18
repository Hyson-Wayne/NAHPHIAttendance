package com.hysonwayne.nahpiattendance;

public class Users {

    String fullName, registrationNumber, department;

    public Users() {
    }

    public Users(String fullName, String registrationNumber, String department) {
        this.fullName = fullName;
        this.registrationNumber = registrationNumber;
        this.department = department;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
