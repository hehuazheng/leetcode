public class P6C {
    public String convert(String s, int numRows) {
        if (s == null || "".equals(s) || s.length() == 1 || numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int gap = 2 * numRows - 2;
        for (int j = 0; j < numRows; j++) {
            for (int i = 0; i + j < len; i += gap) {
                sb.append(s.charAt(i + j));
                int r = i + gap;
                if (j != numRows - 1 && j != 0 && r - j < len) {
                    sb.append(s.charAt(r - j));
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new P6C().convert("PAYPALISHIRING", 3));
        System.out.println(new P6C().convert("PAYPALISHIRING", 4));
        System.out.println(new P6C().convert("AB", 1));
    }
}
