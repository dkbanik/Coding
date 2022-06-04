package topinterviewmedium;

public class MinTime {
    // Class name must be "Main"
// Libraries included:
// json simple, guava, apache commons lang3, junit, jmock


    public static void main(String[] args) {
        int[] times = {5, 10, 10};
        int totalTrips = 9;

        int ans = minTime(times, totalTrips);
        System.out.println(ans);
    }

    public static int minTime(int[] times, int totalTrips) {
        //sum of all time taken 6 (1+2+3)
        int maxTime = findMax(times);
        // 3 as 3rd bus needs atleast 3 time to finish 1 trip
        int minTime = findMin(times);

        for (int i = minTime; i <= maxTime; i++) {
            if (isTripPossible(i, totalTrips, times)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean isTripPossible(int time, int totalTrips, int[] times) {
        int trip = 0;
        for (int i = 1; i <= times.length; i++) {
            int temp = time / times[i - 1];
            trip += temp;
        }
        if (trip >= totalTrips) {
            return true;
        }
        return false;
    }

    public static int findMax(int[] times) {
        int sum = 0;
        for (int i = 0; i < times.length; i++) {
            sum += times[i];
        }
        return sum;
    }

    public static int findMin(int[] times) {
        int min = 0;
        for (int i = 0; i < times.length; i++) {
            min = Math.max(min, times[i]);
        }
        return min;
    }


}
