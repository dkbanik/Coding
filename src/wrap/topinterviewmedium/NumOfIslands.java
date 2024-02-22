package wrap.topinterviewmedium;

public class NumOfIslands {
    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        int ans = numIslands(grid);
        System.out.println(ans);
    }

    public static int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int numIslands = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j] == '1'){
                    check_and_mark(grid,i,j,r,c);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }

    public static void check_and_mark(char[][] grid, int i, int j, int r, int c){
        if(i < 0 || i >= r || j < 0 || j >= c || grid[i][j] != '1') return;

        grid[i][j] = '2';
        check_and_mark(grid,i-1,j,r,c);
        check_and_mark(grid,i+1,j,r,c);
        check_and_mark(grid,i,j-1,r,c);
        check_and_mark(grid,i,j+1,r,c);
        return;
    }
}
