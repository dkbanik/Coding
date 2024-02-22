package wrap.topinterviewmedium;

public class IncreasingTripletSubseq {
    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[]{20,100,10,12,5,13}));
    }

    public static boolean increasingTriplet(int[] nums) {
        int i = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;
        for(int num : nums){ // 20 , 100, 10, 12, 5, 13
            if(num <= i){
                i = num; //20, 10, 5
            }
            else if(num <= j){
                j = num; // 100, 12
            }
            else{
                return true; // 13
            }
        }
        return false;
    }
}
