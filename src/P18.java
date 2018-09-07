import java.util.*;

public class P18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 3) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum1 = nums[i] + nums[j];
                if (sum1 > target && nums[j] > 0) {
                    break;
                }
                for (int k = j + 1; k < nums.length; k++) {
                    int sum2 = sum1 + nums[k];
                    if (sum2 > target && nums[k] > 0) {
                        break;
                    }
                    for (int l = k + 1; l < nums.length; l++) {
                        int sum3 = sum2 + nums[l];
                        if (sum3 == target) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add(nums[l]);
                            result.add(list);
                            break;
                        } else if (sum3 > target && nums[l] > 0) {
                            break;
                        }
                    }
                }
            }
        }

        if (result.size() > 1) {
            Collections.sort(result, (o1, o2) -> {
                for (int i = 0; i < o1.size(); i++) {
                    if (o1.get(i) < o2.get(i)) {
                        return -1;
                    } else if (o1.get(i) > o2.get(i)) {
                        return 1;
                    }
                }
                return 0;
            });
            List<List<Integer>> uniq = new ArrayList<>();
            List<Integer> prev = result.get(0);
            uniq.add(prev);
            for (int i = 1; i < result.size(); i++) {
                List<Integer> current = result.get(i);
                boolean same = true;
                for (int j = 0; j < current.size(); j++) {
                    if (!prev.get(j).equals(current.get(j))) {
                        same = false;
                        break;
                    }
                }
                if (!same) {
                    uniq.add(current);
                }
                prev = result.get(i);
            }
            return uniq;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(fourSum(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0));
        System.out.println(fourSum(new int[]{-5, -4, -3, -2, -1, 0, 0, 1, 2, 3, 4, 5}, 0));
        System.out.println(fourSum(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11));
    }
}
