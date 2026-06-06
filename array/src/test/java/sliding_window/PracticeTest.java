package sliding_window;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PracticeTest {
    private final Practice practice;

    PracticeTest() {
        practice = new Practice();
    }


    @Test
    void findMaxAverage() {
        // Given
        int[] nums={1,12,-5,-6,50,3};
        int k=4;

        // When + Then
        assertEquals(12.75, this.practice.findMaxAverage(nums, k));
    }
}