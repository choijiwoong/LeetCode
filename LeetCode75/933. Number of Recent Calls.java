class RecentCounter {

    private int current_time;
    private final int range=3000;
    private List<Integer> requests;
    public RecentCounter() {
        current_time=0;
        requests=new ArrayList<>();
    }

    private int find_request_count(int t){
        int count=0;
        for(int i=0; i<requests.size(); i++){
            if(t-range<=requests.get(i) && requests.get(i)<=current_time){
                count++;
            }
        }
        return count;
    }

    public int ping(int t) {
        current_time=t;
        requests.add(current_time);
        return find_request_count(t);
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */