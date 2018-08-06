/**
 * Example 2:
 * <p>
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 * <p>
 * Input: [7,8,9,11,12]
 * Output: 1
 */
public class P41C {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0) {
                nums[i] = len + 1;
            }
        }

        for (int i = 0; i < len; i++) {
            int abs = Math.abs(nums[i]);
            if (abs >= 1 && abs <= len && nums[abs - 1] > 0) {
                nums[abs - 1] = -nums[abs - 1];
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] >= 0) {
                return i + 1;
            }
        }
        return len + 1;
    }

    public static void main(String[] args) {
        System.out.println(new P41C().firstMissingPositive(new int[]{0,1,2}));
        System.out.println(new P41C().firstMissingPositive(new int[]{1,2,0}));
        System.out.println(new P41C().firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(new P41C().firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }
}
