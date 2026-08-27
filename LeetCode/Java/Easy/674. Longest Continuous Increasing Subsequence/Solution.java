class Solution {
    public int findLengthOfLCIS(int[] nums) {

        int current = 1;
        int max = 1;

        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] < nums[i + 1]) {
                current++;
            } else {
                current = 1;
            }

            max = Math.max(max, current);
        }

        return max;
    }
}