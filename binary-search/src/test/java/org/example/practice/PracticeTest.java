package org.example.practice;

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
}