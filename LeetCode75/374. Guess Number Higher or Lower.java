/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int binary_search(int mid, int start, int end){;
        switch(guess(mid)){
            case -1:
                return binary_search((start+mid-1)/2, start, mid-1);

            case 0:
                break;

            case 1:
                return binary_search((mid+1+end)/2, mid+1, end);

        }
        return mid;
    }
    public int guessNumber(int n) {
        return binary_search(n/2, 0, n);
    }
}