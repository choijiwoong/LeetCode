import java.util.*;

class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        long maxScore = 0;

        // Step 1: nums2를 기준으로 nums1과 nums2 정렬
        int[][] sortedNums = new int[n][2];
        for (int i = 0; i < n; i++) {
            sortedNums[i][0] = nums2[i];//nums2의 원소를 [i][0]에 저장
            sortedNums[i][1] = nums1[i];//nums1의 원소를 [i][1]에 저장
        }
        Arrays.sort(sortedNums, Comparator.comparingInt(a -> -a[0]));//nums2를 기준으로 모두 내림차순 정렬

        // Step 2: 우선순위 큐를 사용해 nums1에서 최대합 유지
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();//이는 k개의 원소를 담는 공간인데, min값을 바로 추출할 수 있게끔 우선순위큐를 사용(TLE방지)
        long currentSum = 0;

        for (int i = 0; i < n; i++) {//모든 값을 차례로 순회(현재 nums2 기준 내림차순 정렬)
            int num1 = sortedNums[i][1];//nums2에 대응되는 인덱스 nums1값
            int num2 = sortedNums[i][0];//시작은 nums2 최댓값

            // nums1의 값을 추가하고 currentSum 업데이트(더 작은 새로운 값을 합과 최솟값에 반영. nums2는 정렬에 참고했을 뿐 실질적인 계산은 nums1을 사용)
            currentSum += num1;
            minHeap.add(num1);

            //(처음 k개가 차기 전에는 아래의 if문들이 실행되지 않음)
            // k개의 요소를 유지하기 위해 최소값 제거( 새로 추가된 값이 아닌 가장 작은 값을 빼어 nums1의 최대합 유지 )
            if (minHeap.size() > k) {
                currentSum -= minHeap.poll();
            }
            /*
            * 정리. nums2기준 정렬 n만큼 루프돌며 nums1과 nums2의 원소 하나씩 쌍으로 빼서 k개를 채운다.
            * 초과될 시 nums1에서 가장 작은 값을 가진 원소를 대응되는 nums2의 원소와 함께 쌍으로 제거한다.
            * 즉, 이미 nums2를 기준으로 접근하고 있기 때문에 순회를 돌면서는 nums1이 최대가 되게끔 접근시켜
            * 둘 다 고려한다.
            * 
            * 비슷한 문제가 나올 경우 이를 바로 떠올릴 수 있을지는 아직 미지수이지만,
            * 둘 사이가 꼭 같이 대응된 상태로 계산되어야 하는 경우에 아래와 같이 정렬시킬 수 있고
            * 값의 삭제와 추가를 동시에 하므로써 문제를 단순화 시킬 수 있다. 는 점을 기억하면 좋을 듯 하다.
            * */

            // 현재 선택된 요소가 k개인 경우 점수 계산
            if (minHeap.size() == k) {
                maxScore = Math.max(maxScore, currentSum * num2);
            }
        }

        return maxScore;
    }
}
