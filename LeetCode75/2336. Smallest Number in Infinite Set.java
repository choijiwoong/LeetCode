class SmallestInfiniteSet {
    PriorityQueue<Integer> queue;
    int min_val=1;
    
    public SmallestInfiniteSet() {
        queue=new PriorityQueue<Integer>();
    }

    public int popSmallest() {
        int min=min_val;
        if(!queue.contains(min)){//가용한 값이라면
            queue.add(min);
            min_val=findNextMin(min);
            return min;
        } else {//가용하지 않은 값이라면
            return -1;
        }
    }

    private int findNextMin(int min){
        while(queue.contains(++min)){}
        return min;
    }

    public void addBack(int num) {
        if(queue.contains(num))
            queue.remove(num);
        if(min_val>num)
            min_val=num;
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */