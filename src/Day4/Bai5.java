package Day4;

public class Bai5 {
    static int directions[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static int isIsland_dfs(int[][] grid1, int[][] grid2, int i, int j) {
        int row = grid2.length;
        int col = grid2[0].length;
        int result = 1;

        if (i < 0 || i == row || j < 0 || j == col
                || grid2[i][j] == 0)
            return 1;
        grid2[i][j] = 0;

        result &= isIsland_dfs(grid1, grid2, i + 1, j);
        result &= isIsland_dfs(grid1, grid2, i - 1, j);
        result &= isIsland_dfs(grid1, grid2, i, j + 1);
        result &= isIsland_dfs(grid1, grid2, i, j - 1);

        return result & grid1[i][j];
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int row = grid2.length;
        int col = grid2[0].length;
        int result = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid2[i][j] == 1) {
                    result += isIsland_dfs(grid1, grid2, i, j);
                }
            }
        }
        return result;
    }
}
