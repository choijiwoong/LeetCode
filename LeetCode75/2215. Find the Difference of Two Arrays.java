class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        //첫번째 결과는 num1-num2이고, 두번째 결과는 num2-num1
        List<Integer> list1=Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> list2=Arrays.stream(nums2).boxed().collect(Collectors.toList());
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        result.add(new ArrayList<Integer>());

        for(int index_1=0; index_1<list1.size(); index_1++){
            if(!list2.contains(nums1[index_1])){
                result.get(0).add(nums1[index_1]);
            }
        }
        for(int index_2=0; index_2<list2.size(); index_2++){
            if(!list1.contains(nums2[index_2])){
                result.get(1).add(nums2[index_2]);
            }
        }

        result.set(0, result.get(0).stream().distinct().collect(Collectors.toList()));
        result.set(1, result.get(1).stream().distinct().collect(Collectors.toList()));
        return result;
    }
}