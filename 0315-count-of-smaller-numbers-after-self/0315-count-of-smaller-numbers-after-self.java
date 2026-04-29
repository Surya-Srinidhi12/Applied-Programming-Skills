import java.util.*;

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        int[][] arr = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        
        mergeSort(arr, count, 0, n - 1);
        
        List<Integer> result = new ArrayList<>();
        for (int c : count) result.add(c);
        return result;
    }
    
    private void mergeSort(int[][] arr, int[] count, int left, int right) {
        if (left >= right) return;
        
        int mid = (left + right) / 2;
        mergeSort(arr, count, left, mid);
        mergeSort(arr, count, mid + 1, right);
        merge(arr, count, left, mid, right);
    }
    
    private void merge(int[][] arr, int[] count, int left, int mid, int right) {
        int[][] temp = new int[right - left + 1][2];
        int i = left, j = mid + 1, k = 0, rightCount = 0;
        
        while (i <= mid && j <= right) {
            if (arr[i][0] <= arr[j][0]) {
                count[arr[i][1]] += rightCount;
                temp[k++] = arr[i++];
            } else {
                rightCount++;
                temp[k++] = arr[j++];
            }
        }
        
        while (i <= mid) {
            count[arr[i][1]] += rightCount;
            temp[k++] = arr[i++];
        }
        
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        
        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
    }
}