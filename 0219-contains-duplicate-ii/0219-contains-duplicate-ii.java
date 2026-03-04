import java.util.HashMap;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            // If number already exists
            if (map.containsKey(nums[i])) {
                int prevIndex = map.get(nums[i]);

                // Check distance
                if (i - prevIndex <= k) {
                    return true;
                }
            }

            // Update last index of number
            map.put(nums[i], i);
        }

        return false;
    }
}
