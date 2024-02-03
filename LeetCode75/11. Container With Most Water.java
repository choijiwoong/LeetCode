class Solution {
    public int maxArea(int[] height) {
        int size=height.length;

        //way2_최적화시도
        Set<Integer> uniq_dimension=new LinkedHashSet<>();
        int demension=0;
        for(int first_x=0, second_x=size-1; first_x<second_x;){
            demension=(second_x-first_x)*(Math.min(height[first_x], height[second_x]));
            uniq_dimension.add(demension);
            if(height[first_x]<height[second_x])
                first_x++;
            else
                second_x--;
        }
        return Collections.max(uniq_dimension);
    }
}