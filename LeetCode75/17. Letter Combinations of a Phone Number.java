class Solution {
    public List<String> letterCombinations(String digits) {
        // 숫자에 매칭되는 알파벳으로 변환하기 위한 룩업 테이블
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
        switch(digits.length()){
            case 0:
                return result;

            case 1:
                for(char c: num_to_alpha.get(digits.charAt(0)))
                    result.add(String.valueOf(c));
                return result;

            case 2:
                for(char c: num_to_alpha.get(digits.charAt(0)))
                    for(char c2: num_to_alpha.get(digits.charAt(1)))
                        result.add(String.valueOf(c).concat(String.valueOf(c2)));
                break;
            case 3:
                for(char c: num_to_alpha.get(digits.charAt(0)))
                    for(char c2: num_to_alpha.get(digits.charAt(1)))
                        for(char c3: num_to_alpha.get(digits.charAt(2)))
                            result.add(String.valueOf(c).concat(String.valueOf(c2)).concat(String.valueOf(c3)));
                break;
            case 4:
                for(char c: num_to_alpha.get(digits.charAt(0)))
                    for(char c2: num_to_alpha.get(digits.charAt(1)))
                        for(char c3: num_to_alpha.get(digits.charAt(2)))
                            for(char c4: num_to_alpha.get(digits.charAt(3)))
                                result.add(String.valueOf(c).concat(String.valueOf(c2)).concat(String.valueOf(c3)).concat(String.valueOf(c4)));
                break;
            default:
                System.out.println("ERROR");
                break;
        }
        return result;
    }
}