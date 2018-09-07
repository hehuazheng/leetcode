public class P24 {
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while(current.next != null && current.next.next != null) {
            ListNode n1 = current.next;
            ListNode n2 = current.next.next;
            n1.next = n2.next;
            n2.next = n1;
            current.next = n2;
            current = n1;
        }
        return dummy.next;
    }

    static void output(ListNode ln) {
        while(ln != null) {
            System.out.print(ln.val);
            ln = ln.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode ln = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ln.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;

        output(swapPairs(ln));
    }
}
