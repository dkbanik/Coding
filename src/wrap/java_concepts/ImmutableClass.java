package wrap.java_concepts;

import java.util.Date;

final public class ImmutableClass{
    final private int age;
    final private Date dob;
    final private Address address;

    public ImmutableClass(int age, Date dob, Address address) {
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

    public Address getAddress() throws CloneNotSupportedException {
        return (Address) address.clone();
        //return new Address(address.getAddress(),address.getStreet());
    }

    public static void main(String[] args) throws CloneNotSupportedException{
        Address address = new Address("silchar", 12);
        ImmutableClass m1 = new ImmutableClass(12, new Date(), address);
        Address a1 = m1.getAddress();
        a1.setAddress("bangalore");
        System.out.println(m1.getAddress().getAddress());
    }
}
class Address implements Cloneable{
    String address;
    int street;

    public Address(String address, int street) {
        this.address = address;
        this.street = street;
    }

    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
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