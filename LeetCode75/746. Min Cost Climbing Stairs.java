class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int length=cost.length;
        if(length==1)
            return 0;
        else if(length==2){
            return cost[0]>cost[1]?cost[1]:cost[0];
        } else if(length==3){
            return cost[1]<cost[0]+cost[2]?cost[1]:cost[0]+cost[2];
        }

        int[] accumulated_cost=new int[length];
        accumulated_cost[length-1]=cost[length-1];
        accumulated_cost[length-2]=cost[length-2];
        for(int i=length-3; i>=0; i--){
            if(accumulated_cost[i+1]<accumulated_cost[i+2]){
                accumulated_cost[i]=accumulated_cost[i+1]+cost[i];
            } else {
                accumulated_cost[i]=accumulated_cost[i+2]+cost[i];
            }
        }

        return accumulated_cost[0]>accumulated_cost[1]?accumulated_cost[1]:accumulated_cost[0];
    }
}