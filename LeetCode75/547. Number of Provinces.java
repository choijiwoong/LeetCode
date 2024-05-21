class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int result=0;
        int[] is_visited=new int[n];
        for(int i=0; i<n; i++){//비교원소1
            if(is_visited[i]==0){//방문을 안한 비교원소1을 찾았다면
                is_visited[i]=1;//방문처리를 하고
                result++;//그룹을 새로 추가한다
                Queue<Integer> queue=new LinkedList<>();
                queue.add(i);
                while(!queue.isEmpty()){
                    int city_num=queue.remove();
                    for(int j=0; j<n; j++) {//비교원소2
                        if (isConnected[city_num][j] == 1 && j!=i) {//비교원소 1과 2가 연결되어 있다면
                            if(!queue.contains(j) && is_visited[j]==0)
                                queue.add(j);
                            is_visited[j] = 1;//j의 방문처리도 수행한다.
                        }
                    }
                }
            }
        }

        return result;
    }
}