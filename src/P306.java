class Solution {
    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        if(len < 3) {
            return false;
        }

        for (int i = 1; i < len; i++) {
            String first = num.substring(0, i);
            if(first.charAt(0) == '0' && i > 1) {
                break;
            }
            for (int j = i + 1; j < len; j++) {
                String second = num.substring(i, j);
                if(num.charAt(j) == '0') {
                    second = "0";
                }
                String sum = String.valueOf(Long.parseLong(first) + Long.parseLong(second));
                String rest = num.substring(j);
                if(!rest.startsWith(sum)) {
                    continue;
                }
                if(rest.length() == sum.length()) {
                    return true;
                }


                int k = j;
                while(true) {
                    first = second;
                    second = sum;
                    k += sum.length();
                    if(k >= len) {
                        break;
                    }
                    sum = String.valueOf(Long.parseLong(first) + Long.parseLong(second));
                    rest = num.substring(k);
                    if(sum.equals(rest)) {
                        return true;
                    }
                    if(!rest.startsWith(sum)) {
                        break;
                    }
                }
            }
        }
        return false;
    }
}

public class P306 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isAdditiveNumber("112358"));
    }
}
