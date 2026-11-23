class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        // dfs , return a max area(Math.max)
        // connected up, down, left or right
        // if no land return 0
        // as we are going in a path we have to count up how many and compare with the prev max
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }

        return max;
    }

    public int dfs(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length)
            return 0;

        if (grid[r][c] != 1)
            return 0;
        grid[r][c] = 0;

        return 1 + dfs(grid, r - 1, c) + dfs(grid, r + 1, c) + dfs(grid, r, c - 1)
            + dfs(grid, r, c + 1);
    }
}
