class Solution {
    public int calculate(int[] nums1, int[] nums2, int[] indexes){
        int sum=0, min=100000;
        for(int i=0; i<indexes.length; i++){
            sum+=nums1[indexes[i]];
            if(nums2[indexes[i]]<min){
                min=nums2[indexes[i]];
            }
        }
        int result_val=sum*min;

        return result_val;
    }
    public long maxScore(int[] nums1, int[] nums2, int k) {
        final int length=nums1.length;//1. 배열의 길이 저장

        int[] indexes=new int[k];//2. 인덱스들 초기값 세팅
        for(int i=0; i<k; i++){
            indexes[i]=i;
        }

        int max_val=0;
        for(int i=0; i<k; i++){//3. 인덱스 접근 시작
            int cur_idx=k-1;
            for(int j=indexes[cur_idx]; j<length; j++){//4. 마지막 인덱스부터 ~ 끝 접근
                indexes[cur_idx]=j;//5. 함수 전달을 위해 indexes 갱신
                int result_val=calculate(nums1, nums2, indexes);//6. indexes기반 값 계산
                if(result_val>max_val){//7. 최댓값 갱신
                    max_val=result_val;
                }
            }
            //8. 다음 탐색을 위한 indexes 갱신. 앞의 indexes[]원소 탐색을 위해 앞 index를 ++, 뒤의 인덱스를 한칸 앞으로 옮겨야 한다.
            if(cur_idx>0){//0번은 이전 원소가 없기 때문에
                for(int j=cur_idx-1; j<k; j++){//9. 현재 탐색한 인덱스 앞 인덱스를 현재 인덱스로 옮기고 나머지는 +1한 값으로 갱신
                    indexes[j]=j+1;//초기값에서 한칸씩 shift하여 갱신
                }
            } else{//0번 원소라면
                for(int j=cur_idx; j<k; j++){//자기부터 shift하여 갱신
                    indexes[j]=j+1;
                }
            }
        }

        return max_val;
    }
}