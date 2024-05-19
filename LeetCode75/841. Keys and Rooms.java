/*
n개 방 중에 0번 방을 제외하고 1부터 n-1까지 방이 잠겨있고 모든 방을 방문해야만 한다. 하지만 키 없이는 잠긴 방을 방문할 수 없다.

방 하나를 방문하면, 고유키를 발견할 수도 있다. 각각의 키는 해당되는 숫자를 가지고 있다. 너는 모든 키를 챙겨야만 다른 방들을 열 수 있다.

배열로 받은 rooms[i]가 방을 의미하며, i번째 방을 방문하면 얻을 열쇄가 존재한다.
만약 모든 방을 방문할 수 있다면 true를, 없다면 false를 반환해라.
 */
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        List<Integer> key_list=new ArrayList<>();
        List<Integer> is_visited=new ArrayList<>();

        is_visited.add(0);
        for (int i=0; i<rooms.get(0).size(); i++){
            key_list.add(rooms.get(0).get(i));
        }
        key_list=key_list.stream().distinct().toList();

        //main_logic start
        int size=key_list.size();
        for(int i=0; i<size; i++){
            int room_num=key_list.get(i);
            is_visited.add(room_num);
            for(int j=0; j<rooms.get(room_num).size(); j++){
                int prev_key_size=key_list.size();
                key_list.add(2);
                key_list.add(rooms.get(room_num).get(j));
                key_list=key_list.stream().distinct().toList();
                int added_key_size=key_list.size();
                if(prev_key_size!=added_key_size){//실제로 추가
                    size++;//전체 iteration을 한번 더(i)
                } else{//같은 룸 추가

                }
            }
        }
        //main_logic end

        if(key_list.size()!=rooms.size())
            return false;
        else
            return true;
    }
}