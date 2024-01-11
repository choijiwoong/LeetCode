class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder stringBuilder=new StringBuilder();
        int i=0, j=0;
        while(i<word1.length() && j<word2.length()){
            stringBuilder.append(word1.charAt(i));
            stringBuilder.append(word2.charAt(j));
            i++;
            j++;
        }
        stringBuilder.append((word1.length()==i)?word2.substring(j):word1.substring(i));
        return stringBuilder.toString();
    }
}