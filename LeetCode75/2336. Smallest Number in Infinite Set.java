class SmallestInfiniteSet {
    PriorityQueue<Integer> queue;

    public SmallestInfiniteSet() {
        queue=new PriorityQueue<Integer>();
    }

    public int popSmallest() {
        int min=1;
        if(!queue.contains(min)){//가용한 값이라면
            queue.add(min);
            return min;
        } else {//가용하지 않은 값이라면
            while(queue.contains(++min)){}//가용한 값이 나올때까지++
            queue.add(min);
            return min;
        }
    }

    public void addBack(int num) {
        if(queue.contains(num))
            queue.remove(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */