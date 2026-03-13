package oop.models;

import annotation.InformationConfiguration;

import java.util.Objects;

@InformationConfiguration(name = "Juan pablo", email = "juan@gmail.com")
public class Person {

    private String name;
    private String cellphone;

    public Person() {
    }

    public Person(String name, String cellphone) {
        this.name = name;
        this.cellphone = cellphone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(cellphone, person.cellphone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cellphone);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", cellphone='" + cellphone + '\'' +
                '}';
    }
}
