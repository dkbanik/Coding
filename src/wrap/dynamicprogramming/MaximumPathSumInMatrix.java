package wrap.dynamicprogramming;

import java.util.Arrays;

//https://www.geeksforgeeks.org/min-cost-path-dp-6/?ref=lbp
public class MaximumPathSumInMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{348, 391},
                {618, 193}};

        int N = 2;

        System.out.println(maximumPath(N, matrix));
    }

    static int maximumPath(int N, int Matrix[][]) {

        int[][] cache = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(cache[i], -1);
        }
        for (int i = 0; i < N; i++) {
            cache[0][i] = Matrix[0][i];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j == 0) {
                    cache[i][j] = Matrix[i][j] + Math.max(cache[i - 1][j], cache[i - 1][j + 1]);
                } else if (j == N - 1) {
                    cache[i][j] = Matrix[i][j] + Math.max(cache[i - 1][j], cache[i - 1][j - 1]);
                } else {
                    cache[i][j] = Matrix[i][j] + Math.max(cache[i - 1][j - 1], Math.max(cache[i - 1][j], cache[i - 1][j + 1]));
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            if (cache[N - 1][i] > max) {
                max = cache[N - 1][i];
            }
        }

        return max;
    }
}
