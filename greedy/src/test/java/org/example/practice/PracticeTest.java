package org.example.practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PracticeTest {
    private final Practice practice;
    public PracticeTest() {
        this.practice = new Practice();
    }

    @Test
    void twoCitySchedCost() {
        int[][] costs= new int[][]{{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}};
        assertEquals(1859, this.practice.twoCitySchedCost(costs));

    }

    @Test
    void findContentChildren(){
        int[] greedArray={1,2, 3};
        int[] sizeArray={1,1};
        assertEquals(1,this.practice.findContentChildren(greedArray,sizeArray));
    }
}