package org.example.practice;

import java.util.Arrays;

public class Practice {


    /**
    Leet Code #1029
    Input: costs = [[10,20],[30,200],[400,50],[30,20]]
    Output: 110
    Explanation:
    The first person goes to city A for a cost of 10.
    The second person goes to city A for a cost of 30.
    The third person goes to city B for a cost of 50.
    The fourth person goes to city B for a cost of 20.
    @param costs
    @return
     */
    public int twoCitySchedCost(int[][] costs) {
        int minCost=0;
        int[] savingsMatrix=new int[costs.length];
        for (int i = 0; i < costs.length; i++) {
            savingsMatrix[i]=costs[i][1]-costs[i][0];
        }
        Arrays.sort(savingsMatrix);
        return minCost;
    }

    /**
    LeetCode #455
    Input: g = [1,2,3], s = [1,1]
    Output: 1
     */
    public int findContentChildren(int[] g, int[] s) {
        int maxContent=0, greedIndex=0, sizeIndex=0;

        // sort arrays in asc
        Arrays.sort(g);
        Arrays.sort(s);

        while(greedIndex<g.length && sizeIndex<s.length){
            if(s[sizeIndex]>=g[greedIndex]){
                maxContent++;
                greedIndex++;
            }
                sizeIndex++;

        }
        return maxContent;
    }

    /**
    LeetCode #860
    Input: bills = [5,5,5,10,20]
    Output: true
     */
    public boolean lemonadeChange(int[] bills) {
        int fiveBill=0;
        int tenBill=0;
        for(int bill: bills){
            if(bill==5) fiveBill++;

            else if(bill==10){
                if (fiveBill<1) return false;
                fiveBill--;
                tenBill++;
            } else{
                if(tenBill>0 && fiveBill>=1){
                    tenBill--;
                    fiveBill--;
                }else if(fiveBill>=3) fiveBill-=3;
                else return false;
            }
        }
        return true;
    }

    /**
    LeetCode #122
    @param prices
    @return
     */
    public int maxProfit(int[] prices) {
        int sharePrice=0;
        int maxProfit=0;
        for(int i=1;i<prices.length;i++){
            sharePrice=Math.min(prices[i],prices[i-1]);
            if(prices[i]>prices[i-1])maxProfit+=prices[i]-sharePrice;
        }
        return maxProfit;
    }
}
