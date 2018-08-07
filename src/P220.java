/**
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is
 * at most t and the absolute difference between i and j is at most k.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 * Example 2:
 * <p>
 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 * Example 3:
 * <p>
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 */
public class P220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k == 0 || t < 0) {
            return false;
        }
        // to prevent overflow
        long lt =  (long)t;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j <= k && i + j <= nums.length - 1; j++) {
                if (Math.abs((long)nums[i] - (long)nums[i + j]) <= lt) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new P220().containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
        System.out.println(new P220().containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2));
        System.out.println(new P220().containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
        System.out.println(new P220().containsNearbyAlmostDuplicate(new int[]{-1, -1}, 1, 0));
        System.out.println(new P220().containsNearbyAlmostDuplicate(new int[]{-1, 2147483647}, 1, 2147483647));

        int a = -2;
        int b = 2147483647;
        long c = (long)a- (long)b;
        System.out.println(c);
    }
}
