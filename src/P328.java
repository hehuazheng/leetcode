public class P328 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode p = head;
        ListNode oddHead = new ListNode(0);
        ListNode evenHead = new ListNode(0);
        ListNode odd = oddHead, even = evenHead;
        while (p != null) {
            odd.next = p;
            odd = odd.next;
            even.next = p.next;
            if (even.next != null) {
                even = even.next;
                p = even.next;
            } else {
                break;
            }
        }
        odd.next = evenHead.next;
        return oddHead.next;
    }

    static void print(ListNode ln) {
        ListNode p = ln;
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] vals = new int[]{1, 2, 3, 4, 5};
        ListNode listNode = new ListNode(0);
        ListNode prev = listNode;
        for (int i = 0; i < vals.length; i++) {
            ListNode ln = new ListNode(vals[i]);
            prev.next = ln;
            prev = ln;
        }

        print(new P328().oddEvenList(listNode.next));
    }
}
