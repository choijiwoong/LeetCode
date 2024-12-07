class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        // 뛰어난 최적화 버전. 앞 범위와 뒷 범위의 heap을 구분한 뒤, 경계를 의미하는 start와 end를 두었다.
        // 각각의 범위를 별개로 구분하여 부족한(remove한) 범위에 원소를 정확히 추가하고, 겹치는 부분은 start와 end를 비교하여 추가하지 않는다.
        PriorityQueue<Integer> fheap = new PriorityQueue<>();
        PriorityQueue<Integer> sheap = new PriorityQueue<>();
        int start = 0;
        int end = costs.length - 1;
        long ans = 0;

        while (k-- > 0) {

            while (fheap.size() < candidates && start <= end) {

                fheap.offer(costs[start]);
                start++;
            }

            while (sheap.size() < candidates && start <= end) {
                sheap.offer(costs[end]);
                end--;
            }

            int t1 = fheap.size() > 0 ? fheap.peek() : Integer.MAX_VALUE;
            int t2 = sheap.size() > 0 ? sheap.peek() : Integer.MAX_VALUE;

            if (t1 <= t2) {
                ans += t1;
                fheap.poll();
            } else {
                ans += t2;
                sheap.poll();
            }
        }
        return ans;
    }
}