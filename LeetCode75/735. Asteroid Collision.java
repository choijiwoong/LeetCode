class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int size= asteroids.length;

        //1. 스택
        Stack<Integer> stack=new Stack<>();

        //2. 로직 시작
        for(int i=0; i<size; i++){
            int current_num=asteroids[i];
            if(current_num>0){
                stack.push(current_num);
            } else{//3. 음수 발견 시 충돌발생
                //반복문을 사용하기 이전, 종료조건 설정_양수의 절댓값이 더 큰 경우.
                //같은 경우 둘 다 사라지며, 음수의 절댓값이 더 큰 경우 스택에서 원소를 추가적으로 꺼낸다.
                int abs_current_num=current_num*-1;//4. 만난 음수의 절댓값
                for(int poped_num=stack.pop(); poped_num>abs_current_num; poped_num=stack.pop()){
                    if(poped_num==abs_current_num){
                        break;
                    } else if(poped_num<abs_current_num){

                    } else{
                        stack.push(poped_num);
                        break;
                    }
                }
            }
        }

        //5. 반환 타입으로 변환
        int stack_size=stack.size();
        int[] result=new int[stack_size];

        for(int i=0; i<stack_size; i++){
            result[stack_size-i-1]=stack.pop();
        }

        return result;
    }
}