package twoPointers;

public class LeetCode {
    public void reverseString(char[] s) {
        char temp=s[0];
        for (int i = 0,j=s.length-1; i < j; i++, j--) {
            temp=s[i];
            s[i]=s[j];
            s[j]=temp;
        }
    }
    public int[] sortedSquares(int[] nums) {
        int[] ans=new int[nums.length];
        int i=0,j= nums.length-1,pos= nums.length-1;
        while(i<=j){
            int iSquare = nums[i]*nums[i];
            int jSquare = nums[j]*nums[j];
            if(iSquare>jSquare){
                ans[pos]=iSquare;
                i++;
            }else {
                ans[pos]=jSquare;
                j--;
            }
            pos--;
        }
        return ans;
    }
    public int removeDuplicates(int[] nums) {
        int i=0, j=0;
        while(j<= nums.length-1){
            if(nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
            }
            j++;
        }
        return i+1;
    }
    public void moveZeroes(int[] nums) {
        int i=0,j=0;
        while(j< nums.length){
            if(nums[j]!=0){
                int temp=nums[j];
                nums[j]=nums[i];
                nums[i]=temp;
                i++;
            }
            j++;
        }
    }
    public boolean isPalindrome(String s) {
        s=s.toLowerCase().replaceAll("[^a-zA-Z0-9\t]","");
        for (int i = 0,j= s.length()-1; i <= j; i++, j--) {
            if(s.charAt(i)!=s.charAt(j))return false;
        }
        return true;
    }
}
