package Day4;

import java.util.*;

public class Bai4 {
    static public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0});
        int stop = 0;
        int minCost[] = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        while (!q.isEmpty() && stop <= k) {
            int size = q.size();
            while (size-- > 0) {
                int[] current = q.poll();
                for (int[] neighbor : adj.get(current[0])) {
                    int price = current[1] + neighbor[1];
                    int neighborNode = neighbor[0];
                    if (price > minCost[neighborNode]) {
                        continue;
                    }
                    minCost[neighborNode] = price;
                    q.offer(new int[]{neighborNode, price});
                }
            }
            stop++;
        }
        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}
