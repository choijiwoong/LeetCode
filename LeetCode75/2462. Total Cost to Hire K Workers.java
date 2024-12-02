class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        final int MAX_COST=10000;
        int LENGTH;
        int min_cost, result_cost=0, partial_min_index=-1;
        LinkedList<Integer> data=new LinkedList<>(Arrays.stream(costs).boxed().toList());
        for(int i=0; i<k; i++){//추출해야하는 워커 별 루프
            //0~candidates, LENGTH-candidates~LENGTH-1 중에서 최솟값 선정
            //비용 반영 및 -1화. 만약 bidirectional linked list라면?
            LENGTH=data.size();
            min_cost=MAX_COST;
            for(int j=0; j<candidates; j++){
                System.out.printf("size: %d, idx1: %d, idx2: %d\n", data.size(), j, LENGTH-1-j);
                if(0<=j && j<LENGTH &&data.get(j)<min_cost){
                    min_cost=data.get(j);
                    partial_min_index=j;
                }
                if(0<=LENGTH-1-j && LENGTH-1-j<LENGTH && data.get(LENGTH-1-j)<min_cost){
                    min_cost=data.get(LENGTH-1-j);
                    partial_min_index=LENGTH-1-j;
                }
            }
            result_cost+=min_cost;
            data.remove(partial_min_index);
            System.out.println("added "+min_cost+" of "+partial_min_index);
        }

        return result_cost;
    }
}