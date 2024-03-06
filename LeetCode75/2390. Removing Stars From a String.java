class Solution {
    public String removeStars(String s) {
        Stack<Character> stack=new Stack();
        for(char c : s.toCharArray()){
            if(c!='*'){
                stack.push(c);
            } else{
                stack.pop();
            }
        }

        return stack.stream().map(String::valueOf).collect(Collectors.joining());
    }
}