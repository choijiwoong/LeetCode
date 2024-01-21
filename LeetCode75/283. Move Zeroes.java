class Solution {
   public void moveZeroes(int[] nums) {
        int head=0;
        for(int index=0; index<nums.length; index++){
            if(nums[index]!=0){//0이 아닌 수의 경우 저장
                nums[head++]=nums[index];
            }
        }
        for(int index=nums.length-1; index>=head; index--)
            nums[index]=0;
    }
}