/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        if(n==1)
            return 1;
        long mid=n/2, start=0, end=n, guess_var=guess((int)mid);

        while(guess_var!=0){
            if(guess_var==1){
                start=mid+1;
            } else {//guess_val==-1
                end=mid-1;
            }
            mid=(start+end)/2;
            guess_var=guess((int)mid);
            //System.out.println(mid);
        }
        return (int)mid;
    }
}