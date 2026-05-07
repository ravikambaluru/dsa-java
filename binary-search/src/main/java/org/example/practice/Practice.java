package org.example.practice;

public class Practice {

    /***
     * Leet Code #69:Sqrt(x)
     * Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
     * You must not use any built-in exponent function or operator.
     * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
     * Example 1:
     * Input: x = 4
     * Output: 2
     * Explanation: The square root of 4 is 2, so we return 2.
     * Example 2:
     * Input: x = 8
     * Output: 2
     * Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
     * Constraints:
     * 0 <= x <= 231 - 1
     *
     * */
    public int mySqrt(int x) {
        if (x < 2) return x;

        int low = 1;
        int high = x;
        int result = 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long midSquare = (long) mid * mid;  // long to avoid overflow

            if (midSquare == x) {
                return mid;
            } else if (midSquare < x) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }


    /**
     * We are playing the Guess Game. The game is as follows:
     *
     * I pick a number from 1 to n. You have to guess which number I picked (the number I picked stays the same throughout the game).
     *
     * Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
     *
     * You call a pre-defined API int guess(int num), which returns three possible results:
     *
     * -1: Your guess is higher than the number I picked (i.e. num > pick).
     * 1: Your guess is lower than the number I picked (i.e. num < pick).
     * 0: your guess is equal to the number I picked (i.e. num == pick).
     * Return the number that I picked.
     * Example 1:
     *
     * Input: n = 10, pick = 6
     * Output: 6
     * Example 2:
     *
     * Input: n = 1, pick = 1
     * Output: 1
     * Example 3:
     *
     * Input: n = 2, pick = 1
     * Output: 1
     *
     *
     * Constraints:
     *
     * 1 <= n <= 231 - 1
     * 1 <= pick <= n
     */
    public int guessNumber(int n) {
        int low = 1;
        int high=n;
        int result = 1;
        while (low <= high) {
            int mid=low+(high-low)/2;
            if(guess(mid)==0){
                return mid;
            }else if(guess(mid)==1){
                result = mid;
                low=mid+1;
            }else {
                high=mid-1;
            }
        }
        return result;
    }
    public int guess(int num){
        return Integer.compare(5, num);
    }
}
