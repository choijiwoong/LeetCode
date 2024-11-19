import java.util.ArrayList;
import java.util.List;

public class CombinationExample {

    // 배열에서 n개의 요소를 추출하는 모든 경우의 수를 구하는 함수
    public static List<List<Integer>> getCombinations(int[] arr, int n) {
        List<List<Integer>> result = new ArrayList<>();//결과를 저장할 리스트를 생성
        backtrack(arr, n, 0, new ArrayList<>(), result);//재귀함수 인자로 전달
        return result;
    }

    // 백트래킹을 사용하여 조합을 구하는 함수
    private static void backtrack(int[] arr, int n, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == n) {//원하는 조합의 개수가 채워졌다면
            result.add(new ArrayList<>(current)); // n개가 선택되면 결과 리스트에 추가
            return;
        }

        for (int i = start; i < arr.length; i++) {//시작 지점으로부터 최대 길이까지(맨 처음 시작 원소 루프)
            current.add(arr[i]); // 현재 요소를 선택
            backtrack(arr, n, i + 1, current, result); // 다음 인덱스로 넘어가며 재귀 호출. 시작 원소로부터 나머지를 i+1로 접근..
            current.remove(current.size() - 1); // 선택을 취소하고, 다음 선택을 시도(재활용)
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int n = 2; // 추출할 원소의 개수

        // 조합을 구하고 출력
        List<List<Integer>> combinations = getCombinations(arr, n);//n개 만큼의 리스트가 들어있다.
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }
}
