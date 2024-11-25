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
        int max_score=0;

        //1. nums2 정렬 및 nums2 기준 nums1 정렬. nums2에서 최솟값을 기준으로 연산하기 위함
        int[][] sorted_nums2=IntStream.range(0, length)
                .mapToObj(i->new int[]{nums2[i], i})
                .sorted(Comparator.comparingInt(a->a[0]))
                .toArray(int[][]::new);//[i][0]에 정렬된 값을, [i][1]에 그 값의 원래 인덱스를 저장
        int[] sorted_nums1=new int[length];
        for(int i=0; i<length; i++)
            sorted_nums1[i]=nums1[sorted_nums2[i][1]];//nums1[i][1] 기준으로 nums2 정렬

        //2. 최솟값 후보 선정
        for(int i=0; i<=length-k; i++){
            //i+1~length-1까지가 후보군(조합)
            int[] indexes=IntStream.range(i,length).toArray();//combination을 계산한 nums2기준 index 리스트
            int score=backtrack(nums1, nums2, indexes, k, 0, new ArrayList<>());//backtracking
            if(score>max_score)//update max
                max_score=score;
        }

        return max_score;
    }
}