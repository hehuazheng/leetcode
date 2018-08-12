import java.util.HashMap;
import java.util.Map;

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
};

public class P138 {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode copy = new RandomListNode(0);
        RandomListNode p = head, p2 = copy;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (p != null) {
            p2.next = new RandomListNode(p.label);
            map.put(p, p2.next);
            p = p.next;
            p2 = p2.next;
        }
        p = head;
        p2 = copy.next;
        while (p != null) {
            p2.random = map.get(p.random);
            p = p.next;
            p2 = p2.next;
        }
        return copy.next;
    }
}
