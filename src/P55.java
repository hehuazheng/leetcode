/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 * <p>
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 * jump length is 0, which makes it impossible to reach the last index.
 */
public class P55 {
    public boolean canJump(int[] nums) {
//        int last = nums.length - 1;
//
//        for (int i = last - 1; i >= 0; i--) {
//            if (nums[i] >= last - i) {
//                last = i;
//            }
//        }
//
//        return last == 0;
        int[] flags = new int[nums.length];
        flags[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            int f = Math.min(nums[i] + i, nums.length - 1);
            for (int j = i + 1; j <= f; j++) {
                if(flags[j] == 1) {
                    flags[i] = 1;
                    break;
                }
            }
        }
        return flags[0] == 1;
    }

    public static void main(String[] args) {
        System.out.println(new P55().canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new P55().canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(new P55().canJump(new int[]{2, 0}));
    }
}
