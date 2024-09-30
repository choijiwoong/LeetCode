class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        if(maze.length==0){
            System.out.println("배열이 비어있습니다.");
            return -1;
        } else if(entrance.length!=2){
            System.out.println("올바르지 않은 입구입니다.");
            return -1;
        }

        Queue<int[]> queue=new LinkedList<>();
        queue.add(entrance);

        return bfs(maze, queue);
    }

    private int bfs(char[][] maze, Queue<int[]> queue){
        int m=maze.length, n=maze[0].length;
        int depth=-1;
        int flag=queue.size();
        boolean[][] is_visited=new boolean[m][n];
        boolean is_found=false;

        while(!queue.isEmpty()){
            flag--;
            if(flag==0){
                depth++;
                flag=queue.size();
            }

            int[] entrance = queue.remove();
            int i = entrance[0], j = entrance[1];

            //범위 초과
            if (i < 0 || i >= m || j < 0 || j >= n) {
                continue;
            }

            //방문했으면 패스
            if(is_visited[i][j])
                continue;
            is_visited[i][j]=true;

            //벽이면 패스
            if (maze[i][j] == '+')
                continue;
            else if (depth != 0 //입구를 출구로 판단 방지
                    && (i == 0 || i == m - 1 || j == 0 || j == n - 1) //모서리 확인
            ) {
                is_found=true;
                break;
            }

            queue.add(new int[]{i - 1, j});
            queue.add(new int[]{i + 1, j});
            queue.add(new int[]{i, j - 1});
            queue.add(new int[]{i, j + 1});
        }
        return is_found?depth:-1;
    }

    public void test(int result, int answer){
        System.out.printf("answer: %d, result: %d\t", answer, result);
        if(answer==result){
            System.out.println("passed!");
        } else{
            System.out.println("fail!");
        }
    }
}