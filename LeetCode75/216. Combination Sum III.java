class Solution {
    private int sum_of_digits(int num){
        int result=0;
        int i=num;
        while(i/10!=0){
            result+=i%10;
            i/=10;
        }
        result+=i%10;

        return result;
    }

    private List<Integer> intarr_to_IntegerList(int num){
        List<Integer> result=new ArrayList<>();
        while(num/10!=0){
            result.add(num%10);
            num/=10;
        }
        result.add(num%10);
        return result;
    }
    public List<List<Integer>> combinationSum3(int k, int n) {// 숫자 k의 합이 n이 되어야 한다.
        List<List<Integer>> result=new ArrayList<>();
        int start_num=0;
        for(int i=1; i<=k; i++){
            start_num*=10;
            start_num+=i;
        }
        int end_num=0;
        for(int i=10-k; i<=9; i++){
            end_num*=10;
            end_num+=i;
        }
        for(int num=start_num; num<=end_num; num++){
            int sum=sum_of_digits(num);
            if(sum==n){
                System.out.println(num);
                result.add(intarr_to_IntegerList(num));
            }
        }

        return result;
    }
}