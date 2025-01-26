class Solution {
    int min_cost=10000;
    private void backtracking(int[] cost, List<Integer> current_indexs){
        //System.out.println(current_indexs);
        int cur_index=current_indexs.get(current_indexs.size()-1);
        if(cur_index>=cost.length-1){
            if(cur_index!=cost.length-1)
                current_indexs.remove(current_indexs.size()-1);
            int cost_sum=0;
            for(int idx: current_indexs)
                cost_sum+=cost[idx];
            if(cost_sum<min_cost)
                min_cost=cost_sum;
            return;
        }
        List<Integer> new_indexes1=new ArrayList<>(current_indexs);
        new_indexes1.add(cur_index+1);
        List<Integer> new_indexes2=new ArrayList<>(current_indexs);
        new_indexes2.add(cur_index+2);
        backtracking(cost, new_indexes1);
        backtracking(cost, new_indexes2);
    }
    public int minCostClimbingStairs(int[] cost) {
        List<Integer> cur_idx1=new ArrayList<>();
        cur_idx1.add(0);
        List<Integer> cur_idx2=new ArrayList<>();
        cur_idx2.add(1);
        backtracking(cost, cur_idx1);
        backtracking(cost, cur_idx2);

        return min_cost;
    }
}