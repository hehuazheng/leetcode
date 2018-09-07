import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,1,2]
 * Output:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class P47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        list.add(toList(nums));
        while (next(nums) != -1) {
            list.add(toList(nums));
        }
        return list;
    }

    List<Integer> toList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        return list;
    }

    int next(int[] nums) {
        int p = nums.length - 1;
        while (p > 0 && nums[p] <= nums[p - 1]) {
            p--;
        }

        if (p == 0) {
            int pos = 0;
            while (true) {
                int left = pos, right = nums.length - pos - 1;
                if (left >= right) {
                    break;
                }
                swap(nums, left, right);
                pos++;
            }
            return -1;
        } else {
            int k = nums.length - 1;
            while (k >= p) {
                if (nums[k] > nums[p - 1]) {
                    swap(nums, k, p - 1);
                    Arrays.sort(nums, p, nums.length);
                    break;
                }
                k--;
            }
            return 1;
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = null;

//        nums = new int[]{5, 4, 3, 2, 1};
//        System.out.println(new P47().permuteUnique(nums));

        nums = new int[]{2, 3, 3, 3, 2};
//        System.out.println(new P47().permuteUnique(nums));

        new P47().next(nums);
        System.out.println(Output.toString(nums));


        nums = new int[]{2, 1, 1, 2};
//        System.out.println(new P47().permuteUnique(nums));

        new P47().next(nums);
        System.out.println(Output.toString(nums));

        nums = new int[]{2, 3, 3, 3, 2};
        Arrays.sort(nums, 1, nums.length);
        System.out.println(Output.toString(nums));
//        nums = new int[]{1, 2, 3, 4, 5};
//        new P47().next(nums);
//        System.out.println(Output.toString(nums));
//        nums = new int[]{1, 2, 3, 5, 4};
//        new P47().next(nums);
//        System.out.println(Output.toString(nums));
    }
}
