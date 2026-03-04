public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null)
            return null;

        ListNode pA = headA;
        ListNode pB = headB;

        // Traverse until both pointers meet
        while (pA != pB) {

            // Move to next or switch head
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }

        // Either intersection node or null
        return pA;
    }
}
