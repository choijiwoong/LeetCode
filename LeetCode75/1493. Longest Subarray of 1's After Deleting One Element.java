class Solution {
    public int longestSubarray(int[] nums) {
        /*
        이진 배열에서 하나의 원소를 지워야한다.
        1로만 이루어진 비어있지 않은 최대 길이의 서브배열 길이를 리턴해라. 만약 없다면 0을 리턴
         */
        int size=nums.length;
        int max_len=0;
        //0을 무시하거나, 1로만 이루어져있어 1을 무시하거나
        List list=Arrays.stream(nums).boxed().collect(Collectors.toList());
        if(list.contains(0) && list.contains(1)){
            for(int i=0; i<size; i++){//슬라이딩 시작 인덱스
                if(nums[i]==0)
                    continue;
                int length=0;
                int life=1;
                int j;
                for(j=i; j<size; j++){
                    if(nums[j]==0){
                        if(life!=0){
                            life--;
                        } else{
                            break;
                        }
                    }
                }
                j--;
                length=j-i+1;

                if(life==0)
                    length-=1;
                if(max_len<length)
                    max_len=length;
            }
        } else if(list.contains(0)){
            return 0;
        } else if(list.contains(1)){
            return size-1;
        } else{
            return 0;
        }
        return max_len;
    }
}