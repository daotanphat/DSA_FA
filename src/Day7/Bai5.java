package Day7;

public class Bai5 {
    static public int maxProfit(int[] prices) {
        int length = prices.length;
        int maxProfit = 0;
        int profit = 0;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            if (prices[i] < minValue) {
                minValue = prices[i];
            }

            profit = prices[i] - minValue;
            if (maxProfit < profit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
