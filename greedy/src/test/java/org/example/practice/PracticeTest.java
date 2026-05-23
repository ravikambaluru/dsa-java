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

    @Test
    void lemonadeChange() {
        int [] bills={5,5,10,5,20,5,5,5,5,5,20,5,10,5,5,5,5,20,20,5};
        assertEquals(true,this.practice.lemonadeChange(bills));
    }

    @Test
    void maxProfit() {
        int[] prices= {7,1,5,3,6,4};
        assertEquals(7, this.practice.maxProfit(prices));
    }
}