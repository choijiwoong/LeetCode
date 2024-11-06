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
        
        int[] sorted_nums2_indices=sort_with_index(nums2);

        int min=nums2[length-k], sum=0;
        for(int i=0; i<k; i++){
            sum+=nums1[sorted_nums2_indices[length-1-i]];
        }
        return min*sum;
    }
}