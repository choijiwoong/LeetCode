class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        final int MAX_COST=10000;
        final int LENGTH= costs.length;
        int idx=0, min_cost=MAX_COST, result_cost=0, worker_index=-1;
        for(int i=0; i<k; i++){// 추출해야하는 워커
            min_cost=MAX_COST;
            for(idx=0; idx<LENGTH; idx++){// 탐색
                int cost=costs[idx];
                if(cost==-1){
                    continue;
                }
                if(min_cost>cost){// 이미 고른 작업자는 -1로 치환할 것임
                    min_cost=cost;
                    worker_index=idx;
                }

                if(LENGTH-candidates*2+1>0 && idx>=candidates){// 다음 간격으로 인덱스 이동
                    idx+=LENGTH-candidates*2;
                }
            }// 현재 세션에서의 작업자 선정 완료
            result_cost+=min_cost;
            costs[worker_index]=-1;
            //System.out.println("result_cost: "+result_cost+", idx= "+worker_index);
        }

        return result_cost;
    }
}