package Day5;

public class CoinChange {
    static public int coinChange(int[] coins, int amount) {
        if(amount<0) return -1;
        if(amount==0) return 0;
        int cc=-1;
        for(int i=0;i<coins.length;i++) {
            int coin=coinChange(coins, amount-coins[i]);
            if(coin>=0) cc=cc<0?coin+1:Math.min(cc,coin+1);
        }
        return cc;
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{30, 40}, 100));
    }
}
