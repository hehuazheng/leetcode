/**
 * Given a positive integer N, how many ways can we write it as a sum of consecutive positive integers?
 * <p>
 * Example 1:
 * <p>
 * Input: 5
 * Output: 2
 * Explanation: 5 = 5 = 2 + 3
 * Example 2:
 * <p>
 * Input: 9
 * Output: 3
 * Explanation: 9 = 9 = 4 + 5 = 2 + 3 + 4
 * Example 3:
 * <p>
 * Input: 15
 * Output: 4
 * Explanation: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
 * Note: 1 <= N <= 10 ^ 9.
 */
public class P829 {
    public int consecutiveNumbersSum(int N) {
        int maxK = (int) Math.sqrt(2 * N);
        int result = 1;
        for (int i = 1; i <= maxK; i++) {
            if (2 * N % (i + 1) != 0) {
                continue;
            }
            int r = 2 * N / (i + 1);
            if (r > i && ((r - i) % 2 == 0)) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new P829().consecutiveNumbersSum(9));
        System.out.println(new P829().consecutiveNumbersSum(5));
        System.out.println(new P829().consecutiveNumbersSum(15));
    }
}
