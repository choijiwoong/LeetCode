class Solution {
    private List<String> abbreviation(List<String> equation){
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
        //재활용
        equation.set(0, eq1.toString());
        equation.set(1, eq2.toString());
        return equation;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //equations순회하며 동일한건 제거
        //그대로 db에 넣으면서 거꾸로 value도 넣음
        //queries에 db에 있으면 value를 리턴
        Map<List<String>, Double> db=new HashMap();

        for(int i=0; i<equations.size(); i++){
            List<String> simple_equation=abbreviation(equations.get(i));
            db.put(simple_equation, values[i]);//equation을 db에 저장

            List<String> reverse_equation=new ArrayList<>();
            reverse_equation.add(simple_equation.get(1));
            reverse_equation.add(simple_equation.get(0));
            db.put(reverse_equation, 1/values[i]);//역순 equation을 db에 저장

            List<String> preceding_duplicated_equation=new ArrayList<>();
            preceding_duplicated_equation.add(simple_equation.get(0));
            preceding_duplicated_equation.add(simple_equation.get(0));
            db.put(preceding_duplicated_equation, 1.0);
            List<String> consequent_duplicated_equation=new ArrayList<>();
            consequent_duplicated_equation.add(simple_equation.get(1));
            consequent_duplicated_equation.add(simple_equation.get(1));
            db.put(consequent_duplicated_equation, -1.0);
        }

        double[] result=new double[queries.size()];
        for(int i=0; i<queries.size(); i++){
            //db에 query식이 그대로 들어가 있는지 확인
            if(db.containsKey(queries.get(i)))
                result[i]=db.get(queries.get(i));
            else
                result[i]=-1;

        }
        return result;
    }
}