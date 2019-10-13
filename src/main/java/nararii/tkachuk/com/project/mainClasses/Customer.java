package main.java.nararii.tkachuk.com.project.mainClasses;

import project.csvFiles.CSVFormats;
import project.csvFiles.CSVSerializable;

public class Customer extends Person implements CSVSerializable {
    private String phoneNumber;

    private java.lang.Object Object;

    public Customer(String firstName, String lastName, int id, String phoneNumber) {
        super(firstName, String.format(lastName), id);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "First name = '" + firstName + '\'' +
                ", Last name = '" + lastName + '\'' +
                ", ID = " + id +
                ", phone number = +380" + phoneNumber +
                '}';
    }

    @Override
    public String toCSVString() {
        return String.format(CSVFormats.CUSTOMER.getFormatValue(), firstName+",", lastName+",", id+",", phoneNumber);
//        return firstName + "," + lastName + "," + id + "," + phoneNumber;
//        return String.format("%-15s%-15s%-15s%-15s%n", firstName, lastName, id, phoneNumber);
    }
    public String toFileString() {
        return firstName + "," + lastName + "," + id + "," + phoneNumber;
    }




    public String[] getFields(Customer customer) {
        String[] o = new String[4];
        o[0] = customer.getFirstName() + ",";
        o[1] = customer.getLastName() + ",";
        o[2] = customer.getId() + ",";
        o[3] = customer.getPhoneNumber() + ",";
        return o;
    }

    public static String[] getFormatObjects() {
        String[] titles = new String[4];

        titles[0] = "FIRST NAME";
        titles[1] = "LAST NAME";
        titles[2] = "ID";
        titles[3] = "PHONE NUMBER";
        return titles;
    }
}
