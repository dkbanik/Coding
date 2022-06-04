package java_concepts;

import java.util.Date;

final public class ManishTest{
    final private int age;
    final private Date dob;
    final private Address address;

    public ManishTest(int age, Date dob, Address address) {
        this.age = age;
        this.dob = dob;
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public Date getDob() {
        return dob;
    }

    public Address getAddress() {
        return new Address(address.getAddress(),address.getStreet());
    }

    public static void main(String[] args) {
        Address address = new Address("silchar", 12);
        ManishTest m1 = new ManishTest(12, new Date(), address);
        Address a1 = m1.getAddress();
        a1.setAddress("bangalore");
        System.out.println(m1.getAddress().getAddress());
    }
}
class Address{
    String address;
    int street;

    public Address(String address, int street) {
        this.address = address;
        this.street = street;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStreet() {
        return street;
    }

    public void setStreet(int street) {
        this.street = street;
    }
}