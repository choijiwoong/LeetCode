class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] result=new int[spells.length];
        double success_d=success*1.0;
        Arrays.sort(potions);
        for(int i=0; i<spells.length; i++){
            double limit=success_d/spells[i];
            for(int j=0; j<potions.length; j++){
                if(potions[j]>=limit){
                    result[i]+=potions.length-j;
                    break;
                }
            }
        }

        return result;
    }
}