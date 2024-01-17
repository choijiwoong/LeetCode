class Solution {
    public String reverseWords(String s) {
        List<String> words=List.of(s.split(" "))
                .stream()
                .filter(word->!word.isEmpty())
                .toList();

        StringBuilder stringBuilder=new StringBuilder();

        ListIterator<String> itr=words.listIterator(words.size());
        while(itr.hasPrevious()){
            stringBuilder.append(itr.previous().trim()+" ");
        }

        return stringBuilder.toString().trim();
    }
}