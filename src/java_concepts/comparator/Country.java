package java_concepts.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Country {

    int id;
    String name;

    public Country(int id, String name) {
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

    public static void main(String[] args) {
        Country c1 = new Country(2,"india");
        Country c2 = new Country(3, "japan");
        Country c3 = new Country(1, "us");
        Country c4 = new Country(4, "aus");
        List<Country> list = new ArrayList<>();
        list.add(c1);list.add(c2);list.add(c3);list.add(c4);

        System.out.println("Before Sort");
        for(Country country : list){
            System.out.println(country);
        }

        Collections.sort(list, new Comparator<Country>() {
            @Override
            public int compare(Country o1, Country o2) {
                return o1.id - o2.id;
            }
        });

        System.out.println("After sorting by id");
        for(Country country : list){
            System.out.println(country);
        }

        Collections.sort(list, new Comparator<Country>() {
            @Override
            public int compare(Country o1, Country o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        System.out.println("After sorting by name");
        for(Country country : list){
            System.out.println(country);
        }

    }
}
