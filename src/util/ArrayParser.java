package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayParser {
    public static int[][] parseArray(String s) {
        int b = s.lastIndexOf('[');
        List<List<Integer>> list = new ArrayList<>();
        while (b != -1) {
            boolean canStop = true;
            for (int i = 1; i < s.length()-1; i++) {
                if( s.charAt(i) != ',') {
                    canStop = false;
                    break;
                }
            }
            if(canStop) {
                break;
            }
            s = s.replaceAll(",,+", "");
            int e = s.indexOf(']', b);
            String content = s.substring(b+1, e);
            if(content.length() == 0) {
                break;
            }
            list.add(Arrays.stream(content.split(",")).map(Integer::parseInt).collect(Collectors.toList()));
            s = s.substring(0, b) + s.substring(e+1);
            b = s.lastIndexOf('[');
        }
        Collections.reverse(list);
        int r = list.size();
        int c = list.get(0).size();
        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = list.get(i).get(j);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(parseArray("[[1,2,3],[4,5,6],[7,8,9]]"));
    }
}
