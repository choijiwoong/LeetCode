class Solution {
    private boolean is_num(char c){ return '0'<=c&&c<='9'?true:false; }
    private boolean is_alpha(char c){ return 'a'<=c&&c<='z'?true:false; }

    private int priority(char ch){
        switch (ch){
            case '(': case ')':
                return 0;
            case '+':
                return 1;
            case '*':
                return 2;
        }
        return -1;
    }

    public String decodeString(String s) {
        char[] origin=s.toCharArray();
        StringBuilder expression=new StringBuilder();
        StringBuilder integer_parser=new StringBuilder();

        for(int i=0; i<origin.length; i++){
            char c=origin[i];
            if(is_alpha(c)){
                expression.append(c);
                if(i+1<origin.length && is_alpha(origin[i+1]))
                    expression.append('+');
            } else if(is_num(c)){
                if(i-1>=0 && is_alpha(origin[i-1]))
                    expression.append('+');
                integer_parser.append(c);
                while(is_num(origin[++i])){
                    integer_parser.append(origin[i]);
                }
                i--;//for i++ after for loop
                expression.append(Integer.valueOf(integer_parser.toString()));
                integer_parser.delete(0, integer_parser.length());
                expression.append('*');
            } else if(c=='['){
                expression.append('(');
            } else if(c==']'){
                expression.append(')');
                if(i+1<origin.length && origin[i+1]!=']')
                    expression.append('+');
            }
        }
        //System.out.print("normal expression: "+expression.toString());

        StringBuilder post_expression=new StringBuilder();
        Stack<Character> stack=new Stack<>();
        //step 2
        char[] charr2=expression.toString().toCharArray();
        for(int i=0; i< charr2.length; i++){
            char c=charr2[i];
            switch(c){
                case '+': case'*':
                    while(!stack.isEmpty() && (priority(c)<=priority(stack.peek())))
                        post_expression.append(stack.pop());
                    stack.push(c);
                    break;
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    char top_op=stack.pop();
                    while(top_op!='('){
                        post_expression.append(top_op);
                        top_op=stack.pop();
                    }
                    break;
                default:
                    post_expression.append(c);
                    if(is_num(c) && i+1< charr2.length && !is_num(charr2[i+1])){
                        post_expression.append("/");//숫자 끝의 표시
                    }
                    break;
            }
        }

        while(!stack.isEmpty()){
            post_expression.append(stack.pop());
        }
        //System.out.print(",\tpost_expression: "+post_expression.toString());

        //step3
        Stack<String> stringStack=new Stack<>();
        String op1, op2;
        char[] charr=post_expression.toString().toCharArray();
        for(int i=0; i<charr.length; i++){
            String c_s=""+charr[i];

            if(!c_s.equals("+") && !c_s.equals("*")){
                stringStack.push(c_s);
            } else{
                op2= stringStack.pop();
                op1= stringStack.pop();
                //특수처리시작
                if(op1.equals("/")){
                    op1=stringStack.pop();//숫자
                    while(!stringStack.isEmpty()&&is_num(stringStack.peek().charAt(0))){
                        op1=stringStack.pop()+op1;
                    }
                }
                //특수처리종료
                if(c_s.equals("+")){
                    stringStack.push(""+op1+op2);
                } else if(c_s.equals("*")){
                    stringStack.push(op2.repeat(Integer.valueOf(op1)));
                }
            }
        }
        //System.out.println(",\tresult: "+stringStack.peek());
        return stringStack.pop();
    }
}