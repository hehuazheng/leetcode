import java.util.ArrayList;
import java.util.List;

public class P876 {
    public ListNode middleNode(ListNode head) {
        int cnt = 0;
        List<ListNode> list = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            list.add(p);
            p = p.next;
        }
        int sz = list.size();
        return list.get(sz / 2);
    }
}
