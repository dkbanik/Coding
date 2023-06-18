package topinterviewmedium;

import java.util.*;

class Person{

    String name;
    int debtAmount;
    int owedAmount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    Person(String name){
        this.name = name;
    }

    public void gaveTo(Person p, int amount){
        owedAmount+=amount;
        p.debtAmount+=amount;
    }
}

public class Dunzo {
    public static void main(String[] args) {
        Person m = new Person("M");
        Person n = new Person("N");
        Person l = new Person("L");
        Person k = new Person("K");
        m.gaveTo(n,20);
        l.gaveTo(m, 70);
        n.gaveTo(l,40);
        n.gaveTo(k,100);
        m.gaveTo(n, 10);
        n.gaveTo(m, 500);


        List<Person> allList = new ArrayList<>();
        allList.add(m);allList.add(n);allList.add(l);allList.add(k);



        //How much debt does each person owe to all users?
        int maxOwed = 0;
        String maxOwedPerson = null;
        System.out.println();
        for(Person person : allList){
            System.out.println(person.name+" owes "+person.owedAmount);
            if(person.owedAmount > maxOwed){
                maxOwed = person.owedAmount;
                maxOwedPerson = person.name;
            }
        }

        System.out.println("Maximum money owned by "+maxOwedPerson);



    }


}
