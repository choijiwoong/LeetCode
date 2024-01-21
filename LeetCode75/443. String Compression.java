class Solution {
    public int compress(char[] chars) {
        List<Integer> index_for_split=indexes_per_char(chars);
        int prev_index=0, index_saved=0;
        for(int index_change : index_for_split){
            chars[index_saved++]=chars[prev_index];
            if(prev_index+1!=index_change){
                int count=index_change-prev_index;
                for(char ch: number_to_char_array(count))
                    chars[index_saved++]=ch;
            }
            prev_index=index_change;
        }
        return index_saved;
    }

    private char[] number_to_char_array(int number){
        return Integer.toString(number).toCharArray();
    }

    private List<Integer> indexes_per_char(char[] chars){
        List<Integer> indexes=new ArrayList<>();
        for(int i=0; i< chars.length-1; i++){
            if(chars[i]!=chars[i+1])
                indexes.add(i+1);
        }
        indexes.add(chars.length);
        return indexes;
    }
}