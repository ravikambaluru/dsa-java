package org.example.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PracticeTest{

    private final Practice practice=new Practice();




    @ParameterizedTest(name="Test Square root problem")
    @CsvSource(
            {
            "64,8",
            "63,7"
            })
    void testMySqrt(int input, int expected) {
        assertEquals(expected,this.practice.mySqrt(input));
    }

    @Test
    @DisplayName("Should test display name method")
    void testSearch() {
        int[] nums={3,1};
        int target=1;
        assertEquals(1, this.practice.search(nums,target));
    }

    @Test
    void testPeakElement(){
        int[] nums={1,2};
        int expected=1;
        assertEquals(expected,this.practice.findPeakElement(nums));
    }
    @Test
    void testMinimumElementInRotated(){
        int[] nums={2,3,4,5,1};
        int expected=1;
        assertEquals(expected,this.practice.findMin(nums));
    }

    @Test
    void testSearchRange(){
        int[] nums={2,2};
        Assertions.assertArrayEquals(new int[]{0, 1},this.practice.searchRange(nums,2));
    }

    @Test
    void testPeakInMountainArray(){
        int[] arr={0,3,5,12,2};
        Assertions.assertEquals(3,this.practice.peakIndexInMountainArray(arr));
    }
    @Test
    void testsingleNonDuplicate(){
        int [] nums= {1,1,2,3,3,4,4,8,8};
        assertEquals(2, this.practice.singleNonDuplicate(nums));
    }



}