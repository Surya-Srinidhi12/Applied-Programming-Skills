class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        // Step 1: Check if we have at least k nodes
        ListNode temp = head;
        int count = 0;

        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }

        // If nodes are less than k, return head
        if (count < k) return head;

        // Step 2: Reverse first k nodes
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        count = 0;
        while (count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        // Step 3: Recursive call for remaining list
        head.next = reverseKGroup(curr, k);

        // Step 4: prev is new head of reversed group
        return prev;
    }
}
