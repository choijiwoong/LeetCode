class Solution {
    public int equalPairs(int[][] grid) {
        int size=grid.length;

        int result=0;
        for(int i=0; i<size; i++){//비교대상 가로줄
            for(int j=0; j<size; j++){//비교타겟 세로줄
                boolean is_match=true;
                for(int k=0; k<size; k++) {//세로줄 탐색
                    if(grid[i][k]!=grid[k][j]){
                        is_match=false;
                        break;
                    }
                }
                if(is_match)
                    result++;
            }
        }
        return result;
    }
}