class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int length=nums1.length;
        int[] pointer=new int[k];//동적 할당 사용
        for(int i=0; i<k; i++)
            pointer[i]=i;//초기값 세팅(시작 index)
        
        int minimum_score=10000000;
        for(int ptr=k-1; 0<=ptr; ptr--){//끝 원소부터 역으로 시작
            for(;pointer[ptr]<length; pointer[ptr]++){
                int sum=0, min=1001;
                for(int i=0; i<k; i++){
                    sum+=nums1[pointer[i]];
                    if(min>nums1[pointer[i]]){
                        min=nums1[pointer[i]];
                    }
                }
                int score=sum*min; System.out.println(score);
                if(minimum_score>score){
                    minimum_score=score;
                }
            }
            if(ptr-1!=-1)
                pointer[ptr-1]++;
            pointer[ptr]=k-1;
        }

        return minimum_score;
    }
}