class Solution {
    public int pivotIndex(int[] nums) {
        int pivot_index;
        int left_i, right_i;
        int left_sum, right_sum;
        for(pivot_index=0; pivot_index<nums.length; pivot_index++){
            left_sum=0;
            right_sum=0;
            for(left_i=0; left_i<pivot_index; left_i++){
                left_sum+=nums[left_i];
            }
            for(right_i=pivot_index+1; right_i<nums.length; right_i++){
                right_sum+=nums[right_i];
            }
            if(right_sum==left_sum){
                return pivot_index;
            }
        }
        return -1;
    }
}
