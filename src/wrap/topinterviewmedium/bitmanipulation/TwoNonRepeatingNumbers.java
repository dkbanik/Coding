package wrap.topinterviewmedium.bitmanipulation;

public class TwoNonRepeatingNumbers {
    public static void main(String[] args) {
        int[] arr = {2,6,4,5,4,3,6,5};
        findNonRepeatingNumbers(arr);
    }

    public static void findNonRepeatingNumbers(int[] arr){
        int xxory = 0;
        for(int val : arr){
            xxory = val ^ xxory;
        }

        int rmbm = xxory & (-xxory);

        int x=0;int y=0;
        for(int val: arr){
            if((val & rmbm) == 0){
                x ^= val;
            }
            else{
                y ^= val;
            }
        }

        System.out.println("X is "+x+" Y is: "+y);
    }
}
