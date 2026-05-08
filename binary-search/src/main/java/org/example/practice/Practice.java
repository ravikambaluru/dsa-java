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
     * Leet Code #374
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

    /**
     * LEETCODE 33
     * There is an integer array nums sorted in ascending order (with distinct values).
     *
     * Prior to being passed to your function, nums is possibly left rotated at an unknown index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0,1,2].
     *
     * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
     *
     * You must write an algorithm with O(log n) runtime complexity.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [4,5,6,7,0,1,2], target = 0
     * Output: 4
     * Example 2:
     *
     * Input: nums = [4,5,6,7,0,1,2], target = 3
     * Output: -1
     * Example 3:
     *
     * Input: nums = [1], target = 0
     * Output: -1
     */
    public int search(int[] nums, int target) {

        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            // if target is mid ??
            if(nums[mid]==target) return mid;
            // is left sorted correctly ??
            if(nums[left]<=nums[mid]){
                if(target>=nums[left]&&target<nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
            // is right part of array sorted ??
            else{
                if(target>nums[mid]&&target<=nums[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }

        }
        return -1;
    }

    /**
     * LeetCode #278
     * https://leetcode.com/problems/first-bad-version/description/
     * Example 1:
     *
     * Input: n = 5, bad = 4
     * Output: 4
     * Explanation:
     * call isBadVersion(3) -> false
     * call isBadVersion(5) -> true
     * call isBadVersion(4) -> true
     * Then 4 is the first bad version.
     * Example 2:
     *
     * Input: n = 1, bad = 1
     * Output: 1
     *
     *
     * Constraints:
     *
     * 1 <= bad <= n <= 231 - 1
     *
     *
     *
     */
    public int firstBadVersion(int n) {
        int l=1;
        int r=n;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(isBadVersion(mid)){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return l;
    }

    private boolean isBadVersion(int i) {
        return true;
    }
}
