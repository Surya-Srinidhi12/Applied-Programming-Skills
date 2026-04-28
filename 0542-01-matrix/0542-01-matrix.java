import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int[][] dist = new int[rows][cols];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();

            for(int[] d : dirs) {
                int r = curr[0] + d[0];
                int c = curr[1] + d[1];

                if(r >= 0 && r < rows && c >= 0 && c < cols) {
                    if(dist[r][c] > dist[curr[0]][curr[1]] + 1) {
                        dist[r][c] = dist[curr[0]][curr[1]] + 1;
                        queue.add(new int[]{r, c});
                    }
                }
            }
        }

        return dist;
    }
}