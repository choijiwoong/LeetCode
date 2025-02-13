class Solution {
    public int rob(int[] nums) {
        int length=nums.length;

        //간단한 케이스 처리
        if(length==1)// 숫자가 하나일 때 
            return nums[0];
        else if (length==2) {// 숫자가 두개일 때
            return Math.max(nums[0], nums[1]);
        }

        //이웃 원소만큼을 뺀 상대 값을 저장하는 배열. 또한 기존의 인덱스 위치까지 포함하여 2차원으로 저장한다.
        int[][] relative_nums=new int[length][2];
        //양 끝 값 Index Out of Range 오류 방지로 직접 입력
        relative_nums[0][0]=nums[0]-nums[1];
        relative_nums[length-1][0]=nums[length-1]-nums[length-2];
        relative_nums[0][1]=0;
        relative_nums[length-1][1]=length-1;
        //현재 값에서 이웃한 값을 뺀다.
        for(int i=1; i<length-1; i++){
            relative_nums[i][0]+=nums[i]-(nums[i-1]+nums[i+1]);
            relative_nums[i][1]=i;
        }
        //내림차순 정렬
        Arrays.sort(relative_nums, Comparator.comparingInt(n -> -n[0]));
        
        int max_money=0;
        boolean[] visited=new boolean[length];
        for(int i=0; i<length; i++){//모든 원소에 대하여 차례로(상대 값이 큰 순서대로 접근)
            int cur_idx=relative_nums[i][1];//현재 원소의 기존 인덱스
            if(is_available(visited, cur_idx)){//접근 가능한지 확인(방문처리된 위치로 부터 이웃해 있지 않은지 여부
                max_money+=nums[cur_idx];//최댓값에 가산
                visited[cur_idx]=true;//방문처리
            }
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