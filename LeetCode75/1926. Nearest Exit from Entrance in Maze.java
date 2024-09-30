class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int rowLength = maze.length;
        int colLength = maze[0].length;
        boolean[][] visited = new boolean[rowLength][colLength];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance); // 큐가 다 차면 예외를 반환하는 .add와 달리 false를 반환한다.
        visited[entrance[0]][entrance[1]] = true;

        int steps = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};//가능한 방향을 배열로

        while (!queue.isEmpty()) {
            int size = queue.size(); // Current level size

            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll(); // .remove와 달리 비어있으면 null을 반환한다.

                if ((pos[0] != entrance[0] || pos[1] != entrance[1]) &&
                        (pos[0] == 0 || pos[1] == 0 || pos[0] == rowLength - 1 || pos[1] == colLength - 1)) {
                    return steps;
                } // 종료조건: 입구가 아닌 모서리인 경우 현재의 level을 리턴한다.
                
                for (int[] direction : directions) {//모든 이동가능한 방향에 대하여
                    int newRow = pos[0] + direction[0];
                    int newCol = pos[1] + direction[1];

                    // IOR이 아니고 길에다 방문하지 않은 노드에 대해 enqueue를 수행한다.
                    if (newRow >= 0 && newCol >= 0 && newRow < rowLength && newCol < colLength &&
                            maze[newRow][newCol] == '.' && !visited[newRow][newCol]) {
                        visited[newRow][newCol] = true;
                        queue.offer(new int[] {newRow, newCol});
                    }
                }
            }
            steps++;
        }

        return -1; // Return -1 if no exit is found
    }
}