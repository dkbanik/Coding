package wrap.graph;

import java.util.LinkedList;
import java.util.Queue;

class Position{
    int value;
    int moves;

    public Position(int value, int moves) {
        this.value = value;
        this.moves = moves;
    }
}
public class SnakeLadder {
    public static void main(String[] args) {
        int[][] board = {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1}
                        ,{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};

        System.out.println(snakesAndLadders(board));

    }
    public static int snakesAndLadders(int[][] board) {
        int n = board.length;
        int end = n*n;
        boolean[] visited = new boolean[end+1];
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(1,0));
        visited[1] = true;
        while(!q.isEmpty()){
            Position p = q.poll();
            if(p.value == end){
                return p.moves;
            }
            for(int i=1;i<=n;i++){
                int val = findSnakeNLadder(p,i, board);
                if(val == -1){
                    if(!visited[p.value+i]){
                        q.add(new Position(p.value+i,p.moves+1));
                        visited[p.value+i] = true;
                    }
                }
                else{
                    if(!visited[val]){
                        q.add(new Position(val,p.moves+1));
                        visited[val] = true;
                    }

                }
            }
        }
        return -1;
    }

    public static int findSnakeNLadder(Position p, int i, int[][] board){
        int size = board.length;
        int val = p.value+i;
        int x = (size - 1) - (val/size);
        int y;
        if(size%2 == 0){
            if(x%2 == 0){
                y = size - (val%size);
            }else{
                y = (val%size) - 1;
            }
        }
        else{
            if(x%2 != 0){
                y = size - (val%size);
            }else{
                y = (val%size) - 1;
            }
        }

        return board[x][y];
    }
}
