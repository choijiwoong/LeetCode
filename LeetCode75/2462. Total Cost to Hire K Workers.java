class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        final int MAX_COST=10000;
        int LENGTH=costs.length;
        int min_cost, result_cost=0;
        int min_index=-1, offset;

        for(int i=0; i<k; i++){
            min_cost=MAX_COST;
            offset=0;
            for(int j=0; j<candidates+offset && j<LENGTH; j++){
                if(costs[j]==-1){
                    offset++;
                    continue;
                }
                if(costs[j]<min_cost){
                    min_index=j;
                    min_cost=costs[j];
                }
            }

            if(candidates+offset<=LENGTH-candidates){//범위가 안겹치는가?
                offset=0;
                for(int j=LENGTH-1; j>=LENGTH-candidates+offset; j--){
                    if(costs[j]==-1){
                        offset--;
                        continue;
                    }
                    if(costs[j]<min_cost){
                        min_index=j;
                        min_cost=costs[j];
                    }
                }
            }
            min_cost=costs[min_index];
            result_cost+=min_cost;
            costs[min_index]=-1;
            //System.out.println("added "+min_cost+" of "+min_index+" costs: "+Arrays.toString(costs));
        }

        return result_cost;
    }
}