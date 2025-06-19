package com.transport.trunsport_company;

public class DriverData {
    private static int idCounter = 1;
    private int id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String licenseNumber;
    public DriverData(String firstName, String lastName, String middleName, String licenseNumber) {
        this.id = idCounter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.licenseNumber = licenseNumber;
    }
    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getMiddleName() { return middleName; }
    public String getLicenseNumber() { return licenseNumber; }
}