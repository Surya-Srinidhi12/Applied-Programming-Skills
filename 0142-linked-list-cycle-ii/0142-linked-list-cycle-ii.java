public class Solution {
    public ListNode detectCycle(ListNode head) {

        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect cycle
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            // Cycle found
            if (slow == fast) {

                // Step 2: Find starting node of cycle
                ListNode entry = head;

                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }

                return entry; // Cycle start node
            }
        }

        return null; // No cycle
    }
}
