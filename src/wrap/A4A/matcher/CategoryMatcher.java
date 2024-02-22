package wrap.A4A.matcher;

import wrap.A4A.dto.Buyer;
import wrap.A4A.dto.Supplier;

public class CategoryMatcher{
    private static int threshold = 9;
    public String match(Buyer o1, Supplier o2) {
        Matcher nameMatcher = new StringMatcher();
        Matcher salaryMatcher = new NumberMatcher();

        int nameScore = nameMatcher.match(o1.getName(), o2.getName());
        int salaryScore = salaryMatcher.match(o1.getSalary(),o2.getSalary());
        int refNumScore = nameMatcher.match(o1.getRefNum(),o2.getRefNum());

        int totalScore = nameScore+salaryScore+refNumScore;
        if(totalScore == threshold){
            return Category.EXACT.name();
        }
        else if(totalScore == 0){
            return Category.ONLY.name();
        }
        else{
            return Category.PARTIAL.name();
        }
    }
}
