/**
 * @author: xhwang
 * @Date: 11/14/22 9:13 PM
 */
public class Main1114 {

    public static void main(String[] args) {
        ListNode1 node1 = new ListNode1(1);
        ListNode1 node2 = new ListNode1(2);
        ListNode1 node3 = new ListNode1(3);
        ListNode1 node4 = new ListNode1(4);
        node3.next = node4;
        node2.next = node3;
        node1.next = node2;
        ListNode1 node = swapPairs(node1);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    public static ListNode1 swapPairs(ListNode1 head) {
        //特殊情况
        if (head == null || head.next == null) {
            return head;
        }

        ListNode1 newTemp = new ListNode1(0);
        newTemp.next = head;
        ListNode1 temp = newTemp;

        while (head != null && head.next != null) {
            temp.next = head.next;
            head.next = temp.next.next;
            temp.next.next=head;

            temp = temp.next.next;
            head = temp.next;
        }
        
        return newTemp.next;
    }

    public static class ListNode1 {
        int val;
        ListNode1 next;

        ListNode1(int x) {
            val = x;
        }
    }
}
