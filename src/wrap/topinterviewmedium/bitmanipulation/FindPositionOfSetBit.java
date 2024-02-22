package wrap.topinterviewmedium.bitmanipulation;

public class FindPositionOfSetBit {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(findPosition(n));
    }

    public static int findPosition(int n){
        int count = 0;
        if(!isPowerOfTwo(n)) {
            return -1;
        }else {
            while (n > 0){
                n = n >> 1;
                count++;
            }
        }
        return count;
    }

    public static boolean isPowerOfTwo(int n){
        return  ((n != 0) && (n &(n-1)) == 0);
    }
}
