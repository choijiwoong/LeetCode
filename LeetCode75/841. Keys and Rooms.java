class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int size=rooms.size();

        int[] queue=new int[1000*3];//키값들을 담을 리스트_중복값을 고려하여 3배 낭낭하게 할당
        int queue_tail=0, queue_head=0;
        
        int[] is_visited=new int[size];//방문 여부를 담을 배열

        for (int key: rooms.get(0))//첫번째 방에 있는 키들을 추가한다.
            queue[queue_tail++]=key;
        is_visited[0]=1;

        while(queue_tail!=queue_head){//열쇄 큐가 비어있지 않다면
            int room=queue[queue_head++];//pop한 뒤에
            if(is_visited[room]==1)//방문한 곳이면 pass
                continue;

            for(int key: rooms.get(room))//해당 방의 모든 키들을 추가한다.
                queue[queue_tail++]=key;
            is_visited[room]=1;//방문처리를 하고
        }

        for(int i=0; i<size; i++)
            if(is_visited[i]==0)
                return false;
        return true;
    }
}