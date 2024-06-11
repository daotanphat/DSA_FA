package Day4;

public class Bai1 {
    static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0},
            {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};

    static public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length;
        int n = board[0].length;
        int row = click[0];
        int col = click[1];

        if (board[row][col] == 'M') {
            board[row][col] = 'X';
            return board;
        }

        int num = 0;
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < m
                    && newCol >= 0 && newCol < n
                    && board[newRow][newCol] == 'M') {
                num++;
            }
        }

        if (num > 0) {
            board[row][col] = (char) (num + '0');
            return board;
        }

        board[row][col] = 'B';
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < m
                    && newCol >= 0 && newCol < n
                    && board[newRow][newCol] == 'E') {
                updateBoard(board, new int[]{newRow, newCol});
            }
        }


        return board;
    }
}
