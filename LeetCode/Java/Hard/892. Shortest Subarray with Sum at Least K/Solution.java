class Solution {
    public int shortestSubarray(int[] nums, int k) {

        int n = nums.length;
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {

            for (int j = i + 1; j <= n; j++) {

                long sum = prefix[j] - prefix[i];

                if (sum >= k) {
                    ans = Math.min(ans, j - i);
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}