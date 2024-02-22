package wrap.leetcode.others;
//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
// youtube.com/watch?v=hpF87ioNqjA
public class MinShipCapacity {
    public static void main(String[] args) {
        int[] capacity = {10,50,100,100,50,100,100,100};
        int minDays = 5;
        System.out.println(minWeight(minDays, capacity));
    }

    public static int minWeight(int minDays, int[] capacity){
        int[] minmax = new int[2];
        findMinMaxCapacity(capacity,minmax);
        return minWeight(minDays, capacity, minmax);
    }

    public static int minWeight(int minDays, int[] capacity, int[] minmax){
        int minWeight = minmax[0]; //4
        int maxWeight = minmax[1]; //16
        int midWeight;
        int optimalWeight = 0;
        while (minWeight <= maxWeight){
            midWeight = (maxWeight+minWeight)/2; // 10
            if(isGivenDaysEnough(midWeight,capacity,minDays)){
                optimalWeight = midWeight;
                maxWeight = midWeight - 1;
            }
            else{
                minWeight = midWeight + 1;
            }
        }
        return optimalWeight;
    }


    public static boolean isGivenDaysEnough(int maxCapacity, int[] capacities, int daysAllowed){
        int days = 0;
        int capacity = 0;
        for(int i=0;i<capacities.length;i++){
            if(capacity+capacities[i] <= maxCapacity){
                capacity+=capacities[i];
            }
            else{
                days++;
                capacity=capacities[i];
            }
            if(days >= daysAllowed) return false;
        }
        return true;
    }

    public static void findMinMaxCapacity(int[] capacity, int[] minmax){
        int min = capacity[0];
        int max = 0;
        for(int i=0;i<capacity.length;i++){
            if(capacity[i] > min){
                min = capacity[i];
            }
            max+=capacity[i];
        }
        minmax[0] = min;
        minmax[1] = max;
    }
}
