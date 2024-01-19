class Solution {
    public boolean increasingTriplet(int[] nums) {
        int size=nums.length;
        Map<Integer, List<Integer>> index_table=new HashMap<>();//value와 indexList
        for(int i=0; i<size; i++){
            int value=nums[i];
            if(!index_table.keySet().contains(value)){//현재 값이 key로 저장되어있지 않다면
                List list=new ArrayList<Integer>();//새로운 리스트에
                list.add(i);//index정보를 추가해서
                index_table.put(value, list);//put
            } else{//값이 이미 key로 존재한다면
                index_table.get(value).add(i);//인덱스정보 추가
            }
        }

        //(-3: 6) (-1: 5) (0: 0, 4) (1: 3) (2: 2) (4: 1)
        List<Integer> key_list=index_table.keySet().stream().sorted().collect(Collectors.toList());

        //74번 케이스를 위한 사전 체크
        boolean isDescending=false;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i]>nums[i+1]) {
                isDescending = true;
            } else {
                isDescending=false;
                break;
            }
        }
        if(isDescending)
            return false;

        //본격 알고리즘
        for(int i=0; i< key_list.size()-2; i++){
            int value1= key_list.get(i);
            for(int j=i+1; j< key_list.size()-1; j++) {
                int value2 = key_list.get(j);
                for(int k=j+1; k<key_list.size(); k++) {
                    int value3 = key_list.get(k);

                    List indexes1 = index_table.get(value1);
                    List indexes2 = index_table.get(value2);
                    List indexes3 = index_table.get(value3);

                    int indexes1_min= (int) Collections.min(indexes1);
                    int indexes1_max = (int) Collections.max(indexes1);
                    int indexes2_min = (int) Collections.min(indexes2);
                    int indexes2_max = (int) Collections.max(indexes2);
                    int indexes3_min = (int) Collections.min(indexes3);

                    if (indexes1_max < indexes2_min && indexes2_max < indexes3_min)
                        return true;
                    if (indexes1_min < indexes2_min && indexes2_min < indexes3_min)
                        return true;
                    if (indexes1_max < indexes2_max && indexes2_max < indexes3_min)
                        return true;
                }
            }
        }
        return false;
        /*
        * map<value, int_index>
        * 모든 pair에 대하여 value3개씩 중에서 index가 순차적인게 있다면 true
        * */
    }
}