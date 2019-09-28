public class P8 {
    public int myAtoi(String str) {
        str = str.trim();
        if(str.length() == 0) {
            return 0;
        }
        long result = 0;
        long sign = 1;
        int i = 0;
        if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        }
        for (; i < str.length(); i++) {
            int c = str.charAt(i) - '0';
            if (c >= 0 && c <= 9) {
                result = result * 10 + c;
                if(result > Integer.MAX_VALUE) {
                    break;
                }
            } else {
                break;
            }
        }
        if(sign == -1 &&-result < Integer.MIN_VALUE ) {
            return Integer.MIN_VALUE;
        } else if(sign == 1 && result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) (sign * result);
    }

    public static void main(String[] args) {
        System.out.println(new P8().myAtoi("42"));
//        System.out.println(new P8().myAtoi('   -42'));
//        System.out.println(new P8().myAtoi('4193 with words'));
//        System.out.println(new P8().myAtoi('words and 987'));
//        System.out.println(new P8().myAtoi('-91283472332'));
    }
}
