package org.example.arrays;

import java.util.Arrays;

public class TwoPointers {
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeElement(arr, 2));
        System.out.println(Arrays.toString(arr));
        System.out.println(strStr("a","a"));
    }

    /**
     * Used Two pointers same direction approach here,
     * One pointer will go linearly and fastly to find uniques
     * Second pointer will go for placement
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int uniqueCount = 1;
        for(int fast=0, slow=0;fast<nums.length;fast++){
            if(nums[fast]!=nums[slow]){
                nums[slow]=nums[fast];
                slow++;
                uniqueCount++;
            }
        }
        return uniqueCount;
    }
    // example: Input: nums = [1,1,1,2,2,3]
    //Output: 5, nums = [1,1,2,2,3,_]
    public static int removeDuplicateVersion2(int[] nums){
        if(nums.length == 0) return 0;
        int positionTrackPointer=0;
        int uniqueElementPointer=0;
        int uniqueCounter=1;
        while(uniqueElementPointer<nums.length){
            if(nums[uniqueElementPointer] != nums[positionTrackPointer]){
                if(nums[positionTrackPointer]==nums[positionTrackPointer+2]){
                    positionTrackPointer=positionTrackPointer+2;
                    uniqueCounter+=2;
                }
                nums[positionTrackPointer]=nums[uniqueElementPointer];

            }
            uniqueElementPointer++;
        }
        return uniqueCounter;
    }

    public static int removeElement(int[] nums, int val) {
        int slow=0;
        for (int fast=0;fast<nums.length;fast++){
            // If fast pointer is valid element, keep it at slow and increment slow
            // else skip
            if(nums[fast]!=val){
                nums[slow]=nums[fast];
                slow++;
            }
        }
        return slow;
    }
    /**
     * Here invariance is that charachters in needle should be occuring in haystack exactly
     * so boundary between slow and fast should match exactly with needle
     * so we go on with sliding window way by taking window size as needle length
     * if substring window matches our invariant , we return slow position, else we move window
     * to look for window which makes invariant pass
     * **/
    public static int strStr(String haystack, String needle) {
        if(haystack.isEmpty())return -1;
        for (int slow=0,fast=needle.length();fast<=haystack.length();fast++,slow++){
            String substring = haystack.substring(slow, fast);
            if(substring.equals(needle)){
                return slow;
            }
        }
        return -1;
    }

}
