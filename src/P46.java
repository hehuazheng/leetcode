import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3]
 * Output:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class P46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList();
        permuteHelper(nums, 0, lists);
        return lists;
    }

    public void permuteHelper(int[] nums, int index, List<List<Integer>> lists) {
        if (nums == null || nums.length == 0) {
            lists.add(new ArrayList());
        }
        if (index == nums.length) {
            List<Integer> list = new ArrayList();
            for (int i : nums) {
                list.add(i);
            }
            lists.add(list);
        } else {
            for (int i = index; i < nums.length; i++) {
                swap(nums, i ,index);
                permuteHelper(nums, index + 1, lists);
                swap(nums, i, index);
            }
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new P46().permute(new int[]{1, 2, 3}));
        System.out.println(new P46().permute(new int[]{2, 1, 0, 4}));
    }
}
