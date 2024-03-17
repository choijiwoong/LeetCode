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

    private boolean is_announce_the_victory(int index){
        for(int i=0; i<index-1; i++){
            if(result.charAt(i)==deleted_mark)
                continue;
            if(result.charAt(i)!=result.charAt(i+1)) {
                return false;
            }
        }

        for(int i=index+1; i<result.length()-2; i++){
            if(result.charAt(i)==deleted_mark)
                continue;
            if(result.charAt(i)!=result.charAt(i+1)){
                return false;
            }
        }

        if(index>=result.length() ||
                (result.charAt(index)==result.charAt(index+1))
                        && (result.charAt(index)!=deleted_mark)){
            return false;
        }

        return true;
    }
    public String predictPartyVictory(String senate) {
        int size=senate.length();
        result=new StringBuilder(senate);

        while(true){
            for(int i=0; i<size; i++){
                int val=delete_near_opponent(i);
                if(val==-1){
                    return result.charAt(i)=='R'?"Radiant":"Dire";
                } else if(val==1 || val==0) {
                    continue;
                } else if(is_announce_the_victory(i)) {
                    return result.charAt(0) == 'R' ? "Radiant" : "Dire";
                }else{
                    System.out.println("ERROR");
                }
            }
        }
    }
}