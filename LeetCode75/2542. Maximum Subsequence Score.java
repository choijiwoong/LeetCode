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
        int[] tmp=new int[length];
        for(int i=0; i<length; i++)
            tmp[i]=nums1[i];

        int[] sorted_nums1_indices=sort_with_index(nums1);
        int min1=100000, sum1, max_val1=0;
        for(int slidig_index=length-1; slidig_index>=k-1; slidig_index--) {
            sum1=0;
            for (int i = 0; i < k; i++) {
                sum1 += nums1[length - 1 - i];
                if (min1 > nums2[sorted_nums1_indices[slidig_index - i]]) {
                    min1 = nums2[sorted_nums1_indices[slidig_index - i]];
                }
            }
            if(max_val1<min1*sum1){
                max_val1=min1*sum1;
            }
        }

        int[] sorted_nums2_indices=sort_with_index(nums2);
        int min2, sum2=0, max_val2=0;
        for(int slidig_index=length-1; slidig_index>=k-1; slidig_index--) {
            min2 = nums2[slidig_index];
            for (int i = 0; i < k; i++) {
                sum2 += tmp[sorted_nums2_indices[slidig_index - i]];
                if(nums2[slidig_index-i]<min2) {
                    min2 = nums2[slidig_index - i];
                }
            }
            if(max_val2<min2*sum2){
                max_val2=min2*sum2;
            }
            sum2=0;
        }
        System.out.printf("(max_val1: %4d, max_val2: %4d) / ", max_val1, max_val2);
        return max_val1>max_val2?max_val1:max_val2;
    }
}