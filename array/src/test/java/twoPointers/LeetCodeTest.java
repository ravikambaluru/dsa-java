package twoPointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCodeTest {
    private LeetCode leetCode;
    public LeetCodeTest(){
        this.leetCode=new LeetCode();
    }
    @Test
    void reverseString() {
        char[] str = new char[]{'h','e','l','l','o'};
        leetCode.reverseString(str);
        assertArrayEquals(new char[]{'o','l','l','e','h'}, str);
    }

    @Test
    void sortedSquares() {
        int[] expected= new int[] {0,1,9,16,100};
        int[] actual = leetCode.sortedSquares(new int[]{-4, -1, 0, 3, 10});
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeDuplicates() {
        int[] ints = {1, 1, 2};
        leetCode.removeDuplicates(ints);
        assertArrayEquals(new int[]{1,2}, ints);
    }

    @Test
    void moveZeroes() {
        int[] nums={1,0,1};
        leetCode.moveZeroes(nums);
        assertArrayEquals(new int[]{1,1,0}, nums);
    }

    @Test
    void isPalindrome() {
        assertEquals(true, leetCode.isPalindrome("A man, a plan, a canal: Panama"));
    }
}