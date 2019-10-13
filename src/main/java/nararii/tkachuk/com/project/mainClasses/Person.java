package main.java.nararii.tkachuk.com.project.mainClasses;

public class Person {
    protected String firstName;
    protected String lastName;
    protected int id;

    public Person(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                ", id=" + id +
                '}';
    }
}
