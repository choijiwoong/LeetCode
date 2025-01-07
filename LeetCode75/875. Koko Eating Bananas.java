class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int front=1, end=Arrays.stream(piles).max().getAsInt();

        while(front<end){ // 조건확인 1번만 수행
            int mid=(front+end)/2; // mid 값 갱신도 1번만 수행
            int hour=0;

            for(int pile: piles)
                hour+=(pile+mid-1)/mid;// 정수 올림 최적화

            if(hour>h){
                front=mid+1;
            } else{
                end=mid;
            }
        }

        return front;
    }
}
