import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        // Step 1: Create graph (Adjacency List)
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Step 2: DFS
        boolean[] visited = new boolean[n];
        return dfs(graph, visited, source, destination);
    }

    private boolean dfs(List<List<Integer>> graph, boolean[] visited, int node, int destination) {
        if(node == destination) return true;

        visited[node] = true;

        for(int neighbor : graph.get(node)) {
            if(!visited[neighbor]) {
                if(dfs(graph, visited, neighbor, destination)) {
                    return true;
                }
            }
        }

        return false;
    }
}