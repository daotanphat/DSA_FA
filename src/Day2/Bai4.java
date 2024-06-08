package Day2;

import java.util.Arrays;

public class Bai4 {
    public int dominantIndex(int[] nums) {
        int length = nums.length;
        int oldArray[] = Arrays.copyOf(nums, length);
        Arrays.sort(nums);

        int firstMax = nums[length - 1];
        int secondMax = nums[length - 2];

        if (secondMax * 2 > firstMax) {
            return -1;
        } else {
            for (int i = 0; i < length; i++) {
                if (oldArray[i] == firstMax) {
                    return i;
                }
            }
        }
        return 0;
    }
}
