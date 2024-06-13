package Day5;

public class Bai1 {
    public int[] searchRange(int[] nums, int target) {
        int result[] = new int[2];
        result[0] = -1;
        result[1] = -1;
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

            if (nums[mid] == target) {
                result[0] = mid;
            }
        }

        left = 0;
        right = length - 1;
        mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

            if (nums[mid] == target) {
                result[1] = mid;
            }
        }

        return result;
    }
}
