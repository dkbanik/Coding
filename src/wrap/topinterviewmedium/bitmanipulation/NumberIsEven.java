package wrap.topinterviewmedium.bitmanipulation;

public class NumberIsEven {
    public static void main(String[] args) {
        System.out.print("ans: "+numIsEven(6));
    }
    public static boolean numIsEven(int n){
        return (n&1) == 0;
    }

    public static boolean numDivisibleByFour(int n){
        return (n&3) == 0;
    }
}
