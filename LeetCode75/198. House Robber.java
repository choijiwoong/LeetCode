class Solution {
    public int rob(int[] nums) {
        int length=nums.length;

        if(length==2){
            return Math.max(nums[0], nums[1]);
        } else if(length==3){
            return Math.max(nums[1], nums[0]+nums[2]);
        }

        Integer[][] indexedArray=new Integer[length][2];
        for(int i=0; i<length; i++){
            indexedArray[i][0]=nums[i];
            indexedArray[i][1]=i;
        }
        Arrays.sort(indexedArray, (a,b)->Integer.compare(b[0],a[0]));

        boolean[] visited=new boolean[length];

        int max_val=indexedArray[0][0], prev_index=indexedArray[0][1];
        visited[prev_index]=true;
        for(int i=1; i<length; i++){
            int cur_index=indexedArray[i][1];

            if(cur_index==0 && !visited[cur_index] && cur_index+1<length &&!visited[cur_index+1]){
                visited[cur_index]=true;
                max_val+=indexedArray[i][0];
            }

            if(cur_index==length-1 && !visited[cur_index] && cur_index-1>=0 &&!visited[cur_index-1]){
                visited[cur_index]=true;
                max_val+=indexedArray[i][0];
            }

            if(!visited[cur_index] && cur_index-1>=0 && cur_index+1<length && !visited[cur_index-1] &&!visited[cur_index+1]){
                visited[cur_index]=true;
                max_val+=indexedArray[i][0];
            }
        }

        return max_val;
    }
}