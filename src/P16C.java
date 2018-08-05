public class P16C {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }

        int minDistance = Integer.MAX_VALUE;
        int prevNearestSum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 2; j < nums.length; j++) {
                for (int k = i + 1; k < j; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int distance = Math.abs(target - sum);
                    if( distance < minDistance) {
                        minDistance = distance;
                        prevNearestSum = sum;
                    }
                }
            }
        }
        return prevNearestSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        System.out.println(new P16C().threeSumClosest(nums, 1));
    }
}
