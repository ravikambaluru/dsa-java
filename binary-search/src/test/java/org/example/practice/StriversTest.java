package org.example.practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StriversTest {
    private final Strivers strivers;

    public StriversTest(){
        this.strivers=new Strivers();
    }

    @Test
    void search() {
        int[] nums={-1,0,3,5,9,12};
        assertEquals(-1,this.strivers.search(nums, 2));
    }

    @Test
    void lowerBound() {
        int[] nums={3,5,8,15,19};
        assertEquals(3, this.strivers.lowerBound(nums,9));
    }
}