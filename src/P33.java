/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class P33 {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[start] <= nums[mid]){
                if (target < nums[mid] && target >= nums[start])
                    end = mid - 1;
                else
                    start = mid + 1;
            }

            if (nums[mid] <= nums[end]){
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }
//        if(nums.length == 0) {
//            return -1;
//        }
//        int sep = dfs(nums, 0, nums.length - 1);
//        if(sep == -1) {
//            sep = nums.length;
//        }
//        int pos = binarySearch(nums, 0, sep - 1, target);
//        if (pos != -1) {
//            return pos;
//        }
//        return binarySearch(nums, sep, nums.length - 1, target);
//    }
//
//    int binarySearch(int[] nums, int l, int r, int target) {
//        if (r >= nums.length || l < 0 || l > r  || nums[r] < target || nums[l] > target ) {
//            return -1;
//        }
//        if(l == r) {
//            if(nums[l] == target) {
//                return l;
//            }
//            return -1;
//        }
//        int mid = (l + r) / 2;
//        if (nums[mid] == target) {
//            return mid;
//        } else if (nums[mid] > target) {
//            return binarySearch(nums, l, mid, target);
//        } else {
//            return binarySearch(nums, mid + 1, r, target);
//        }
//    }
//
//    int dfs(int[] nums, int l, int r) {
//        if (l >= r) {
//            return -1;
//        }
//        int mid = (l + r) / 2;
//        if (mid > 1 && nums[mid] < nums[mid - 1]) {
//            return mid;
//        }
//        if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]) {
//            return mid + 1;
//        }
//        int pos = dfs(nums, l, mid);
//        if (pos != -1) {
//            return pos;
//        }
//        return dfs(nums, mid + 1, r);
//    }

    public static void main(String[] args) {
        System.out.println(new P33().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(new P33().search(new int[]{2, 4, 5, 6, 7, 0, 1, 2, 3}, 0));
        System.out.println(new P33().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(new P33().search(new int[]{1}, 0));
    }
}
