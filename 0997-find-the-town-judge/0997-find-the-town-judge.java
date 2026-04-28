class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustScores = new int[n + 1];
        
        for (int[] relationship : trust) {
            trustScores[relationship[0]]--; 
            trustScores[relationship[1]]++;
        }
        
        for (int i = 1; i <= n; i++) {
            if (trustScores[i] == n - 1) {
                return i;
            }
        }
        
        return -1;
    }
}