class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(str2.length()>str1.length()){//str1이 str2보다 길게 유지
            String temp=str1;
            str1=str2;
            str2=temp;
        }

        for(int index=str2.length(); index>0; index--){
            String word=str2.substring(0,index);
            if(str2.split(word).length==0 && str1.split(word).length==0){
                return word;
            }
        }
        return "";
    }
}