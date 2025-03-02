class Solution {
    public int numTilings(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        if(n==3) return 5;
        if(n==4) return 11;
        if(n==5) return 24;
        if(n==6) return 53;

        final int MODULO_VALUE=1000000007;

        List<Long> index_table=new ArrayList<>();
        index_table.add(1l); index_table.add(2l); index_table.add(5l);
        for(int i=3; i<n; i++) {
            long new_val=index_table.get(i - 1) * 2 + index_table.get(i - 3);
            index_table.add(new_val%MODULO_VALUE);
        }
        return Math.toIntExact(index_table.get(n - 1));
    }
}