class Solution {
    private Set<Character> vowels=Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
    public String reverseVowels(String s) {
        StringBuilder stringBuilder=new StringBuilder(s);
        List<Integer> indexes_of_vowels=new ArrayList<>();
        for(int index=0; index<s.length(); index++){
            if(vowels.contains(s.charAt(index))){
                indexes_of_vowels.add(index);
            }
        }

        for(int index=0; index<indexes_of_vowels.size(); index++){
            stringBuilder.setCharAt(
                    indexes_of_vowels.get(index)
                    , s.charAt(indexes_of_vowels.get(indexes_of_vowels.size()-1-index)));
        }
        return stringBuilder.toString();
    }
}