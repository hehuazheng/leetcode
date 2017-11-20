import java.util.Stack;

/**
 * Created by hejf on 2017/11/20.
 */
public class P712 {
    public int computeWeight(String str) {
        int weight = 0;
        for (int i = 0; i < str.length(); i++) {
            weight += str.charAt(i);
        }
        return weight;
    }

    public int minimumDeleteSum(String s1, String s2) {
        int[][] tb = new int[s1.length() + 1][s2.length() + 1];
        String[][] paths = new String[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length() + 1; i++) {
            for (int j = 0; j < s2.length() + 1; j++) {
                paths[i][j] = "";
            }
        }
        int[][] weights = new int[s1.length() + 1][s2.length() + 1];
        int maxWeight = 0, maxI = 0, maxJ = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    tb[i][j] = tb[i - 1][j - 1] + 1;
                    paths[i][j] = paths[i - 1][j - 1] + s1.charAt(i - 1);
                    weights[i][j] = weights[i - 1][j - 1] + s1.charAt(i - 1);
                } else {
                    int weightI = weights[i - 1][j];
                    int weightJ = weights[i][j - 1];
                    if (weightI == 0) {
                        weightI = computeWeight(paths[i - 1][j]);
                        weights[i - 1][j] = weightI;
                    }
                    if (weightJ == 0) {
                        weightJ = computeWeight(paths[i][j - 1]);
                        weights[i][j - 1] = weightJ;
                    }

                    if (weightI > weightJ) {
                        tb[i][j] = tb[i - 1][j];
                        paths[i][j] = paths[i - 1][j];
                        weights[i][j] = tb[i - 1][j];
                    } else {
                        tb[i][j] = tb[i][j - 1];
                        paths[i][j] = paths[i][j - 1];
                        weights[i][j] = tb[i][j - 1];
                    }
                }
                if (maxWeight < weights[i][j]) {
                    maxWeight = weights[i][j];
                    maxI = i;
                    maxJ = j;
                }
            }
        }

        String target = paths[maxI][maxJ];
        int sum = 0;
        int j = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (j < target.length()) {
                if (s1.charAt(i) == target.charAt(j)) {
                    j++;
                } else {
                    sum += s1.charAt(i);
                }
            } else {
                sum += s1.charAt(i);
            }
        }
        j = 0;
        for (int i = 0; i < s2.length(); i++) {
            if (j < target.length()) {
                if (s2.charAt(i) == target.charAt(j)) {
                    j++;
                } else {
                    sum += s2.charAt(i);
                }
            } else {
                sum += s2.charAt(i);
            }
        }

        return sum;
    }

    public int minimumDeleteSum2(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 2];
        for (int i = s1.length() - 1; i >= 0; i--) {
            dp[i][s2.length()] = dp[i + 1][s2.length()] + s1.charAt(i);
        }
        for (int i = s2.length() - 1; i >= 0; i--) {
            dp[s1.length()][i] = dp[s1.length()][i + 1] + s2.charAt(i);
        }
        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j] + s1.charAt(i), dp[i][j + 1] + s2.charAt(j));
                }
            }
        }

        Stack<Character> stack = new Stack<>();
        recursive(s1, s2, dp, 0, 0, stack);
        System.out.println(stack); //路径
        return dp[0][0];
    }

    void recursive(String s1, String s2, int[][] dp, int i, int j, Stack<Character> stack) {
        if (i < s1.length() && j < s2.length() && dp[i][j] == dp[i + 1][j + 1]) {
            if (i < s1.length()) {
                stack.push(s1.charAt(i));
                recursive(s1, s2, dp, i + 1, j + 1, stack);
            }
        } else {
            if (i < s1.length() && dp[i][j] == dp[i + 1][j] + s1.charAt(i)) {
                recursive(s1, s2, dp, i + 1, j, stack);
            } else if (j < s2.length() && dp[i][j] == dp[i][j + 1] + s2.charAt(j)) {
                recursive(s1, s2, dp, i, j + 1, stack);
            }
        }
    }

    public static void main(String[] args) {
        int sum1 = new P712().minimumDeleteSum2("delete", "leet");
        System.out.println(sum1);
        int sum2 = new P712().minimumDeleteSum2("sea", "eat");
        System.out.println(sum2);
        int sum3 = new P712().minimumDeleteSum2("sjfqkfxqoditw", "fxymelgo");
        System.out.println(sum3);
    }
}
