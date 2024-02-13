class Solution {
   public int maxVowels(String s, int k) {
       String vowels="aeiou";                      //모음 모음ㅋㅋ
       int size=s.length();                        //문자열 길이
       char[] s_c=s.toCharArray();                 //char[]형변환           

       List<Integer> idx_vowel=new ArrayList<>();  //모음의 인덱스를 저장
       for(int i=0; i<size; i++){
           if(vowels.contains(""+s_c[i])){
               idx_vowel.add(i);
           }
       }

       int num;
       int max=0;
       int idx_vowel_size=idx_vowel.size();

       if(idx_vowel_size==0)
           return 0;
       if(idx_vowel_size==1)
           return 1;

       for(int i=0; i<idx_vowel_size-1; i++){        //탐색의 시작 기준 i
           num=1;                                  //k범위 내의 모음 개수를 저장할 num. 이미 한개는 발견한 것
           int elem_i=idx_vowel.get(i);
           for(int j=1; j<k && i+j<idx_vowel_size; j++){
               int elem_j=idx_vowel.get(i+j);
               if(elem_j-elem_i<k){
                   num++;
               } else{
                   break;
               }
           }
           if(max<num)
               max=num;
           if(max==k)
               return max;
       }
       return max;
   }
}