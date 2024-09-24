class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //equation과 대응되는 value를 저장할 index_table
        Map<List<String>, Double> db=new HashMap<>();
        Set<String> used_string=new HashSet<>();

        for(int i=0; i<equations.size(); i++){
            //기존의 equation을 db에 저장
            List<String> simple_equation=equations.get(i);
            db.put(simple_equation, values[i]);//equation을 db에 저장
            used_string.addAll(simple_equation);
        }

        //연립을 위해 동일한 항을 가지는 항을 찾아 나머지 두개를 이용하여, 연립 항 정보를 찾아 db에 넣는다.
        Map<List<String>, Double> new_db=new HashMap<>();
        for(int i=0; i<5; i++) {
            for (Map.Entry<List<String>, Double> eq1 : db.entrySet()) {
                for (Map.Entry<List<String>, Double> eq2 : db.entrySet()) {
                    if (eq1.equals(eq2))//동일한 값이면 넘어감. 연립할게없음
                        continue;

                    List<String> new_equation = new ArrayList<>();
                    double new_value = -1.0;
                    if (eq1.getKey().get(0).equals(eq2.getKey().get(0))) {//case 1
                        new_equation.add(eq2.getKey().get(1));
                        new_equation.add(eq1.getKey().get(1));
                        new_value = eq1.getValue() / eq2.getValue();
                    } else if (eq1.getKey().get(0).equals(eq2.getKey().get(1))) {//case2
                        new_equation.add(eq2.getKey().get(0));
                        new_equation.add(eq1.getKey().get(1));
                        new_value = eq1.getValue() * eq2.getValue();
                    } else if (eq1.getKey().get(1).equals(eq2.getKey().get(0))) {//case3
                        new_equation.add(eq1.getKey().get(0));
                        new_equation.add(eq2.getKey().get(1));
                        new_value = eq1.getValue() * eq2.getValue();
                    } else if (eq1.getKey().get(1).equals(eq2.getKey().get(1))) {//case4
                        new_equation.add(eq1.getKey().get(0));
                        new_equation.add(eq2.getKey().get(0));
                        new_value = eq1.getValue() / eq2.getValue();
                    }
                    if(!db.containsKey(new_equation) && !new_equation.isEmpty()){//위에서 새로운 equation이 만들어졌고, 존재하지 않는 값이라면 추가(이때, 역순의 값이 들어갈 순 있다)
                        new_db.put(new_equation, new_value);
                    }
                }
            }
            db.putAll(new_db);//연립한 db를 기존 db에 붙임.
        }


//        System.out.println(db.size());
//        System.out.println(db.entrySet().size());
//        for(Map.Entry<List<String>, Double> data: db.entrySet())
//            System.out.println("key: "+data.getKey().get(0)+", "+data.getKey().get(1)+" / value: "+data.getValue());

        double[] result=new double[queries.size()];
        for(int i=0; i<queries.size(); i++){
            List<String> rev_query=new ArrayList<>();
            rev_query.add(queries.get(i).get(1));
            rev_query.add(queries.get(i).get(0));
            //db에 query식이 그대로 들어가 있는지 확인
            if(db.containsKey(queries.get(i))) {//약분한 쿼리를 기반으로 db 서칭. 미지수는 위의 예외처리에서 걸러짐.
                result[i] = db.get(queries.get(i));
            } else if(db.containsKey(rev_query)){//역순 확인
                result[i]=1/db.get(rev_query);
            } else if(rev_query.get(0).equals(rev_query.get(1)) && used_string.contains(rev_query.get(0))){
                result[i] = 1;
            } else{
                result[i] = -1;
            }
            System.out.print(result[i]);
        }

        return result;
    }
}