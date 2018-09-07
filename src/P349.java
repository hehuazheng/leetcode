import java.util.*;

public class P349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length == 0  || nums2.length == 0) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        Set<Integer> set = new HashSet<>();
        int p1 = 0, p2 = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                p1++;
            } else if (nums1[p1] > nums2[p2]) {
                p2++;
            } else {
                set.add(nums1[p1]);
                p1++;
                p2++;
            }
        }
        int[] result = new int[set.size()];
        int i = 0;
        for (int v : set) {
            result[i++] = v;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Output.toString(new P349().intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Output.toString(new P349().intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }
}
