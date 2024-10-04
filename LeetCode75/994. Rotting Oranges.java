class Solution {
    int m, n;
    public int orangesRotting(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        int max=Math.max(m, n);
        Queue<int[]> queue=new LinkedList<>();
        int[][] grid_buf;
        int[][] directions=new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
        int minute;
        int[] index;
        boolean is_finish;
        int min_minute=-1;
        boolean is_exist_0=false, is_exist_1=false, is_exist_2=false;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==2){
                    is_exist_2=true;
                    //얘부터 시작했을 때
                    queue.add(new int[]{i, j});
                    grid_buf=new int[grid.length][grid[0].length];
                    for(int gi=0; gi<m; gi++)
                        for(int gj=0; gj<n; gj++)
                            grid_buf[gi][gj]=grid[gi][gj];
                    is_finish=true;
                    minute=0;

                    int level=queue.size();
                    while(!queue.isEmpty()){//하나씩 오염시킬 사과의 위치가 담김
                        index=queue.poll();//인덱스를 가져와서
                        for(int[] direction: directions){//사 방향에 대해 유효한 인덱스고 신선한 사과가 있을 때
                            int[] new_index=new int[]{index[0]+direction[0], index[1]+direction[1]};
                            if(is_valid_idx(new_index) && grid_buf[new_index[0]][new_index[1]] == 1) {
                                grid_buf[new_index[0]][new_index[1]]=2;//오염시킨다.
                                queue.add(new_index);//감염된 사과의 위치를 추가함
                            }
                        }
                        level--;
                        if(level==0) {
                            minute++;
                            level = queue.size();
                        }
                    }
                    //더이상 오염시킬 사과가 없다면(큐는 비어있는 상태)
                    //성공적으로 모든 사과가 감염되었는지 확인
                    for(int ii=0; ii<m; ii++) {
                        for (int jj = 0; jj < n; jj++) {
                            if (grid_buf[ii][jj] == 1) {
                                is_finish = false;
                                break;
                            }
                        }
                        if(!is_finish)
                            break;
                    }

                    if(is_finish){//전부 감염 성공
                        minute--;
                        if(min_minute==-1) {
                            min_minute=minute;
                        } else if(min_minute>minute){//최단 시간 갱신
                            min_minute=minute;
                        }
                    }
                } else if(grid[i][j]==1){
                    is_exist_1=true;
                } else if(grid[i][j]==0){
                    is_exist_0=true;
                }
            }
        }
        
        if(is_exist_0 && !is_exist_1 && !is_exist_2)//비어있음
            return 0;
        else if(is_exist_1 && !is_exist_2)
            return -1;

        return min_minute;
    }

    private boolean is_valid_idx(int[] index){
        //범위체크 종료조건
        return index[0] >= 0 && index[0] < m && index[1] >= 0 && index[1] < n;
    }
}