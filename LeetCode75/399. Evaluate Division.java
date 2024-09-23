class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //equations순회하며 동일한건 제거
        //그대로 db에 넣으면서 거꾸로 value도 넣음
        //queries에 db에 있으면 value를 리턴
        Map<List<String>, Double> db=new HashMap<>();
        //기본값 저장
        List<String> default_data=new ArrayList<>();
        default_data.add("1"); default_data.add("1");
        db.put(default_data, 1.0);

        for(int i=0; i<equations.size(); i++){
            //equation을 db에 저장
            List<String> simple_equation=equations.get(i);
            db.put(simple_equation, values[i]);//equation을 db에 저장
            List<String> reverse_equation=new ArrayList<>();
            reverse_equation.add(simple_equation.get(1));
            reverse_equation.add(simple_equation.get(0));
            db.put(reverse_equation, 1/values[i]);//역순 equation을 db에 저장
        }

        //연립을 위해 동일한 항을 가지는 항을 찾아 나머지 두개를 이용하여, 연립 항 정보를 찾아 db에 넣는다.
        Map<List<String>, Double> new_db=new HashMap<>();
        for(int i=0; i<5; i++) {
            for (Map.Entry<List<String>, Double> eq1 : db.entrySet()) {
                for (Map.Entry<List<String>, Double> eq2 : db.entrySet()) {
                    if (eq1.equals(eq2))//동일한 값이면 넘어감. 연립할게없음
                        continue;
                    List<String> new_equation = new ArrayList<>();
                    List<String> rev_new_equation = new ArrayList<>();
                    double new_value = -1.0, rev_new_value = -1.0;
                    //System.out.println(eq1.getKey().get(0)+", "+eq1.getKey().get(1)+", "+eq2.getKey().get(0)+", "+eq2.getKey().get(1));
                    if (eq1.getKey().get(0).equals(eq2.getKey().get(0))) {//case 1
                        new_equation.add(eq2.getKey().get(1));
                        new_equation.add(eq1.getKey().get(1));
                        if(new_equation.get(0).equals("c") && new_equation.get(1).equals("b"))
                            System.out.println();
                        new_value = eq1.getValue() / eq2.getValue();

                        rev_new_equation.add(eq1.getKey().get(1));
                        rev_new_equation.add(eq2.getKey().get(1));
                        rev_new_value = 1 / new_value;

                        if(!db.containsKey(new_equation) || !db.containsKey(rev_new_equation)) {
                            new_db.put(new_equation, new_value);
                            new_db.put(rev_new_equation, rev_new_value);
                        }
                    } else if (eq1.getKey().get(0).equals(eq2.getKey().get(1))) {//case2
                        new_equation.add(eq2.getKey().get(0));
                        new_equation.add(eq1.getKey().get(1));
                        new_value = eq1.getValue() * eq2.getValue();

                        rev_new_equation.add(eq1.getKey().get(1));
                        rev_new_equation.add(eq2.getKey().get(0));
                        rev_new_value = 1 / new_value;

                        if(!db.containsKey(new_equation) || !db.containsKey(rev_new_equation)) {
                            new_db.put(new_equation, new_value);
                            new_db.put(rev_new_equation, rev_new_value);
                        }
                    } else if (eq1.getKey().get(1).equals(eq2.getKey().get(0))) {//case3
                        new_equation.add(eq1.getKey().get(0));
                        new_equation.add(eq2.getKey().get(1));
                        new_value = eq1.getValue() * eq2.getValue();

                        rev_new_equation.add(eq2.getKey().get(1));
                        rev_new_equation.add(eq1.getKey().get(0));
                        rev_new_value = 1 / new_value;

                        if(!db.containsKey(new_equation) || !db.containsKey(rev_new_equation)) {
                            new_db.put(new_equation, new_value);
                            new_db.put(rev_new_equation, rev_new_value);
                        }
                    } else if (eq1.getKey().get(1).equals(eq2.getKey().get(1))) {//case4
                        new_equation.add(eq1.getKey().get(0));
                        new_equation.add(eq2.getKey().get(0));
                        new_value = eq1.getValue() / eq2.getValue();

                        rev_new_equation.add(eq2.getKey().get(0));
                        rev_new_equation.add(eq1.getKey().get(0));
                        rev_new_value = 1 / new_value;

                        if(!db.containsKey(new_equation) || !db.containsKey(rev_new_equation)) {
                            new_db.put(new_equation, new_value);
                            new_db.put(rev_new_equation, rev_new_value);
                        }
                    }
                }
            }
            db.putAll(new_db);//연립한 db를 기존 db에 붙임.
        }


        //System.out.println(db.size());
        //System.out.println(db.entrySet().size());
//        for(Map.Entry<List<String>, Double> data: db.entrySet())
//            System.out.println("key: "+data.getKey().get(0)+", "+data.getKey().get(1)+" / value: "+data.getValue());

        double[] result=new double[queries.size()];
        for(int i=0; i<queries.size(); i++){
            //System.out.println("ab res: "+abbreviation(queries.get(i)));
            //db에 query식이 그대로 들어가 있는지 확인
            if(db.containsKey(queries.get(i))) {//약분한 쿼리를 기반으로 db 서칭. 미지수는 위의 예외처리에서 걸러짐.
                result[i] = db.get(queries.get(i));
            } else {
                result[i] = -1;
            }
        }

        return result;
    }
}