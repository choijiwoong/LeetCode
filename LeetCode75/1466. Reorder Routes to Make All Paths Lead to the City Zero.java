class Solution {
    public int minReorder(int n, int[][] connections) {//n은 노드의 개수, connections는 a->b방향관계
        //connections를 List형태로 순서를 유지하며 저장한다.
        List<Integer> queue=new ArrayList<>();//연결관계 저장소
        for(int[] conn : connections){//모든 연결관계를 순회하면서 구조 재정립
            queue.add(conn[0]);
            queue.add(conn[1]);
        }

        //DFS를 위해 도시(0)이 위치하는 인덱스 정보를 큐에 넣어 준비를 한다.(초기값 세팅)
        int result=0;
        Queue<Integer> indexes=new LinkedList<>();//접근할 인덱스의 목록
        for(int i=0; i<queue.size(); i++)
            if(queue.get(i)==0)
                indexes.add(i);

        //0부터 시작해서 DFS진행
        while(!indexes.isEmpty()){
            int index=indexes.remove();
            if(index%2==0) {//짝수라면 시작지점
                result++;
                int target_index=index+1;
                int target_val=queue.get(target_index);
                queue.set(target_index, -1);//현재 index와 같이 처리한 쌍의 데이터 무시를 위함
                for(int i=0; i<queue.size(); i++){
                    if(queue.get(i)==target_val){
                        indexes.add(i);
                    }
                }
            } else{//홀수라면 도착지점
                int target_index=index-1;
                int target_val=queue.get(target_index);
                queue.set(target_index, -1);//현재 index와 같이 처리한 쌍의 데이터 무시를 위함
                for(int i=0; i<queue.size(); i++){
                    if(queue.get(i)==target_val){
                        indexes.add(i);
                    }
                }
            }
        }

        return result;
    }
}