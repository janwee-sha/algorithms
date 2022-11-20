package LinkedList;

//remove the elements in linked list which val equals to given val
public class RemoveElements {
    public interface Solution {
        ListNode removeElements(ListNode head, int val);
    }

    //use recursion.
    //time complexity:O(N),space complexity:O(N).
    public static class Solution1 implements Solution {
        public ListNode removeElements(ListNode head, int val) {
            if (head == null) return null;
            head.next = removeElements(head.next, val);
            return head.val == val ? head.next : head;
        }
    }

    //use iteration.
    //time complexity:O(N),space complexity:O(1).
    public static class Solution2 implements Solution {
        public ListNode removeElements(ListNode head, int val) {
            if (head == null) return null;
            ListNode node = new ListNode(0, head);
            head = node;
            while (node.next != null) {
                if (node.next.val == val) node.next = node.next.next;
                else node = node.next;
            }
            return head.next;
        }
    }
}
