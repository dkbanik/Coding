package wrap.java_concepts.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Country implements Comparable<Country>{
    int id;
    String name;

    public Country(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }


    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Country country) {
        return (this.id < country.id ? -1 : (this.id == country.id ? 0 : 1));
    }

    public static void main(String[] args) {
        Country c1 = new Country(1,"india");
        Country c2 = new Country(3, "us");
        Country c3 = new Country(2, "japan");

        List<Country> list = new ArrayList<>();
        list.add(c1);list.add(c2);list.add(c3);

        System.out.println("Before Sort");
        for(Country country : list){
            System.out.println(country);
        }

        System.out.println("After Sort");
        Collections.sort(list);
        for(Country country : list){
            System.out.println(country);
        }
    }
}
