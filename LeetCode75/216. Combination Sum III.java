class Solution {
    /**
     * k개의 숫자로 합이 n이 되는 조합을 찾는 메인 함수
     *
     * @param k 원하는 숫자 개수
     * @param n 원하는 합
     * @return 가능한 조합의 리스트
     */
    public static List<List<Integer>> combinationSum3(int k, int n) {
        // 결과를 저장할 리스트
        List<List<Integer>> result = new ArrayList<>();
        
        // 백트래킹 탐색을 시작 (1부터 시작하는 숫자 조합을 찾음)
        findCombinations(k, n, 1, new ArrayList<>(), result);
        
        // 최종 결과 반환
        return result;
    }

    /**
     * 재귀적으로 조합을 찾는 헬퍼 함수 (백트래킹)
     *
     * @param k         남아있는 숫자의 개수
     * @param target    현재 남아있는 목표 합
     * @param start     탐색을 시작할 숫자 (1부터 시작, 중복 방지 위해 증가)
     * @param current   현재까지 구성된 조합
     * @param result    모든 가능한 조합을 저장할 리스트
     */
    private static void findCombinations(int k, int target, int start, List<Integer> current, List<List<Integer>> result) {
        // 종료 조건 1: 숫자가 k개이고 목표 합이 0이면 현재 조합을 결과에 추가
        if (k == 0 && target == 0) {
            result.add(new ArrayList<>(current)); // 현재 조합을 복사해서 결과에 저장
            return; // 더 이상 탐색하지 않고 종료
        }

        // 종료 조건 2: 숫자가 부족하거나 목표 합이 음수가 되면 탐색 종료(아래 start+1에서 10이 된다면 음수가 될 수 있음. 이를 거르기 위한 것)
        if (k == 0 || target < 0) {
            return;
        }

        // 현재 숫자부터 9까지의 숫자를 사용하여 조합 탐색
        for (int i = start; i <= 9; i++) {
            // 숫자 i를 현재 조합에 추가
            current.add(i);
            
            // 남은 숫자 개수를 줄이고, 목표 합을 줄여서 재귀 호출
            // i + 1을 넘기므로 숫자가 중복되지 않음
            findCombinations(k - 1, target - i, i + 1, current, result);
            
            // 백트래킹: 재귀 탐색 후 마지막에 추가한 숫자를 제거
            current.remove(current.size() - 1);
        }
    }
}  