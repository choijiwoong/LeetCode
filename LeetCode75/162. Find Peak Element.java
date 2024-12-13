class Solution {
    public int findPeakElement(int[] nums) {
        int start=0, end=nums.length-1, mid=0;//1,2,1
        while(start<end){
            mid=(start+end)/2;
            if(nums[mid+1]>mid){
                start=mid+1;
            } else{
                end=mid-1;
            }
        }
        return mid;
    }
}