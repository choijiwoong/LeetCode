class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] queue=new int[1000];
        List<Integer> queue=new ArrayList<>();//키값들을 담을 리스트
        int size=rooms.size();
        int[] is_visited=new int[size];//방문 여부를 담을 배열
        for (int key: rooms.get(0))//첫번째 방에 있는 키들을 추가한다.
            queue.add(key);
        is_visited[0]=1;

        while(!queue.isEmpty()){//열쇄 큐가 비어있지 않다면
            int room=queue.get(0);//pop한 뒤에
            queue.remove(0);
            if(is_visited[room]==1)//방문한 곳이면 pass
                continue;

            for(int key: rooms.get(room))//해당 방의 모든 키들을 추가한다.
                queue.add(key);
            is_visited[room]=1;//방문처리를 하고
        }

        for(int i=0; i<size; i++)
            if(is_visited[i]==0)
                return false;
        return true;
    }
}