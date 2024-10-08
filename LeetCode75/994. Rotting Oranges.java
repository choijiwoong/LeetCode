class Solution {
    int m, n;
    public int orangesRotting(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        int[][] grid_buf;
        int[][] directions=new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
        int minute;
        int[] index;
        boolean is_finish;
        boolean is_exist_0=false, is_exist_1=false, is_exist_2=false;

        List<int[]> list=new ArrayList<>(), buf_list=new ArrayList<>();
        for(int i=0; i<m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    list.add(new int[]{i, j});
                    is_exist_2=true;
                } else if(grid[i][j] == 1){
                    is_exist_1=true;
                } else{
                    is_exist_0=true;
                }
            }
        }
        //예외처리
        if(is_exist_0 && !is_exist_1 && !is_exist_2)
            return 0;//비어있는 공간만 있을 경우
        else if(!is_exist_2 && is_exist_1)
            return -1;//상한 사과가 없는데 신선한 사과가 있는 경우
        else if(!is_exist_1 && is_exist_2)
            return 0;//신선한 사과가 없고 상한 사과만 있는 경우

        for(minute=1; minute<m*n; minute++){
            for(int[] elem: list){
                for(int[] direction : directions){
                    int[] new_idx=new int[]{
                            elem[0]+direction[0],
                            elem[1]+direction[1]
                    };
                    if(is_valid_idx(new_idx) && grid[new_idx[0]][new_idx[1]]==1){
                        grid[new_idx[0]][new_idx[1]]=2;
                        buf_list.add(new_idx);
                    }
                }
            }

            list.clear();
            list.addAll(buf_list);
            buf_list.clear();
            //print_grid(grid);
            if(is_done(grid)) {
                return minute;
            }
        }
        return -1;
    }

    private boolean is_valid_idx(int[] index){
        //범위체크 종료조건
        return index[0] >= 0 && index[0] < m && index[1] >= 0 && index[1] < n;
    }

    private boolean is_done(int[][] grid){
        for(int i=0; i<grid.length; i++)
            for(int j=0; j<grid[0].length; j++)
                if(grid[i][j]==1)
                    return false;
        return true;
    }
}