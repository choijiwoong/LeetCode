class Solution {
    public int findKthLargest(int[] nums, int k) {
        return Arrays.stream(nums).sorted().toArray()[nums.length-k];
    }
}