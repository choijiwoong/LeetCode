class Solution {
    public int rob(int[] nums) {
        int length=nums.length;

        if(length==1)//간단한 케이스 처리
            return nums[0];
        else if (length==2) {
            return Math.max(nums[0], nums[1]);
        }

        int[][] relative_nums=new int[length][2];
        relative_nums[0][0]=nums[0]-nums[1];
        relative_nums[length-1][0]=nums[length-1]-nums[length-2];
        relative_nums[0][1]=0;
        relative_nums[length-1][1]=length-1;
        for(int i=1; i<length-1; i++){
            relative_nums[i][0]+=nums[i]-(nums[i-1]+nums[i+1]);
            relative_nums[i][1]=i;
        }

        Arrays.sort(relative_nums, Comparator.comparingInt(n -> -n[0]));

        int max_money=0;
        boolean[] visited=new boolean[length];
        for(int i=0; i<length; i++){
            int cur_idx=relative_nums[i][1];
            if(is_available(visited, cur_idx)){
                max_money+=nums[cur_idx];
                visited[cur_idx]=true;
            }
        }

        return max_money;
    }

    private boolean is_available(boolean[] visited, int index){
        if(visited[index]){//이미 접근한 곳을 확인하지 않는 로직으로 호출해야 한다.
            System.out.println("ERROR!");
            return false;
        }

        if(index==0){
            if(visited[index+1])
                return false;
            else
                return true;
        } else if(index==visited.length-1){
            if(visited[index-1])
                return false;
            else
                return true;
        }

        if(visited[index-1]||visited[index+1])
            return false;

        return true;
    }
}