class Solution {
    private StringBuilder result;
    private char deleted_mark='-';
    private int delete_near_opponent(int index){
        if(result.charAt(index)==deleted_mark){
            return 1;
        }

        char current_team=result.charAt(index);
        int size=result.length();
        for(int i=index+1; i<size; i++){
            if(result.charAt(i)!=deleted_mark && result.charAt(i)!=current_team){
                result.setCharAt(i, deleted_mark);
                return 0;
            }
        }

        for(int i=index-1; i>=0; i--){
            if(result.charAt(i)!=deleted_mark && result.charAt(i)!=current_team){
                result.setCharAt(i, deleted_mark);
                return 0;
            }
        }

        return -1;
    }
    public String predictPartyVictory(String senate) {
        int size=senate.length();
        result=new StringBuilder(senate);

        while(true){
            for(int i=0; i<size; i++){
                int val=delete_near_opponent(i);
                if(val==-1){
                    return result.charAt(i)=='R'?"Radiant":"Dire";
                }
            }
        }
    }
}