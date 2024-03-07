class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int size= asteroids.length;

        //1. 스택
        Stack<Integer> stack=new Stack<>();

        //1-2. 예외처리, 이미 완료된 경우 testcase 153
        int count=0;
        for(int i=0; i<size-1; i++){
            int cur=asteroids[i];
            int next=asteroids[i+1];
            if(cur*next<0){
                count++;
            }
        }
        if(count==1&& asteroids[0]<0)
            return asteroids;

        //2. 로직 시작
        for(int i=0; i<size; i++) {
            //2-1. 해당하는 값 읽기
            int current_num = asteroids[i];

            //2-2. 스택이 비어있다면 별도의 확인 없이 푸시
            if (stack.isEmpty()) {
                stack.push(current_num);
                continue;
            }

            //2-3. 스택의 값 부호와 현재의 값 부호가 같다면 푸시
            if (current_num * stack.peek() > 0) {
                stack.push(current_num);
                continue;
            } else {//만약 부호가 다르다면
                int pop_num = stack.pop();
                int abs_current_num = Math.abs(current_num);
                int abs_pop_num = Math.abs(pop_num);
                //2-4. 기존의 값이 더 크다면 무시하고 다시 원래의 값 스택에 복구(푸시)
                if (abs_pop_num > abs_current_num) {
                    stack.push(pop_num);
                    continue;
                } else if (abs_pop_num < abs_current_num) {//2-5. 기존의 값이 더 작다면 이길 때 까지 pop
                    for (; Math.abs(pop_num) < abs_current_num && !stack.isEmpty(); pop_num = stack.pop()) {
                    }
                    //2-6. 결국 졌다면 current_num을 푸시
                    if (Math.abs(pop_num)<abs_current_num) {
                        stack.push(current_num);
                        continue;
                    } else {//2-7. 결국 이겼다면 다시 원래의 값 스택에 복구(푸시)
                        stack.push(pop_num);
                    }
                } else {//2-8. 두 수의 크기가 같다면 둘 다 삭제(pop값을 다시 넣지 않음)
                    continue;
                }
            }
        }

        //3. 반환 타입으로 변환
        int stack_size=stack.size();
        int[] result=new int[stack_size];

        for(int i=0; i<stack_size; i++){
            result[stack_size-i-1]=stack.pop();
        }


        return result;
    }
}