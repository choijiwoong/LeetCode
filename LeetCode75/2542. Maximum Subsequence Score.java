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

        int[] indexes=new int[k];//2. 인덱스들 초기값 세팅. k개의 배열을 이용해 각각의 원소 인덱스를 저장한다.
        for(int i=0; i<k; i++){
            indexes[i]=i;
        }// 초기값은 0, 1, ... k-1로 순서를 유지한다. indexes는 이전의 원소보다 이후의 원소가 큰 값이어야 한다.

        int max_val=0;//indexes에 접근한 값들로 계산한 값의 최댓값을 저장할 원소. 초기값은 0으로 한다.
        for(int i=0; i<k; i++){//3. indexes에 해당하는 모든 인덱스를 i로 접근 시작
            int cur_idx=k-1;// 원소의 위치를 옮길 때 앞에서부터 뒤로 움직일 것이기에 맨 뒤에 위치하는 원소부터 계산한다.
            for(int j=indexes[cur_idx]; j<length; j++){//4. cur_idx부터 끝날 때 까지 값을 계산할 예정이다.
                indexes[cur_idx]=j;//5. 함수 전달을 위해 indexes 갱신
                int result_val=calculate(nums1, nums2, indexes);//6. 문제에서 요구하는 값 계산(nums1의 합 x nums2의 최소)
                //print_indexes(indexes, cur_idx, result_val);// debug
                if(result_val>max_val){//7. 최댓값 갱신
                    max_val=result_val;
                }
            }// 현재까지 indexes의 마지막 원소 ~ 끝을 계산했다. 그 다음은 indexes의 이전 원소를 +1하고 다시 마지막 원소를 ++하며 옮겨가야한다.

            //8. 다음 탐색을 위한 indexes 갱신. 앞의 indexes[]원소 탐색을 위해 앞 index를 ++, 뒤의 인덱스를 한칸 앞으로 옮겨야 한다.
            // 이전 원소를 기반으로 반복문의 횟수를 줄일 예정이기에 이전 원소가 존재하는 경우(index==0)와 그렇지 않은 경우를 나누어 처리한다.
            if(cur_idx>0){//0번은 이전 원소가 없기 때문에
                if(cur_idx-1-i==-1){
                    return max_val;
                }
                for(int j=cur_idx-1-i; j<k; j++){//9. 현재 탐색한 인덱스 앞 인덱스를 현재 인덱스로 옮기고 나머지는 +1한 값으로 갱신
                    indexes[j]=j+1;//초기값에서 한칸씩 shift하여 갱신. 이때 정상적으로 작동한다면, k<=length이기에 인덱스 오버플로우가 안되겠지만 혹시 모르니 예외처리를 해두자.
                }//ck. 위에 인덱스 잘 한건지 확인. 검토결과 맞는 듯.
                if(indexes[k-1]>=length){// 인덱스 접근 예외 발생
                    System.out.println("(cur_idx>0)_ERROR! Index out of range");
                }
            } else{// 0번 원소라면
                indexes[0]++;// 기존의 값에서 하나 ++
                for(int j=1; j<k; j++){//9. 현재 탐색한 인덱스 앞 인덱스를 현재 인덱스로 옮기고 나머지는 +1한 값으로 갱신
                    indexes[j]=indexes[j-1]+1;//이전에 +1된 indexes[0]값에서 한칸씩 shift하여 갱신. 이때 정상적으로 작동한다면, k<=length이기에 인덱스 오버플로우가 안되겠지만 혹시 모르니 예외처리를 해두자.
                }
                if(indexes[k-1]>=length){// 인덱스 접근 예외 발생
                    System.out.println("(cur_idx==0)_ERROR! Index out of range");
                }
            }
            //cur_idx 갱신이 필요한가?
        }
        return max_val;
    }
}