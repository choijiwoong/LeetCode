class Solution {
    public int minEatingSpeed(int[] piles, int h) {
    int n = piles.length;
        long total = 0;
        for (int p : piles) total += p;
        // 이진 탐색을 보다 최적화 하기 위해 최소 탐색 시간과 최대 탐색 시간을 수학적으로 계산하여 범위를 선정
        int left = (int) ((total - 1) / h) + 1; // 모든 시간을 효율 적으로 탐색하였을 때의 최소 k (모든 바구니에 딱딱 k개씩 나누어 떨어지면)
        int right = (int) ((total - n) / (h - n + 1)) + 1; // 각 pile을 최대한 분산시켰을 때의 최대 k (모든 바구니에 k개씩 나눠도 나머지가 있다면)
        while (left < right) {
            int mid = left + (right - left) / 2; // 오버 플로우 방지를 위해. 같은 mid값 계산인 것은 똑같음.
            int time = 0;
            for (int p : piles) {
                time += (p - 1) / mid + 1;
            }
            if (time > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}