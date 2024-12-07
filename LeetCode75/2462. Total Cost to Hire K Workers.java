class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int LENGTH = costs.length;
        long cost = 0;

        // MinHeap 초기화
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                (a, b) -> costs[a] != costs[b] ? Integer.compare(costs[a], costs[b]) : Integer.compare(a, b)
        ); // 비용이 같은 경우 인덱스를 비교하여 앞 쪽 인덱스를 우선으로 둔다.

        // 두 포인터를 사용해 후보 영역 관리
        int left = 0, right = LENGTH - 1;

        // 초기 후보 범위를 MinHeap에 추가
        for (int i = 0; i < candidates; i++) {
            if (left <= right) minHeap.add(left++);
            if (left <= right) minHeap.add(right--);
        }

        // k명을 추출하며 비용 계산
        for (int i = 0; i < k; i++) {
            int removedIndex = minHeap.poll();
            cost += costs[removedIndex];

            // 후보 영역에 남은 값 추가
            if (removedIndex <= left && left <= right) { // 와.. 그냥 left right로 양쪽 candidates 범위 경계를 지정하면 되는구나..
                minHeap.add(left++);
            } else if (removedIndex >= right && right >= left) {
                minHeap.add(right--);
            }
        }

        return cost;
    }
}