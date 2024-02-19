class Solution {
    public int largestAltitude(int[] gain) {
        int max=0;
        int current_gain_sum=0;
        for(int i=0; i<gain.length; i++){
            current_gain_sum+=gain[i];
            if(max<current_gain_sum)
                max=current_gain_sum;
        }
        return max;
    }
}