class Solution {
    public int tribonacci(int n) {
        int num1=0, num2=1, num3=1, tmp;
        if(n==0)
            return num1;
        else if(n==1)
            return num2;
        else if(n==2)
            return num3;

        for(int i=0; i<n; i++){
            tmp=num1+num2+num3;
            num1=num2;
            num2=num3;
            num3=tmp;
        }
        return num1;
    }
}