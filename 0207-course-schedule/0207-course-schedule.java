import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
        }

        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            for(int v : graph.get(i)) {
                indegree[v]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            count++;

            for(int nei : graph.get(curr)) {
                indegree[nei]--;
                if(indegree[nei] == 0) {
                    queue.add(nei);
                }
            }
        }

        return count == numCourses;
    }
}