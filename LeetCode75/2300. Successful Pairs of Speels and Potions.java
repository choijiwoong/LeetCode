import java.util.*;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] result = new int[spells.length];
        Arrays.sort(potions);

        for (int i = 0; i < spells.length; i++) {
            long limit = (long) Math.ceil((double) success / spells[i]);
            int start = 0, end = potions.length;
        
            // 이진 탐색으로 lower bound를 찾음
            while (start < end) {
                int mid = (start + end) / 2;
             if (potions[mid] >= limit) {
                    end = mid; // 조건을 만족하면 왼쪽 영역 탐색
                } else {
                    start = mid + 1; // 조건을 만족하지 않으면 오른쪽 영역 탐색
                }
            }
        
            // 조건을 만족하는 첫 번째 인덱스(start)부터 끝까지의 개수를 더함
            result[i] = potions.length - start;
        }

        return result;
    }
}