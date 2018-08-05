import util.Output;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class P31C {

    public void nextPermutation(int[] nums) {
        int pos = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[pos] <= nums[i]) {
                pos--;
            } else {
                break;
            }
        }

        if (pos == 0) {
            for (int i = 0; i < nums.length / 2; i++) {
                int temp = nums[i];
                nums[i] = nums[nums.length - i - 1];
                nums[nums.length - i - 1] = temp;
            }
        } else if (pos > 0) {
            int i = nums.length - 1;
            while (i >= pos) {
                if (nums[i] > nums[pos - 1]) {
                    swap(nums, i, pos - 1);
                    while (i - 1 >= pos && nums[i] > nums[i - 1]) {
                        swap(nums, i, i - 1);
                        i--;
                    }

                    i = pos;
                    int k = 0;
                    while (i + k < nums.length - k - 1 && nums[i + k] > nums[nums.length - k - 1]) {
                        swap(nums, i + k, nums.length - k - 1);
                        k++;
                    }

                    break;
                }

                i--;
            }
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        new P31C().nextPermutation(nums);
        System.out.println(Output.toString(nums));

        nums = new int[]{1, 3, 2};
        new P31C().nextPermutation(nums);
        System.out.println(Output.toString(nums));

        nums = new int[]{3, 2, 1};
        new P31C().nextPermutation(nums);
        System.out.println(Output.toString(nums));

        nums = new int[]{1, 1, 5};
        new P31C().nextPermutation(nums);
        System.out.println(Output.toString(nums));

        nums = new int[]{1, 2, 4, 3, 3};
        new P31C().nextPermutation(nums);
        System.out.println(Output.toString(nums));


        nums = new int[]{1, 3, 3, 2, 4};
        new P31C().nextPermutation(nums);
        System.out.println(Output.toString(nums));

        nums = new int[]{100,99,98,97,96,95,94,93,92,91,90,89,88,87,86,85,84,83,82,81,80,79,78,77,76,75,74,73,72,71,70,69,68,67,66,65,64,63,62,61,60,59,58,57,56,55,54,53,52,51,50,49,48,47,46,45,44,43,42,41,40,39,38,37,36,35,34,33,32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
        new P31C().nextPermutation(nums);
        System.out.println(Output.toString(nums));
    }

}
