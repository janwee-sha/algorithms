package linkedlist;

import java.util.HashSet;
import java.util.Set;

//给定一个链表，若链表有环，返回环的入口节点；若无环，则返回null
public class FindCycleEntrance {

    //Solution 1:use a set to store iterated ListNodes.
    public static class Solution1 {
        public ListNode findCycleEntrance(ListNode head) {
            Set<ListNode> nodes = new HashSet<>();
            if (head != null && head.next != null) {
                while (head.next != null) {
                    if (!nodes.add(head)) return head;
                    else head = head.next;
                }
            }
            return null;
        }
    }

    //Solution 2:use a slower pointer and a faster pointer.
    public static class Solution2 {
        public ListNode findCycleEntrance(ListNode head) {
            if (head == null) return null;

            ListNode slow = head, fast = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    slow = head;
                    while (fast != slow) {
                        fast = fast.next;
                        slow = slow.next;
                    }
                    return fast;
                }
            }
            return null;
        }
    }
}
