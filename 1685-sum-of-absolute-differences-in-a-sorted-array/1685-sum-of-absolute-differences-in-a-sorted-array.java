class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];

        // Step 1: Prefix sum array
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int totalSum = prefix[n];

        // Step 2: Compute result for each index
        for (int i = 0; i < n; i++) {

            // Left side sum
            int leftSum = nums[i] * i - prefix[i];

            // Right side sum
            int rightSum = (totalSum - prefix[i + 1]) - nums[i] * (n - i - 1);

            result[i] = leftSum + rightSum;
        }

        return result;
    }
}
