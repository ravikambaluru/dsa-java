package prefixSum;

public class NumArray {
    private int[] nums;
//    public NumArray(int[] nums) {
//        this.nums=nums;
//    }

    //    public int sumRange(int left, int right) {
//        int rangeSum=0;
//        for (int i = left; i <= right; i++) {
//            rangeSum+=nums[i];
//        }
//        return rangeSum;
//    }
    public NumArray(int[] nums) {
        this.nums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            this.nums[i + 1] = this.nums[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return this.nums[right + 1] - this.nums[left];
    }

    public int largestAltitude(int[] gain) {
        int maxAltitude = 0;
        int[] runningList = new int[gain.length + 1];
        for (int i = 0; i < gain.length; i++) {
            runningList[i + 1] = runningList[i] + gain[i];
            maxAltitude = Math.max(maxAltitude, runningList[i + 1]);
        }
        return maxAltitude;
    }

}
