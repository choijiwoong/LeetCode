class Solution {
    private int[][] relations;
    private int size;
    private int[] visited;
    private int change_count=0;

    private void traversal(int node){
        //탈출조건
        if(visited[node]==1)
            return;

        //현재노드 방문처리
        visited[node]=1;
        for(int i=0; i<size; i++){
            if(relations[node][i]==1){//node->i로 접근이 가능한 경우
                //방향전환
                change_count++;
                traversal(i);
            }
            
            if(relations[i][node]==1){//i->node로 접근이 가능한 경우
                relations[i][node]=0;
                relations[node][i]=1;
                traversal(i);
            }
        }
    }

    public int minReorder(int n, int[][] connections) {
        //노드의 수 구하기
        int max_node=0;
        for(int i=0; i<connections.length; i++){
            if(max_node<connections[i][0])
                max_node=connections[i][0];
            if(max_node<connections[i][1])
                max_node=connections[i][1];
        }
        this.size=max_node+1;
        
        //필요한 배열 초기화
        this.relations=new int[size][size];
        this.visited=new int[size];

        //관계
        for (int[] elem : connections)
            relations[elem[0]][elem[1]]=1;
        
        traversal(0);
        return change_count;
    }
}