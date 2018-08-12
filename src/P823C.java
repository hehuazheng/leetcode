import util.Output;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给出一个含有不重复整数元素的数组，每个整数均大于 1。
 * <p>
 * 我们用这些整数来构建二叉树，每个整数可以使用任意次数。
 * <p>
 * 其中：每个非叶结点的值应等于它的两个子结点的值的乘积。
 * <p>
 * 满足条件的二叉树一共有多少个？返回的结果应模除 10 ** 9 + 7。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: A = [2, 4]
 * 输出: 3
 * 解释: 我们可以得到这些二叉树: [2], [4], [4, 2, 2]
 * 示例 2:
 * <p>
 * 输入: A = [2, 4, 5, 10]
 * 输出: 7
 * 解释: 我们可以得到这些二叉树: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= A.length <= 1000.
 * 2 <= A[i] <= 10 ^ 9.
 * 您是否在真实的面试环节中遇到过这道题目呢？
 */
public class P823C {
    public int numFactoredBinaryTrees(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            return A.length;
        }
        Arrays.sort(A);
        int MOD = 1_000_000_007;
        long[] dp = new long[A.length];
        Arrays.fill(dp, 1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], i);
            for (int j = 0; j < i; j++) {
                if (A[i] % A[j] == 0) {
                    int divide = A[i] / A[j];
                    if (map.get(divide) != null) {
                        dp[i] = (dp[i] + dp[j] * dp[map.get(divide)]) % MOD;
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            ans = (int) ((ans + dp[i]) % MOD);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P823C().numFactoredBinaryTrees(new int[]{2, 4}));
        System.out.println(new P823C().numFactoredBinaryTrees(new int[]{2, 4, 5, 10}));
    }
}
