package Day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AntenArena {
    private static final int[][] directionsOdd = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, 1}, {-1, -1}};
    private static final int[][] directionsEven = {{-1, 0}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};


    private static int dfs(int[][] arr, int x, int y, int depth, int currentSum, boolean[][] visited, int maxSum) {
        if (depth == 4) {
            maxSum = Math.max(maxSum, currentSum);
            return maxSum;
        }

        int[][] directions = y % 2 == 0 ? directionsEven : directionsOdd;

        visited[x][y] = true;
        currentSum += arr[x][y];
        for (int[] d : directions) {
            int newX = x + d[0];
            int newY = y + d[1];

            if (isValid(newX, newY, arr, visited)) {
                maxSum = dfs(arr, newX, newY, depth + 1, currentSum, visited, maxSum);
            }
        }
        visited[x][y] = false;
        return maxSum;
    }

    private static boolean isValid(int x, int y, int[][] array, boolean[][] visited) {
        return x >= 0 && x < array.length && y >= 0 && y < array[0].length && !visited[x][y];
    }

    private static int findSpecial(int[][] arena, int max) {
        int rows = arena.length;
        int cols = arena[0].length;
        for (int y = 2; y < cols; y += 2) {
            int sum = arena[0][y] + arena[0][y + 1] + arena[1][y] + arena[0][y - 1];
            if (sum > max) {
                max = sum;
            }
        }

        for (int y = 2; y < cols; y += 2) {
            int sum = arena[rows - 1][y] + arena[rows - 2][y] + arena[rows - 1][y + 1] + arena[rows - 1][y - 1];
            if (sum > max) {
                max = sum;
            }
        }

        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                if (j % 2 != 0) {
                    int sum1 = arena[i][j] + arena[i - 1][j + 1] + arena[i + 1][j] + arena[i - 1][j - 1];
                    int sum2 = arena[i][j] + arena[i - 1][j] + arena[i][j + 1] + arena[i][j - 1];
                    max = Math.max(max, Math.max(sum2, sum1));
                } else {
                    int sum1 = arena[i][j] + arena[i][j + 1] + arena[i + 1][j] + arena[i][j - 1];
                    int sum2 = arena[i][j] + arena[i - 1][j] + arena[i + 1][j + 1] + arena[i + 1][j - 1];
                    max = Math.max(max, Math.max(sum2, sum1));
                }
            }
        }
        return max;
    }

    static public int findMaxAntenArena(int[][] arena) {
        int rows = arena.length;
        int cols = arena[0].length;
        int maxSumDfs = Integer.MIN_VALUE;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean[][] visited = new boolean[rows][cols];
                maxSumDfs = Math.max(maxSumDfs, dfs(arena, i, j, 0, 0, visited, maxSumDfs));
            }
        }
        maxSumDfs = findSpecial(arena, maxSumDfs);
        return maxSumDfs;
    }

    public static void main(String[] args) throws IOException {
        String filePath = "src/Day6/input2.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int numTestCases = Integer.parseInt(reader.readLine());
            for (int i = 0; i < numTestCases; i++) {
                String[] dimensions = reader.readLine().split(" ");
                int row = Integer.parseInt(dimensions[0]);
                int col = Integer.parseInt(dimensions[1]);

                int[][] matrix = new int[row][col];

                for (int j = 0; j < row; j++) {
                    String[] line = reader.readLine().split(" ");
                    for (int k = 0; k < col; k++) {
                        matrix[j][k] = Integer.parseInt(line[k]);
                    }
                }

                int maxSum = findMaxAntenArena(matrix);

                System.out.println("Case #" + (i + 1) + ": " + maxSum);
            }
        }
    }
}
