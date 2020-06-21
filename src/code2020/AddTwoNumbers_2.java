package code2020;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xhwang
 * @date: 2020-06-21 14:17
 * @link: https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers_2 {

    public static void main(String[] args) {
        ListNode l1a = new ListNode(1);
        ListNode l1c = new ListNode(8, l1a);

        ListNode l2a = new ListNode(0);
        ListNode l2b = new ListNode(6, l2a);
        ListNode l2c = new ListNode(4, l2b);

        ListNode listNode = addTwoNumbers(l1c, l2a);

        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     *
     * @param l1 (2 -> 4 -> 3)
     * @param l2 (5 -> 6 -> 4)
     * @return 807
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode listNode = null;
        ListNode result = null;
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        while (l1 != null) {
            list1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            list2.add(l2.val);
            l2 = l2.next;
        }

        int i = 0;
        int j = 0;
        int preIndex = 0;
        do {
            int data1 = i >= list1.size() ? 0 : list1.get(i) == null ? 0 : list1.get(i);
            int data2 = j >= list2.size() ? 0 : list2.get(j) == null ? 0 : list2.get(j);
            int sum = data2 + data1 + preIndex;
            preIndex = sum / 10;
            int val = sum % 10;
            if (result == null) {
                result = new ListNode(val);
                listNode = result;
            } else {
                listNode.next = new ListNode(val);
                listNode = listNode.next;
            }
            i += 1;
            j += 1;
        } while (i < list1.size() || j < list2.size());
        if (preIndex > 0) {
            listNode.next = new ListNode(1);
        }

        return result;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
