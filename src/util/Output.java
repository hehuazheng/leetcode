package util;

public class Output {
    public static String toString(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]).append(",");
        }
        if(sb.length() > 0) {
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
}
