class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double curr_sum = 0;
        double max = -100000000;
        int left = 0;
        for(int right=0; right<nums.length; right++){
            curr_sum+=nums[right];
            if(right >= k-1){
                double cAvg = curr_sum/k;
                max = Math.max(max, cAvg);
                curr_sum -= nums[left];
                left++;
            }
        }
        return max;
    }
}