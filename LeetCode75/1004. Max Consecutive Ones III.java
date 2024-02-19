class Solution {
    public int longestOnes(int[] nums, int k) {
        int max=0;
        int size=nums.length;
        int max_1=0;

        for(int i=0; i<size; i++){
            int life=k;
            int count_1=0;
            //i를 시작으로 윈도우를 탐색한다. k개의 0을 1로 간주하고 연속된 1의 개수를 센다
            int j;
            for(j=0; i+j<size; j++){
                //1인상황은 j를 그냥 증가
                if(nums[i+j]==0){//0을 만났는데
                    if(life!=0){//flip가능하다면
                        life--;
                    } else{
                        break;
                    }
                }
            }
            count_1=j;
            if(count_1>max_1)
                max_1=count_1;
        }

        return max_1;
    }
}