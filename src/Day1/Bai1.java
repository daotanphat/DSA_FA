package Day1;

public class Bai1 {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
