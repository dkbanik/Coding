package wrap.topinterviewmedium.bitmanipulation;
//Count number of bits to be flipped to convert A to B
public class CountBitsFlipAtoB {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println(countSetBits(a^b));
    }

    public static int countSetBits(int n){
        int count = 0;
        while(n>0){
            n &= n-1;
            count++;
        }
        return count;
    }
}
