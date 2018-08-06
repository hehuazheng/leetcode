public class P34C {
    //TTL
    public int[] searchRange(int[] nums, int target) {
        if (nums.length > 0 && target >= nums[0] && target <= nums[nums.length - 1]) {
            int left = 0, right = nums.length - 1;
            int foundPos = -1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    foundPos = mid;
                    break;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (foundPos == -1) {
                return new int[]{-1, -1};
            }
            int start = foundPos, end = foundPos;
            while (start - 1 >= 0 && nums[start - 1] == target) {
                start--;
            }
            while (end + 1 < nums.length && nums[end + 1] == target) {
                end++;
            }
            return new int[]{start, end};
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
//        int[] nums = {5,7,7,8,8,10};
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 6, 6, 6, 8, 10, 10};
        int[] res = new P34C().searchRange(nums, 4);
        System.out.println(res[0] + "," + res[1]);
    }
}
