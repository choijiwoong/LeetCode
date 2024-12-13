class Solution {
    public int findPeakElement(int[] nums) {
        return IntStream.range(0, nums.length)
                .reduce((a,b)->nums[a]>nums[b]?a:b)
                .orElse(-1);
    }
}