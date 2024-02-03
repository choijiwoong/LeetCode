class Solution {
    public int maxOperations(int[] nums, int k) {
        int size=nums.length;
        int count=0;
        int pair_value;
        int j;
        //way4 blacklist말고 k+1로 만들어버리자. 양수니까
        for(int i=0; i<size-1; i++){
            if(nums[i]>k)//예외처리
                continue;
            pair_value=k-nums[i];
            for(j=i+1; j<size; j++) {
                if (nums[j] == pair_value){
                    count++;
                    nums[j]=k+1;
                    break;
                }
            }
        }
        return count;
    }
}