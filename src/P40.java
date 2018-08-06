import java.util.*;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * Each number in candidates may only be used once in the combination.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * Example 2:
 * <p>
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 * [1,2,2],
 * [5]
 * ]
 */
public class P40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        recur(candidates, 0, target);
        Collections.sort(result, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int minLen = o1.size();
                if (o2.size() < minLen) {
                    minLen = o2.size();
                }

                for (int i = 0; i < minLen; i++) {
                    if (o1.get(i) < o2.get(i)) {
                        return -1;
                    } else if (o1.get(i) > o2.get(i)) {
                        return 1;
                    }
                }
                if (o1.size() > minLen) {
                    return 1;
                } else if (o2.size() > minLen) {
                    return -1;
                }
                return 0;
            }
        });
        Iterator<List<Integer>> itor = result.iterator();
        List<Integer> prev = null;
        while(itor.hasNext()) {
            if(prev == null) {
                prev = itor.next();
            } else {
                List<Integer> current = itor.next();
                if(prev.size() == current.size()) {
                    boolean equal = true;
                    for (int i = 0; i < prev.size(); i++) {
                        if(!prev.get(i).equals(current.get(i))) {
                            equal = false;
                            break;
                        }
                    }
                    if(equal) {
                        itor.remove();
                    }
                }
                prev = current;
            }
        }
        return result;
    }

    List<Integer> list = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    void recur(int[] candidates, int start, int target) {
        if (candidates[start] == target) {
            List<Integer> copyList = new ArrayList<>(list.size());
            for (int i = 0; i < list.size(); i++) {
                copyList.add(list.get(i));
            }
            copyList.add(candidates[start]);
            result.add(copyList);
        } else if (candidates[start] < target) {
            if(start + 1 < candidates.length) {
                list.add(candidates[start]);
                recur(candidates, start + 1, target - candidates[start]);
                list.remove(list.size() - 1);

                recur(candidates, start + 1, target);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new P40().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println(list);

        list = new P40().combinationSum2(new int[]{1}, 2);
        System.out.println(list);
    }
}
