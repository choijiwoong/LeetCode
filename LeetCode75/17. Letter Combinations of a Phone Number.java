class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, char[]> num_to_alpha=new HashMap<Character, char[]>();
        num_to_alpha.put('2', new char[]{'a', 'b', 'c'});
        num_to_alpha.put('3', new char[]{'d', 'e', 'f'});
        num_to_alpha.put('4', new char[]{'g', 'h', 'i'});
        num_to_alpha.put('5', new char[]{'j', 'k', 'l'});
        num_to_alpha.put('6', new char[]{'m', 'n', 'o'});
        num_to_alpha.put('7', new char[]{'p', 'q', 'r', 's'});
        num_to_alpha.put('8', new char[]{'t', 'u', 'v'});
        num_to_alpha.put('9', new char[]{'w', 'x', 'y', 'z'});

        List<String> result=new ArrayList<>();
        int total_of_cases=digits.length()==0?0:1;
        for(char digit: digits.toCharArray()){
            total_of_cases*=num_to_alpha.get(digit).length;
        }
        System.out.println("total_of_cases: "+total_of_cases);
        int length=digits.length();
        for(int i=0; i<total_of_cases; i++){
            result.add("");
        }

        for(int i=0; i<length; i++){
            char digit=digits.charAt(i);
            char[] cases=num_to_alpha.get(digit);
            for(int j=0; j<total_of_cases; j++){
                String prev_result=result.get(j);
                result.set(j, prev_result.concat(String.valueOf(cases[j%(cases.length)])));
            }
        }

        return result;
    }
}