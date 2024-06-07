package wrap.java_concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

final public class ImmutableClass{
    final private int age;
    final private Date dob;
    final private Address address;
    final private List<String> subjects;

    public ImmutableClass(int age, Date dob, Address address, List<String> subjects) {
        this.age = age;
        this.dob = dob;
        this.address = address;
        this.subjects = subjects;
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

    public List<String> getSubjects(){
        return new ArrayList<>(subjects);
    }

    public static void main(String[] args) throws CloneNotSupportedException{
        Address address = new Address("silchar", 12);
        List<String> subjects = Arrays.asList("english", "maths");
        ImmutableClass m1 = new ImmutableClass(12, new Date(), address, subjects);
        Address a1 = m1.getAddress();
        System.out.println("before change");
        System.out.println("Address: "+m1.getAddress().getAddress());
        System.out.println("subjects: "+m1.getSubjects());

        a1.setAddress("bangalore");
        m1.getSubjects().add("science");

        System.out.println("after change");
        System.out.println("Address: "+m1.getAddress().getAddress());
        System.out.println("subjects: "+m1.getSubjects());

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