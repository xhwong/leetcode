package code2019;

/**
 * @author xhowng
 * @date 2019/7/1
 */
public class day0705 {
    public static void main(String[] args){


    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null ||head.next == null){
            return head;
        }

        do{

        }while(head.next != null);
        return head;
    }

    class ListNode{
        int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
