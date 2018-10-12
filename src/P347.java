import java.util.*;

public class P347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            int cnt = map.getOrDefault(i, 0);
            map.put(i, cnt + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> {
            int aCnt = map.get(a);
            int bCnt = map.get(b);
            if (aCnt > bCnt) {
                return -1;
            } else if (aCnt < bCnt) {
                return 1;
            }
            return a < b ? -1 : 1;
        });
        return list.subList(0, k);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        System.out.println(new P347().topKFrequent(nums, 2));
    }
}
