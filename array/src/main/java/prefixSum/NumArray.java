package prefixSum;

import java.util.HashMap;

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

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int runningSum = 0, count = 0;
        for (int num : nums) {
            runningSum += num;
            int delta = runningSum - k;
            if (map.containsKey(delta)) {
                Integer occurrences = map.get(delta);
                count += occurrences;

            }
            map.put(runningSum, map.getOrDefault(runningSum, 0) + 1);

        }
        return count;
    }

    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int runningSum = 0;

        for (int num : nums) {
            runningSum += num;
            int remainder = runningSum % k;
            if (map.containsKey(remainder)) {
                count += map.get(remainder);
            }
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        return count;
    }

}
