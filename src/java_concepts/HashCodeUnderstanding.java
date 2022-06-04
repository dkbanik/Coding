package java_concepts;

import java.util.HashMap;
import java.util.Objects;

class Person{
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    //    @Override
//    public int hashCode() {
//        return 31;
//    }
}
public class HashCodeUnderstanding {
    public static void main(String[] args) {
        Person p1 = new Person("debs", 12);
        Person p2 = new Person("debs", 12);

        HashMap<Person, Integer> map = new HashMap<>();
        map.put(p1,1);

        System.out.println("hashcode for p1: " +p1.hashCode());
        System.out.println("hashcode for p2: " +p2.hashCode());

        System.out.println(map.get(p2));

    }
}
