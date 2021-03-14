package problems;


public class CrossTheValley {
    public static void main(String[] args) {
        int[] input = {1,1,2,4,2,1,0,0,1,3};
        Boolean result = canCrossValley(input);
        System.out.println(result);
    }
    public static Boolean canCrossValley(int[] input){
        int toReach = input.length;
        int maxReach = 0;
        for(int i=0;i<toReach;i++)
        {
            if(maxReach < i) return false;
            maxReach= Integer.max(maxReach,i+input[i]);
            if(maxReach == toReach) return true;
        }
        return true;
    }
}
