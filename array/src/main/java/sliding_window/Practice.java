package sliding_window;

public class Practice {

    /**
     * LeetCode #642 Max avg sub array
     */
    public double findMaxAverage(int[] nums, int k) {
        double window_sum=0;
        double max_avg =0f;
        for (int i = 0; i < k; i++) window_sum+=nums[i];
        max_avg=window_sum/k;

        for (int i = k; i < nums.length; i++) {
            window_sum+=nums[i]-nums[i-k];
            max_avg=Math.max(max_avg, window_sum/k);
        }
        return max_avg;
    }
}
