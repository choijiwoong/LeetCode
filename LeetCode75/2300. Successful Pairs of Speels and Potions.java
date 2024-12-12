class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] result=new int[spells.length];

        for(int i=0; i<spells.length; i++){
            long score=0;
            for(int j=0; j<potions.length; j++){
                score=spells[i]*potions[j];
                if(score>=success){
                    result[i]++;
                }
            }
        }

        return result;
    }
}