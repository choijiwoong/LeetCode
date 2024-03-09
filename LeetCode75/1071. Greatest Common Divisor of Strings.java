class Solution {
    public String decodeString(String s) {
        int size=s.length();

        /*
        숫자 뒤 괄호열림은 *연산, ]뒤 숫자는 +연산, 문자뒤 숫자도 +연산, [없이 문자는 +연산
         */
        StringBuilder result=new StringBuilder();
        Stack<Integer> stack_i=new Stack<>();
        Stack<Character> stack_c=new Stack<>();
        StringBuilder integer_parser=new StringBuilder();
        for(char c: s.toCharArray()){
            if('a'<=c && c<='z'){
                stack_c.push(c);
            } else if(c=='['){
                stack_i.push(Integer.valueOf(integer_parser.toString()));
                integer_parser.delete(0, integer_parser.length());
                stack_c.push(c);
            } else if(c==']'){
                char tmp=stack_c.pop();
                String target="";
                while (tmp!='['){
                    target=tmp+target;
                    tmp=stack_c.pop();
                }
                int repeat=stack_i.pop();
                result.append(target.repeat(repeat));
            } else if('0'<=c && c<'9'){
                integer_parser.append(c);
            } else{

            }
        }
        return result.toString();
    }
}