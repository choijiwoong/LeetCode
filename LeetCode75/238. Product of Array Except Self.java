class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result=new int[nums.length];
        int total_multiple=Arrays.stream(nums).reduce((a,b)->a*b).getAsInt();
        for(int i=0; i<nums.length; i++) {
            if(nums[i]!=0)
                result[i] = total_multiple / nums[i];
            else
                result[i] = Arrays.stream(nums,0,i).reduce((a,b)->a*b).orElse(1)
                        *Arrays.stream(nums,i+1,nums.length).reduce((a,b)->a*b).orElse(1);
        }
        return result;
    }
}