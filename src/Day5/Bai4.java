package Day5;

public class Bai4 {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;

        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        while (left < right) {
            int middle = (left + right) / 2;
            int day = 1;
            int weightPerDay = 0;
            for (int weight : weights) {
                if (weightPerDay + weight > middle) {
                    day += 1;
                    weightPerDay = 0;
                }
                weightPerDay += weight;
            }
            if (day > days) left = middle + 1;
            else right = middle;
        }
        return left;
    }
}
