package wrap.topinterviewmedium;

import java.util.PriorityQueue;
import java.util.Queue;

public class SeatManager {
    int seats;
    Queue<Integer> queue;

    public SeatManager(int seats){
        this.seats = seats;
        this.queue = new PriorityQueue<>();
        for(int i=1;i<=seats;i++){
            this.queue.offer(i);
        }
    }

    public int reserve(){
        return this.queue.poll();
    }

    public void unreserve(int seat){
        this.queue.add(seat);
    }

    public static void main(String[] args) {
        SeatManager sm = new SeatManager(5);
        System.out.println(sm.reserve());
        System.out.println(sm.reserve());
        sm.unreserve(2);
        System.out.println(sm.reserve());
        System.out.println(sm.reserve());
        System.out.println(sm.reserve());
        System.out.println(sm.reserve());
        sm.unreserve(5);
    }


}
