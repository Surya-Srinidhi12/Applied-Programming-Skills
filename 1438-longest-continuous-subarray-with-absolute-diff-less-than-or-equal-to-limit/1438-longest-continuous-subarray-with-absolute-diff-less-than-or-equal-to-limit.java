import java.util.*;

class Solution {
    public int longestSubarray(int[] nums, int k) {
        Deque<Integer> maxD = new ArrayDeque<>();
        Deque<Integer> minD = new ArrayDeque<>();

        int left = 0;
        int res = 0;

        for (int right = 0; right < nums.length; right++) {
            while (!maxD.isEmpty() && nums[maxD.peekLast()] < nums[right]) {
                maxD.pollLast();
            }
            while (!minD.isEmpty() && nums[minD.peekLast()] > nums[right]) {
                minD.pollLast();
            }

            maxD.offerLast(right);
            minD.offerLast(right);

            while (nums[maxD.peekFirst()] - nums[minD.peekFirst()] > k) {
                if (maxD.peekFirst() == left) maxD.pollFirst();
                if (minD.peekFirst() == left) minD.pollFirst();
                left++;
            }

            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}