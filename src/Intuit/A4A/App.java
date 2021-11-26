package Intuit.A4A;

import Intuit.A4A.dto.Buyer;
import Intuit.A4A.dto.Supplier;
import Intuit.A4A.matcher.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class App {
    public static void main(String[] args) {

        List<Buyer> buyers = new ArrayList<>();
        List<Supplier> suppliers = new ArrayList<>();

        Buyer b1 = new Buyer("Ram",9000,"12A3");
        Buyer b2 =  new Buyer("Shyam",8500, "12A4");
        buyers.add(b1);buyers.add(b2);

        Supplier s1 = new Supplier("Raam", 9000, "12A3");
        Supplier s2 = new Supplier("Shyam",8500,"12A4");
        suppliers.add(s1);suppliers.add(s2);

        CategoryMatcher catMatcher = new CategoryMatcher();

        for(Buyer buyer: buyers){
            for(Supplier sup: suppliers){
                String val = catMatcher.match(buyer,sup);
                System.out.println(val);
            }
        }
    }
}
