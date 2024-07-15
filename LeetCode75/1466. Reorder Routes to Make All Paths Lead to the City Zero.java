class Solution {
    public int minReorder(int n, int[][] connections) {//n은 노드의 개수, connections는 a->b방향관계
        int result=0, idx=-1, end=0, start=0;
        int index, target_index, target_val, i;

        int[] indexes=new int[connections.length*2];
        int[] list=new int[connections.length*2];
        for(int[] conn: connections){
            list[++idx]=conn[0];
            if(conn[0]==0)
                indexes[end++]=idx;

            list[++idx]=conn[1];
            if(conn[1]==0)
                indexes[end++]=idx;
        }

        //0부터 시작해서 DFS진행
        while(start<end){
            index=indexes[start++];
            if(index%2==0) {//짝수라면 시작지점
                result++;
                target_index=index+1;
            } else{//홀수라면 도착지점
                target_index=index-1;
            }
            target_val=list[target_index];
            list[target_index]=-1;//현재 index와 같이 처리한 쌍의 데이터 무시를 위함
            for(i=0; i<list.length; i++)
                if(list[i]==target_val)
                    indexes[end++]=i;
        }

        return result;
    }
}