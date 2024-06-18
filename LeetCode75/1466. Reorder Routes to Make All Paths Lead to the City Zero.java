class Solution {

    public int minReorder(int n, int[][] connections) {
        //노드의 수 구하기
        int max_node=0;
        for(int i=0; i<connections.length; i++){
            if(max_node<connections[i][0])
                max_node=connections[i][0];
            if(max_node<connections[i][1])
                max_node=connections[i][1];
        }

        int result=0;
        Queue<Integer> queue=new LinkedList<Integer>();
        int[] visited=new int[max_node+1];

        queue.add(0);
        while(!queue.isEmpty()){
            int node=queue.remove();
            if(visited[node]==1)
                continue;
            visited[node]=1;
            for(int[] conn : connections){
                if(conn[0]==node){
                    if(visited[conn[1]]==1)
                        continue;
                    result++;
                    queue.add(conn[1]);
                } else if(conn[1]==node){
                    if(visited[conn[0]]==1)
                        continue;
                    queue.add(conn[0]);
                }
            }
        }
        return result;
    }
}