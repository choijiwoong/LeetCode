class Solution {
    public static int minReorder(int n, int[][] connections) {
        int result = 0;
        List<List<Integer>> adj = new ArrayList<>(n);
        List<List<Integer>> reverseAdj = new ArrayList<>(n);

        // 인접 리스트 초기화
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            reverseAdj.add(new ArrayList<>());
        }

        // 인접 리스트와 역방향 인접 리스트 구성
        for (int[] conn : connections) {
            adj.get(conn[0]).add(conn[1]);
            reverseAdj.get(conn[1]).add(conn[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.add(0);
        visited[0] = true;

        // BFS를 통해 모든 노드 방문
        while (!queue.isEmpty()) {
            int node = queue.poll();
            
            // 정방향 인접 리스트 탐색
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    result++;
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }

            // 역방향 인접 리스트 탐색
            for (int neighbor : reverseAdj.get(node)) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }

        return result;
    }
}