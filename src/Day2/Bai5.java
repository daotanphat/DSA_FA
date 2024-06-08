package Day2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Bai5 {
    static public int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int length = nums.length;
        int flag = 0;
        for (int i = 0; i < length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                nums[flag] = nums[i];
                flag++;
            }
        }
        return flag;
    }
}
