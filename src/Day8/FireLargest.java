package Day8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FireLargest {
    static class Cell {
        int x;
        int y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int countCellFire = 0;
    static boolean[][] visited;
    static int ans1, ans2;
//
//    static int calculateMaxCellFire(List<List<Integer>> coordinates) {
//
//    }
//
//    static public int calculateCellFireEachStep(int[][] matrix, List<List<Integer>> coordinates) {
//        int numFirstPositionFire = coordinates.size();
//        int count = 0;
//        for (int i = 0; i < numFirstPositionFire; i++) {
//            int x = coordinates.get(i).get(0);
//            int y = coordinates.get(i).get(1);
//            count += bfs(matrix, x, y);
//        }
//        return count;
//    }
//
//    static public int bfs(int[][] matrix, int x, int y) {
//        if (matrix[x][y] > 0) {
//            countCellFire++;
//            matrix[x][y] = matrix[x][y] - 1;
//        }
//
//        for (int i = 0; i < directions.length; i++) {
//            List<Integer> coordinate = new ArrayList<>();
//            int newX = x + directions[i][0];
//            int newY = y + directions[i][1];
//
//            if (isValid(newX, newY, matrix)) {
//                coordinate.add(newX);
//                coordinate.add(newY);
//                countCellFire++;
//                coordinates.add(coordinate);
//            }
//        }
//        return countCellFire;
//    }
//
//    static boolean isValid(int x, int y, int[][] array) {
//        return x > 0 && x < array.length && y > 0 && y < array[0].length;
//    }

    private static void calculateMaxCellFire(int[][] map, List<Cell> kCells, int T) {
        int row = map.length;
        int col = map[0].length;
        visited = new boolean[row][col];

        int[] steps = new int[1000000000];
        int[][] distance = new int[row][col];
        Queue<Cell> q = new LinkedList<>();

        for (Cell cell : kCells) {
            q.add(cell);
            distance[cell.x][cell.y] = 1;
            visited[cell.x][cell.y] = true;
            steps[1]++;
        }

        while (!q.isEmpty()) {
            Cell curr = q.poll();
            int d = distance[curr.x][curr.y];
            steps[d + map[curr.x][curr.y]]--;

            for (int i = 0; i < 4; i++) {
                int newX = curr.x + directions[i][0];
                int newY = curr.y + directions[i][1];

                if (newX < 0 || newY < 0 || newX >= row || newY >= col) continue;

                if (distance[newX][newY] != 0 || map[newX][newY] == 0 || visited[newX][newY]) continue;

                q.add(new Cell(newX, newY));
                visited[newX][newY] = true;
                distance[newX][newY] = d + 1;
                steps[d + 1]++;
            }
        }


        int max = 1;
        for (int i = 1; i <= steps.length; i++) {
            steps[i] += steps[i - 1];
            if (steps[i] > steps[max]) {
                max = i;
            }
            if (steps[i] == 0) break;
        }

        ans1 = steps[max];
        ans2 = max;
    }

    public static void main(String[] args) throws IOException {
        String filePath = "src/Day8/input.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int numTestCases = Integer.parseInt(reader.readLine());
            for (int i = 0; i < numTestCases; i++) {
                String[] dimensions = reader.readLine().split(" ");
                List<Cell> coordinates = new ArrayList<>();
                int row = Integer.parseInt(dimensions[0]);
                int col = Integer.parseInt(dimensions[1]);

                int[][] matrix = new int[row][col];

                for (int j = 0; j < row; j++) {
                    String[] line = reader.readLine().split(" ");
                    for (int k = 0; k < col; k++) {
                        matrix[j][k] = Integer.parseInt(line[k]);
                    }
                }

                String[] coordinates_string = reader.readLine().split(" ");
                for (int l = 0; l < coordinates_string.length; l += 2) {
                    coordinates.add(new Cell(Integer.parseInt(coordinates_string[l]), Integer.parseInt(coordinates_string[l + 1])));
                }

                int time = (int) Math.pow(10, Integer.parseInt(reader.readLine()));
                // calculate fire here
                calculateMaxCellFire(matrix, coordinates, time);

                System.out.println("Case #" + (i + 1) + ": " + ans1 + " cells fire at step " + ans2);
            }
        }
    }
}
