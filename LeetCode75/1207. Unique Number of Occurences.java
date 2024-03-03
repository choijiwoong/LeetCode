class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        //-1000<arr[i]<1000이니 범위를 0<arr[i]<2000으로 수정. 인덱스 연산시에만 다른값 사용
        int size=arr.length;
        final int RANGE_FIX=1000;

        int[] table=new int[1000+RANGE_FIX];
        for(int i=0; i<size; i++){
            table[arr[i]+RANGE_FIX]++;
        }

        int total_count=0;
        for(int i=0; i<1000+RANGE_FIX; i++){
            if(table[i]!=0)
                total_count++;
        }

        int distinct_count=0;
        Set set=Arrays.stream(table).boxed().collect(Collectors.toSet());
        distinct_count=set.size()-1;//0제외

        return distinct_count==total_count?true:false;
    }
}