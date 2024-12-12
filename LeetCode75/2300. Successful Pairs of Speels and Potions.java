import java.util.*;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] result=new int[spells.length];
        double success_d=success*1.0;
        Arrays.sort(potions);
        for(int i=0; i<spells.length; i++){
            int limit= (int) Math.ceil(success_d/spells[i]);
            int start=0, end=potions.length, mid=(start+end)/2;
            while(start<=end){
                if(potions[mid]==limit){
                    result[i]+=spells.length-mid;
                    break;
                } else if(potions[mid]>limit){
                    end=mid-1;
                } else{
                    start=mid+1;
                }
                mid=(start+end)/2;
            }
        }

        return result;
    }
}