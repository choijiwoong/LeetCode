import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private Map<String, String> db=new HashMap<>();

    private void parse_equation(List<String> equation, double value){
        if(equation.size()!=2)
            throw new NumberFormatException("equation의 원소가 2개가 아닙니다.");

        StringBuilder eq1=new StringBuilder(equation.get(0));
        StringBuilder eq2=new StringBuilder(equation.get(1));

        //문자약분처리
        for(int i=0; i<eq1.length(); i++){
            for(int j=0; j<eq2.length(); j++){
                //문자처리
                if(eq1.substring(i,i+1).equals(eq2.substring(j,j+1))){
                    eq1.deleteCharAt(i);
                    eq2.deleteCharAt(j);
                    i--; j--;//(현재 위치가 사라지로 shift되기에 다시 검사가 필요하기에 --)
                }
            }
        }

        db.put(eq1.toString(), value+eq2.toString());
        //eq1=value*eq2정보 존재
    }

    private double calc_query(List<String> query){
        if(query.size()!=2)
            throw new NumberFormatException("equation의 원소가 2개가 아닙니다.");

        StringBuilder query1=new StringBuilder(query.get(0));
        StringBuilder query2 =new StringBuilder(query.get(1));

        //문자약분처리
        for(int i=0; i<query1.length(); i++){
            for(int j = 0; j< query2.length(); j++){
                //문자처리
                if(query1.substring(i,i+1).equals(query2.substring(j,j+1))){
                    query1.deleteCharAt(i);
                    query2.deleteCharAt(j);
                    i--; j--;//(현재 위치가 사라지로 shift되기에 다시 검사가 필요하기에 --)
                }
            }
        }

        return 0.0;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result=new double[queries.size()];

        for(int i=0; i<equations.size(); i++){
            parse_equation(equations.get(i), values[i]);
        }

        for(int i=0; i<queries.size(); i++){
            calc_query(queries.get(i));
        }

        return result;
    }

    public static void main(String[] args){
        Solution solution=new Solution();

        //example1 준비
        List<List<String>> equations= new ArrayList<>();
        double[] values=new double[1];
        List<List<String>> queries=new ArrayList<>();

        solution.calcEquation(equations, values, queries);
    }
}