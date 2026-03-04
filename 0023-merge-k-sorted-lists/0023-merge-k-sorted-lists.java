import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        // Min Heap based on node value
        PriorityQueue<ListNode> pq =
                new PriorityQueue<>((a, b) -> a.val - b.val);

        // Step 1: Add first node of each list into heap
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        // Dummy node for merged list
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Step 2: Extract min and build merged list
        while (!pq.isEmpty()) {

            ListNode minNode = pq.poll();
            current.next = minNode;
            current = current.next;

            // Step 3: Add next node of extracted node
            if (minNode.next != null) {
                pq.add(minNode.next);
            }
        }

        return dummy.next;
    }
}
