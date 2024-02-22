package wrap.topinterviewmedium.bitmanipulation;

//Binary representation of 13 is 1101 and has 3 set bits
public class CountSetBits {
    public static void main(String[] args) {
        int n = 9;
        System.out.println(countSetBits(n));
    }
    //Brian Kernighan’s Algorithm
    public static int countSetBits(int n){
        int count = 0;
        while(n > 0){
            n &= n-1;
            count++;
        }
        return count;
    }
}
