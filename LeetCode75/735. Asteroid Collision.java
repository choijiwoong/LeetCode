class Solution {
    List<Integer> list=new LinkedList();
    private void swap(int index1, int index2){//양->음
        assert(index1<index2);

        int num1=list.get(index1), num2=list.get(index2);
        assert(num1>0);
        int abs_num1=Math.abs(num1), abs_num2=Math.abs(num2);

        //양->음
        try {
            list.get(index2);
        } catch(IndexOutOfBoundsException e){
            System.out.println("IOB Exception catching");
        }

        if (abs_num1 < abs_num2) {
            list.remove(index1);
        } else if (abs_num1 > abs_num2) {
            list.remove(index2);
        } else {
            list.remove(index1);
            list.remove(index1);//index2이나, 위의 remove로 index2가 index1위치가 됨
        }
    }
    public int[] asteroidCollision(int[] asteroids) {
        int size= asteroids.length;

        for(int i=0; i<size; i++)
            list.add(asteroids[i]);

        for(int loop=0; loop<asteroids.length; loop++) {
            for (int i = 0; i < list.size() - 1; i++) {
                //양->음만 찾자
                int num1 = list.get(i), num2 = list.get(i + 1);
                if (num1 > 0 && num2 < 0)
                    swap(i, i + 1);
            }
        }

        int result_size=list.size();
        int[] result=new int[result_size];
        for(int i=0; i<result_size; i++)
            result[i]=list.get(i);

        return result;
    }
}