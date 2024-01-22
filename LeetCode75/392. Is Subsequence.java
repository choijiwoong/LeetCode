class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.isEmpty())//for test_case 2?8?
            return true;
        char[] s_=s.toCharArray(), t_=t.toCharArray();

        int size_s=s.length();
        int size_t=t.length();
        int index_s=0;
        for(int index_t=0; index_t<size_t && index_s<size_s; index_t++){
            if(t_[index_t]==s_[index_s]){
                index_s++;
            }
        }
        if(index_s==size_s)
            return true;
        else
            return false;
    }
}