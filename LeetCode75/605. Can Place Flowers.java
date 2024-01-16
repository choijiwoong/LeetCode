class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        //1로 분리되는 구간별로 계산.
        //10000001_2, 100001_1, 1001_0과 1000001_2, 10001_1, 101_0. 규칙성발견
        //11_0,     101_0,  1001_0,     10001_1,    100001_1
        //1000001_2, 10000001_2, 100000001_3, 1000000001_3

        List<Integer> indexes_of_1=new ArrayList<>();
        for(int i=0; i< flowerbed.length; i++){
            if(flowerbed[i]==1)
                indexes_of_1.add(i+2);
        }//앞뒤에 10, 01을 추가

        if(!indexes_of_1.contains(0))
            indexes_of_1.add(0);
        if(!indexes_of_1.contains(flowerbed.length+1))
            indexes_of_1.add(flowerbed.length+3);
        Collections.sort(indexes_of_1);

        int num_plantable_flower=0;
        for(int i=0; i<indexes_of_1.size()-1; i++){//인덱스 구간 별 계산
            int partition_start= indexes_of_1.get(i);
            int partition_end=indexes_of_1.get(i+1);
            int partition_size=partition_end-partition_start+1;
            if(partition_size<5) {//56_1 78_2 90_3   -4, 12 34 56
                num_plantable_flower += 0;
            } else {
                num_plantable_flower+=(partition_size-4+1)/2;//23 45 67
            }
        }

        return n<=num_plantable_flower?true:false;
    }
}