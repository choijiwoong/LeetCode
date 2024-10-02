class Solution {
    int m, n;
    public int orangesRotting(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        int max=Math.max(m, n);
        Queue<int[]> queue=new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int minute;
        int[] index;
        int[][] directions=new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
        Queue<int[]> buf_queue=new LinkedList<>();
        for(minute=0; minute<max+1; minute++){//
            while(!queue.isEmpty()){
                index=queue.poll();

                for(int[] direction: directions){
                    int[] new_index=new int[]{index[0]+direction[0], index[1]+direction[1]};
                    if(is_valid_idx(new_index) && grid[new_index[0]][new_index[1]] == 1) {
                        grid[new_index[0]][new_index[1]]=2;
                        buf_queue.add(new_index);
                    }
                }
            }
            queue.addAll(buf_queue);
            buf_queue.clear();

            if(queue.isEmpty())
                break;
        }

        if(minute==max)
            return -1;

        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                if(grid[i][j]==1)
                    return -1;

        return minute;
    }

    private boolean is_valid_idx(int[] index){
        if(index[0]<0 || index[0]>=m || index[1]<0 || index[1]>=n)//범위체크 종료조건
            return false;
        return true;
    }
}