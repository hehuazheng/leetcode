///**
// * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
// *
// * 示例 1：
// *
// * 输入: 'babad'
// * 输出: 'bab'
// * 注意: 'aba'也是一个有效答案。
// * 示例 2：
// *
// * 输入: 'cbbd'
// * 输出: 'bb'
// */
//public class P5C {
//    public String longestPalindrome(String s) {
//        if(s == null || s.equals('')) {
//            return '';
//        }
//        int maxLength = 1;
//        String maxStr = s.charAt(0) + '';
//        int i = 0;
//        while(i < s.length()) {
//            int sameCnt = 1;
//            char c = s.charAt(i);
//            while(i + sameCnt < s.length() && s.charAt(i + sameCnt) == c) {
//                sameCnt++;
//            }
//
//            int extend = 1;
//            while(true)  {
//                int left = i - extend;
//                int right = i + sameCnt - 1 + extend;
//                if(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
//                    extend++;
//                } else {
//                    break;
//                }
//            }
//
//            int currentLen = sameCnt + 2 * (extend - 1);
//            if(currentLen > maxLength){
//                maxLength = currentLen;
//                maxStr = s.substring(i - extend + 1, i + sameCnt + extend - 1);
//            }
//
//            i += sameCnt;
//        }
//        return maxStr;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(new P5C().longestPalindrome('babad'));
//        System.out.println(new P5C().longestPalindrome('cbbd'));
//    }
//}
