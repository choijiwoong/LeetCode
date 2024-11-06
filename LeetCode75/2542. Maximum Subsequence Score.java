class Solution {
    private int[] sort_with_index(int[] nums){
        Integer[] indices=new Integer[nums.length];//정렬 시 변경될 인덱스 정보를 저장할 인덱스 lookup table
        for(int i=0; i<nums.length; i++)
            indices[i]=i;//초기값 설정

        Arrays.sort(indices, new Comparator<Integer>(){//Arrays.sort에서 특별한 조검을 지정하고 싶으면 Comparator객체를 생성해서 준다.
            @Override
            public int compare(Integer i1, Integer i2){//compare함수를 가지고 있으면 되고 반환타입읜 Comparator<>제네릭 타입을 따른다.
                return Integer.compare(nums[i1], nums[i2]);//num1-num2보다 직관적으로 Integer.compare을 사용.
            }
        });

        Arrays.sort(nums);//실제 배열 정렬

        return Arrays.stream(indices).mapToInt(Integer::intValue).toArray();//Integer[]타입을 int[]로 변경
    }
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int length=nums1.length;
        int max_score=0;

        int[] sorted_nums1_indices=sort_with_index(nums1);
        int[] sorted_nums2_indices=sort_with_index(nums2);
        for(int i=length-1; k<=i; i--){
            int sum=0, min=100000;//데이터가 양의 정수기에 0으로 초기화
            boolean is_align=true;//인덱스 순서 체크 플래그
            for(int j=0; j<k; j++){
                //가산
                sum+=nums1[i-j];
                //최소
                if(min>nums2[i-j]) {
                    min = nums2[i - j];
                }
                //인덱스 순서 체크
                if(sorted_nums1_indices[i-j] == sorted_nums2_indices[i-j]) {
                    is_align = false;
                    break;
                }
            }
            if(is_align && max_score < sum*min){
                max_score=sum*min;
            }
        }

        return max_score;
    }
}