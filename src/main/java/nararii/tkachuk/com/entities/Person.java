package nararii.tkachuk.com.entities;

import java.util.Objects;

public class Person extends EntityID {
    protected String firstName;
    protected String lastName;
    protected Integer id;

    public Person(Integer id) {
        this.id = id;
    }

    public Person(String firstName, String lastName, Integer id) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return getId() == person.getId() &&
                getFirstName().equals(person.getFirstName()) &&
                getLastName().equals(person.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getId());
    }

    @Override
    public String toCSVWithFormatString() {
        return null;
    }

    @Override
    public String toCSVFileString() {
        return null;
    }
}
