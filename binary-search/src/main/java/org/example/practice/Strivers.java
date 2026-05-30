package org.example.practice;

public class Strivers {
    public int search(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        while(l<r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;
            else if(nums[mid]>target)r=mid;
            else l=mid+1;
        }
        return nums[l]==target?l:-1;
    }
    public int lowerBound(int[] nums, int x) {
        int l=0;
        int r=nums.length-1;
        while(l<r) {
            int mid = l + (r - l) / 2;
            if(nums[mid]>x)r=mid;
            else l=mid+1;
        }
        return nums[l]>=x?l:nums.length;
    }
}
