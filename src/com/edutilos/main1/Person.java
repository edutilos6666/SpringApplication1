package com.edutilos.main1;

/**
 * Created by edutilos on 04/04/2017.
 */
public class Person {
  private String first;
    private String last;
    private Address address;

    public Person(String first, String last, Address address) {
        this.first = first;
        this.last = last;
        this.address = address;
    }

    public Person() {
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", address=" + address +
                '}';
    }
}
