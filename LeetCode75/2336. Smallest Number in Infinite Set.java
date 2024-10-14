class SmallestInfiniteSet {
    boolean[] avail=new boolean[1001];
    int min_val=0;

    public SmallestInfiniteSet() {
        Arrays.fill(avail, true);
    }

    public int popSmallest() {
        int min=min_val;
        if(avail[min]){//가용한 값이라면
            avail[min]=false;
            min_val=findNextMin(min);
            return min+1;
        } else {//가용하지 않은 값이라면
            return -1;
        }
    }

    private int findNextMin(int min){
        int i;
        for(i=min+1; !avail[i]; i++){}
        return i;
    }

    public void addBack(int num) {
        avail[num-1]=true;
        if(min_val>num-1)
            min_val=num-1;
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */