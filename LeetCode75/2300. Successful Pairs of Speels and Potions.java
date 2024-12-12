class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] result=new int[spells.length];

        for(int i=0; i<spells.length; i++){
            double limit=success*1.0/spells[i];
            for(int j=0; j<potions.length; j++){
                if(potions[j]>=limit){
                    result[i]++;
                }
            }
        }

        return result;
    }
}