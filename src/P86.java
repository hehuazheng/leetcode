public class P86 {
    public static ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(0);
        ListNode equalOrGreatHead = new ListNode(0);
        ListNode p = head, lp = lessHead, egp = equalOrGreatHead;
        while(p != null) {
            if(p.val < x) {
                lessHead.next = p;
                lessHead = p;
            } else {
                equalOrGreatHead.next = p;
                equalOrGreatHead = p;
            }
            p = p.next;
        }
        equalOrGreatHead.next = null;
        lessHead.next = egp.next;
        return lp.next;
    }

    public static void main(String[] args) {
        ListNode ln1 = new ListNode(1);
        ListNode ln2_1 = new ListNode(2);
        ListNode ln2_2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);
        ln1.next =ln4;
        ln4.next = ln3;
        ln3.next = ln2_1;
        ln2_1.next = ln5;
        ln5.next = ln2_2;
        Output.output(partition(ln1, 3));
    }
}
