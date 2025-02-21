class Solution {
    public int rob(int[] nums) {
        int length=nums.length;

        //간단한 케이스 처리
        if(length==1)// 숫자가 하나일 때
            return nums[0];
        else if (length==2) {// 숫자가 두개일 때
            return Math.max(nums[0], nums[1]);
        }

        //sort by big num with origin index
        int[][] sorted_nums=new int[length][2];
        for(int i=0; i<length; i++){
            sorted_nums[i][0]=nums[i];
            sorted_nums[i][1]=i;
        }
        Arrays.sort(sorted_nums, Comparator.comparingInt(n->-n[0]));

        int max_money=0;
        boolean[] visited=new boolean[length];
        for(int start=0; start<=length/2; start++) {
            int money=0;
            for (int i = start; i < length; i++) {//모든 원소에 대하여 차례로(상대 값이 큰 순서대로 접근)
                int cur_idx = sorted_nums[i][1];//현재 원소의 기존 인덱스
                if (is_available(visited, cur_idx)) {//접근 가능한지 확인(방문처리된 위치로 부터 이웃해 있지 않은지 여부
                    money += nums[cur_idx];//최댓값에 가산
                    visited[cur_idx] = true;//방문처리
                    //System.out.print(nums[cur_idx]);
                }
            }
            if(money>max_money)
                max_money=money;
            for(int i=0; i<length; i++){
                visited[i]=false;
            }
            //System.out.println(money);
        }

        return max_money;
    }

    private boolean is_available(boolean[] visited, int index){
        if(visited[index]){//이미 접근한 곳을 확인하지 않는 로직으로 호출해야 한다.
            System.out.println("ERROR!");
            return false;
        }

        if(index==0){
            if(visited[index+1])
                return false;
            else
                return true;
        } else if(index==visited.length-1){
            if(visited[index-1])
                return false;
            else
                return true;
        }

        if(visited[index-1]||visited[index+1])
            return false;

        return true;
    }
}
