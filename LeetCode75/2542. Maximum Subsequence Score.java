class Solution {
        public List<List<Integer>> getCombinations(int[] arr, int n){
        List<List<Integer>> result=new ArrayList<>();
        backtrack(arr, n, 0, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(int[] arr, int n, int start, List<Integer> current, List<List<Integer>> result){
        if(current.size()==n){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i=start; i<arr.length; i++){
            current.add(arr[i]);
            backtrack(arr, n, i+1, current, result);
            current.remove(current.size()-1);
        }
    }
    public long maxScore(int[] nums1, int[] nums2, int k) {
        final int length=nums1.length;

        //1. Combination에 사용할 index 리스트 초기화
        int[] indexes=new int[length];
        for(int i=0; i<length; i++){
            indexes[i]=i;
        }

        List<List<Integer>> combinations=getCombinations(indexes, k);//k개의 인덱스 조합 리스트

        int score=0, max_score=0;
        int min=10000, sum=0;
        for(List<Integer> combination: combinations){
            min=10000; sum=0;
            for(int i: combination){
                sum+=nums1[i];
                if(min>nums2[i])
                    min=nums2[i];
            }
            score=sum*min;
            if(score>max_score)
                max_score=score;
        }

        return max_score;
    }
}