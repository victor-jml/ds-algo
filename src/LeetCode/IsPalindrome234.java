import LinkedList.ListNode;

/**
 * @Author: zy
 * @Date: 2020/11/4 14:03
 * @Description:
 */
public class IsPalindrome234 {
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        ListNode mid = findMid(head);
        ListNode secondStart = reserve(mid.next);
        while(secondStart != null){
            if(head.val != secondStart.val){
                return false;
            }
            head = head.next;
            secondStart = secondStart.next;
        }
        return true;
    }

    public ListNode reserve(ListNode head){
        ListNode pre = null;
        ListNode tail = head;
        while(head != null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        tail = head;
        return pre;
    }


    public ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
