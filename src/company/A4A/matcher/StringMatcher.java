package company.A4A.matcher;

public class StringMatcher implements Matcher<String>{

    @Override
    public int match(String o1, String o2) {
        if(o1.equals(o2)){
            return Category.EXACT.getValue();
        }else{
            return Category.ONLY.getValue();
        }
    }
}
