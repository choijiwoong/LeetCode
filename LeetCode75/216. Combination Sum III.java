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

        Collections.sort(result);//중복 확인을 위해 내부 순서 정렬하여 저장

        return result;
    }

    private boolean is_valid(int num){
        List<Integer> numarr=intarr_to_IntegerList(num);

        //0이 있는지 체크
        if(numarr.contains(0)){
            return false;
        }

        //중복되는 수가 있는지 체크
        int distinct_size=numarr.stream().distinct().collect(Collectors.toList()).size();
        int origin_size=numarr.size();
        if(distinct_size!=origin_size){
            return false;
        }

        return true;
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        //서로 다른 숫자 k개의 합이 n이 되도록 하는 조합의 문제를 해결하기 위해 아래와 같은 색다른 방법을 사용한다.
        //문제의 조건이 2<=k<=9, 1<=n<=60이기 때문에 숫자는 최대 9개까지만 조합가능하다.
        //int 자료형의 범위는 -2,147,483,648 ~ 2,147,483,647이기에 조합에 사용하는 모든 수를 일렬로 늘여놓아 하나의 정수로 표현한다면 int타입에 담긴다.
        //ex) k=3이고 n=5라면 가능한 경우인 {1,2,3}을 int case1=123으로 표현가능하다는 이야기다.
        //이때 모든 수를 순회하면서 합이 n이 되는 조건을 만족하는 수를 찾을 것이다.

        //결과를 반환할 변수
        List<List<Integer>> result=new ArrayList<>();

        //위와 같이 정수로 표현한다면 가장 작은 조합인 {1,2,...k}는 12...k로 표현가능하다.
        int start_num=0;
        for(int i=1; i<=k; i++){
            start_num*=10;
            start_num+=i;
        }
        //위와 같이 정수로 표현한다면 가장 큰 조합인 {.., (k-1), k}는 ...(k-1)k로 표현된다.
        int end_num=0;
        for(int i=10-k; i<=9; i++){
            end_num*=10;
            end_num+=i;
        }

        //가장 작은 조합부터 가장 큰 조합까지 순회를 때린다.
        for(int num=start_num; num<=end_num; num++){
            int sum=sum_of_digits(num);//각 자리수의 합을 계산한다.
            if(sum==n && is_valid(num)){//문제의 조건 n을 만족한다면, 이 알고리즘의 한계인 "0이 사용된다"와 "숫자의 중복이 가능하다"를 해결하기 위해 is_valid함수로 확인한다.
                System.out.println(num);//debug
                result.add(intarr_to_IntegerList(num));//모든 조건을 만족하는 int임이 확인되면 해당 숫자를 문제에서 요구하는 타입인 List<Integer>꼴로 변환한다.
            }
        }

        return result.stream().distinct().collect(Collectors.toList());//중복을 제거한다.
    }
}