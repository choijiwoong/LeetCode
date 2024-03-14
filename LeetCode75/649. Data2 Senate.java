class Solution {
    public String predictPartyVictory(String senate) {
        /*
        Radiant와 Dire라는 두개의 파티가 존재한다. 파티의 변화를 위한 투표는 공정하게 진행될 것이다.
        매 라운드마다 각각의 senator는 두가지 중 하나만을 설명할 수 있다.
        1. Ban one senator's right: 한명의 senator는 다른 한명의 senator가 앞으로의 모든 라운드에 모든 권한을 잃게한다
        2. Announce the victory: 만약 senator가 같은 파티안의 투표가능한 senator들을 모두 찾아낸다면, 그는 승리를 알리고 게임의 변화를 결정할 수 있다.
        주어지는 단어는 각 senator들이 속해진 파티 이름(Radiant, Dire)이다. n명의 senator들이 있다.
        라운드는 첫번째 senator부터 마지막 senator까지 주어진 순서에 따라 시작된다. 투표가 끝날 때 까지 계속된다
        자신의 권한을 상실한 모든 senator는 해당 턴을 스킵한다.
        모든 senator들은 그의 파티 내에서 최고의 전략을 가지고 게임에 임할 것이고 충분히 똑똑하다.
        최종적으로 어떤 팀이 승리할 것인지를 예측하라. 리턴값은 Radiant 혹은 Dire뿐이다.
         */
        int size=senate.length();
        StringBuilder stringBuilder=new StringBuilder(senate);

        for(int i=0; i<size; i++){
            if(stringBuilder.charAt(i)=='R'){
                boolean success=false;
                for(int j=i+1; j<stringBuilder.length(); j++){
                    if(stringBuilder.charAt(j)=='D'){
                        stringBuilder.deleteCharAt(j);
                        success=true;
                        break;
                    }
                }
                if(!success){
                    for(int j=i-1; j>=0; j--){
                        if(stringBuilder.charAt(j)=='D'){
                            stringBuilder.deleteCharAt(j);
                            success=true;
                            break;
                        }
                    }
                    if(!success){
                        return "Radiant";
                    }
                }
            } else if(stringBuilder.charAt(i)=='D'){
                boolean success=false;
                for(int j=i+1; j<stringBuilder.length(); j++){
                    if(stringBuilder.charAt(j)=='R'){
                        stringBuilder.deleteCharAt(j);
                        success=true;
                        break;
                    }
                }
                if(!success){
                    for(int j=i-1; j>=0; j--){
                        if(stringBuilder.charAt(j)=='R'){
                            stringBuilder.deleteCharAt(j);
                            success=true;
                            break;
                        }
                    }
                    if(!success)
                        return "Dire";
                }
            }//endif
            if(stringBuilder.length()==1){
                if(stringBuilder.charAt(0)=='R')
                    return "Radiant";
                else
                    return "Dire";
            }
        }//endfor
        return "ERROR";
    }
}