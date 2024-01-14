public class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result=new ArrayList<>(candies.length);
        for(int i=0; i<candies.length; i++){
            if(this.isGreatestNumber(candies, candies[i]+extraCandies)){
                result.add(true);
            } else{
                result.add(false);
            }
        }
        return result;
    }

    private Boolean isGreatestNumber(int[] candies, int number){
        for(int i=0; i<candies.length; i++)
            if(candies[i]>number)
                return false;
        return true;
    }
}