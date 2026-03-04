class Solution {
    public int[] runningSum(int[] nums) {

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];   // Add current element
            nums[i] = sum;         // Store running sum
        }

        return nums;
    }
}
