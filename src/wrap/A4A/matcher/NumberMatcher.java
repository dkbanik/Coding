package wrap.A4A.matcher;

public class NumberMatcher implements Matcher<Integer>{
    static private int threshold = 1000;
    @Override
    public int match(Integer o1, Integer o2) {
        if(o1.equals(o2)){
            return Category.EXACT.getValue();
        }
        else if(Math.abs(o1-(int)o2) <= threshold){
            return Category.PARTIAL.getValue();
        }
        else{
            return Category.ONLY.getValue();
        }
    }
}
