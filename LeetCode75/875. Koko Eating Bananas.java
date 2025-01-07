class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int hour;
        int length=piles.length;
        int max=Arrays.stream(piles).max().getAsInt();
        int start_k=1, end_k=max;
        int mid_k=(start_k+end_k)/2;

        while(true){
            hour=0;
            for(int i=0; i<length; i++){
                hour+=Math.ceil(piles[i]*1.0/mid_k);
            }

            if (hour==h) {
                break;
            } else if (hour<h){
                end_k=mid_k-1;
            } else{
                start_k=mid_k+1;
            }
            mid_k=(start_k+end_k)/2;
        }

        return mid_k;
    }
}