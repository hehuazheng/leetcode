import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class P32C {
    static class Valid {
        int s;
        int e;

        public Valid(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    public void merge(List<Valid> list) {
        Valid prev = null;
        Iterator<Valid> itor = list.iterator();
        while (itor.hasNext()) {
            if (prev == null) {
                prev = itor.next();
            } else {
                Valid current = itor.next();
                if (prev.e + 1 == current.s) {
                    prev.e = current.e;
                    itor.remove();
                }
            }
        }
    }

    public int longestValidParentheses(String s) {
        if (s == null || s.trim().equals("")) {
            return 0;
        }

        int pos = findLastLeftParenPos(s, s.length() - 1);
        int len = s.length();

        List<Valid> list = new ArrayList<>();
        while (pos != -1) {
            if (pos + 1 < len && s.charAt(pos + 1) == ')') {
                boolean merged = false;
                for (Valid v : list) {
                    if (v.s == pos + 2) {
                        v.s = pos;
                        merged = true;
                        break;
                    }
                }
                if (!merged) {
                    if (list.size() > 0 && pos < list.get(0).s) {
                        list.add(0, new Valid(pos, pos + 1));
                    } else {
                        list.add(new Valid(pos, pos + 1));
                    }
                }
            } else {
                for (Valid v : list) {
                    if (v.s == pos + 1 && (v.e + 1 < len && s.charAt(v.e + 1) == ')')) {
                        v.s = pos;
                        v.e = v.e + 1;
                        break;
                    }
                }
                merge(list);
            }
            pos = findLastLeftParenPos(s, pos - 1);
        }

        int max = 0;
        for (Valid v : list) {
            if (max < v.e - v.s + 1) {
                max = v.e - v.s + 1;
            }
        }
        return max;
    }


    int findLastLeftParenPos(String s, int from) {
        while (from >= 0 && s.charAt(from) != '(') {
            from--;
        }
        return from;
    }

    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(new P32C().longestValidParentheses(s));

        s = "(()";
        System.out.println(new P32C().longestValidParentheses(s));

        s = "((()))())";
        System.out.println(new P32C().longestValidParentheses(s));
    }
}
