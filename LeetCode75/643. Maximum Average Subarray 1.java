import java.util.*;

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int size=nums.length;

        List averages=new ArrayList();

        //초기값 세팅
        double avg=0;
        for(int i=0; i<k; i++)
            avg+=nums[i];
        avg/=k;
        averages.add(avg);

        for(int i=k; i<size; i++){//i는 새로 반영할 인덱스
            avg=avg+(nums[i]-nums[i-k])*1.0/k;
            averages.add(avg);
        }
        return (double) Collections.max(averages);
    }
}