class Solution {
private int[] nums1, nums2;
    public int backtrack(int[] nums1, int[] nums2, int[] arr, int n, int start, List<Integer> current){
        int max_score=0;
        if(current.size()==n){
            int score=calculate_score(nums1, nums2, current);
            if(max_score<score)
                max_score=score;
            return max_score;
        }

        for(int i=start; i<arr.length; i++){
            current.add(arr[i]);
            int score=backtrack(nums1, nums2, arr, n, i+1, current);
            if(max_score<score)
                max_score=score;
            current.remove(current.size()-1);
        }
        return max_score;
    }

    public int calculate_score(int[] nums1, int[] nums2, List<Integer> combination){
        int min=combination.stream().mapToInt(i->nums2[i]).min().orElse(Integer.MIN_VALUE);
        int sum=combination.stream().mapToInt(i->nums1[i]).sum();
        return sum*min;
    }

    public long maxScore(int[] nums1, int[] nums2, int k) {
        final int length=nums1.length;

        //1. Combination에 사용할 index 리스트 초기화
        int[] indexes=IntStream.range(0, length).toArray();
        //2. backtracking
        return backtrack(nums1, nums2, indexes, k, 0, new ArrayList<>());
    }
}