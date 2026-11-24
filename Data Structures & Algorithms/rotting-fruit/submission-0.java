class Solution {
    public int orangesRotting(int[][] grid) {
        // check if there is an fresh
        //  minimum number, Math.min, so we have to track the min of each recursive call
        // BFS with queue
        //  you can count minutes by checking bounds like we did with level order and size
        //  along the way ,  check to see if a call is between two zeros

        Queue<int[]> queue = new ArrayDeque<>();
        int fresh = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        if (fresh == 0)
            return 0;
        int mins = 0;

        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
                for (int[] d : dirs) {
                    int nr = cur[0] + d[0];
                    int nc = cur[1] + d[1];
                    if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length
                        && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        fresh--;
                        queue.offer(new int[] {nr, nc});
                    }
                }
            }
            mins++;
        }

        return fresh == 0 ? mins : -1;
    }
}
