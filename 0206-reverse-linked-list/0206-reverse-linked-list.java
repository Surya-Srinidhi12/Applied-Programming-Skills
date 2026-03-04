class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            // Store next node
            ListNode nextNode = curr.next;

            // Reverse link
            curr.next = prev;

            // Move pointers forward
            prev = curr;
            curr = nextNode;
        }

        return prev; // New head
    }
}
