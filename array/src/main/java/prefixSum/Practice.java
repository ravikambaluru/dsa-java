package prefixSum;

public class Practice {
    public int waysToSplitArray(int[] nums) {
        long[] prefixSumArray = new long[nums.length + 1];
        int validSplits = 0;

        // create pre-fix array
        for (int i = 0; i < nums.length; i++) {
            prefixSumArray[i + 1] = prefixSumArray[i] + nums[i];
        }
        long totalSum = prefixSumArray[prefixSumArray.length - 1];
        for (int i = 1; i < prefixSumArray.length - 1; i++) {
            long leftSplitSum = prefixSumArray[i];
            if (leftSplitSum >= (totalSum - leftSplitSum))
                validSplits++;
        }
        return validSplits;
    }

}
