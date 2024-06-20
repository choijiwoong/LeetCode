class Solution {
    public int minReorder(int n, int[][] connections) {
        if(connections.length<=2)
            return 0;
        int result=0;
        ArrayList<ArrayList<Integer>> lists=new ArrayList<ArrayList<Integer>>();
        //무방향 리스트 구축
        for(int[] elem : connections){
            int v1=elem[0], v2=elem[1];
            int flag=0;
            for(List list : lists){
                if(list.contains(v1) && !list.contains(v2)){
                    list.add(v2);
                    flag=1;
                    result++;
                    break;
                }
                if(list.contains(v2) && !list.contains(v1)){
                    list.add(v1);
                    flag=1;
                    break;
                }
            }
            if(flag==0){//새로 만들어야한다면
                ArrayList new_list=new ArrayList<Integer>();
                new_list.add(v1); new_list.add(v2);
                lists.add(new_list);
            }
        }
        //0을 기준으로 방향확인
        if(n%2!=1 && connections.length%2!=0)
            result++;
        return result;
    }
}