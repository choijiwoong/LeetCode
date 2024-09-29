class Solution {
    double ans = -1;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Node>> graph = new HashMap<>(); // 2. 특정 문자에 대해 Node리스트를 가지는 Map을 생성한다.
        int n = equations.size();
        for(int i=0; i<n; ++i){
            if(graph.get(equations.get(i).get(0)) == null){// 3. 모든 equation에 대해 첫 원소가 graph에 없다면 추가한다.
                graph.put(equations.get(i).get(0), new ArrayList<>());
            }
            graph.get(equations.get(i).get(0)).add(new Node(equations.get(i).get(1), values[i]));// 4. 첫 원소가 저장된 map의 원소로 두번째 원소와 첫원소/두원소의 값을 Node형태로 저장한다 (따로 계산 없이 문제에서 주어진 조건 그대로 저장_ {elem1, {elem2, val}} 느낌)
            
            if(graph.get(equations.get(i).get(1)) == null){ // 5. 두번째 원소가 graph에 없다면 추가한다.
                graph.put(equations.get(i).get(1), new ArrayList<>());
            }
            graph.get(equations.get(i).get(1)).add(new Node(equations.get(i).get(0), 1/values[i])); // 6. 이전과 순서가 바뀌었으므로 1/val 꼴로 추가해준다. (역순도 추가해준다고 생각하면 될 듯)
        }
        
        double[] res = new double[queries.size()];
        for(int i=0; i<queries.size(); ++i){ // 7. 구해야할 값인 쿼리값에 대해 DFS를 수행할건데, 기본 원리는 더이상 타고 갈 게 없을 때 까지 dfs를 돌려 연관된 관계들을 하나하나 비교하는 것이다.
            ans = -1; //8. 초기화(못찾았을 경우 -1 처리를 해야함)
            dfs(graph, queries.get(i).get(0), queries.get(i).get(1), 1, new HashSet<>());// 9. 탐색 대상인 그래프, 첫원소, 두원소, dfs에 사용할 set을 건네준다.
            res[i] = ans;
        }
        return res;
    }
    private void dfs(Map<String, List<Node>> graph, String s, String target, double value, Set<String> set){
        if(graph.get(s) == null || set.contains(s)){ // 10. 이미 방문한 노드이거나, 그래프에 없는 값일 경우 탐색 종료
            return;
        }
        set.add(s); // 11. 방문 처리
        if(s.equals(target)){ // 12. 첫 원소와 두 원소가 동일하다면, ans의 값은 value로 대입하고 탐색 종료. 왜냐면 저장할 때  a, {b, v}꼴로 저장했기에 굳이 연산할 필요 없이 쿼리에 있는 a, {b, }에 매칭되는 v를 반환하면 됨. 
            ans = value;
            return;
        }
        for(Node i:graph.get(s)){// 13. 첫 원소와 두 원소가 다르다면 첫 원소에 대응되는 모든 노드들에 대하여
            dfs(graph, i.var, target, value*i.val, set); // 14. dfs를 수행하는데, 이때의 값은 이전의 value와 노드의 value의 곱이다. **핵심**
        }
    }
    class Node {// 1. 문자열 별 값을 저장하는 Node 클래스를 생성한다.
        String var;
        double val;
        public Node(String var, double val){
            this.var = var;
            this.val = val;
        }
    }
}