package leetcode.may2021;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class CourseScheduleIII {
    public static void main(String[] args) {
        int[][] courses = {{100,200},{200,1300},{2000,3200},{1000,1250}};
        //int[][] courses = {{3,2},{4,3}};
        // int[][] courses = [[7,16],[2,3],[3,12],[3,14],[10,19],[10,16],[6,8],[6,11],[3,13],[6,16]];
        int ans = scheduleCourse(courses);
        System.out.println(ans);
    }
    static int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b) -> a[1] == b[1] ? a[0]-b[0] : a[1]-b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int time=0;
        for(int[] course : courses){
            if(course[0] <= course[1]){
                if(time+course[0] <= course[1]){
                    pq.offer(course[0]);
                    time+=course[0];
                }
                else if (pq.peek()>course[0]){
                    time-=pq.poll();
                    time+=course[0];
                    pq.offer(course[0]);
                }
            }
        }
        return pq.size();
    }
}
