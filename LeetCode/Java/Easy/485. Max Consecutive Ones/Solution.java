class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ones_count = 0;
        int max = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==1){
                ones_count++;
            }
            else{
                max = Math.max(ones_count, max);
                ones_count = 0;
            }
        }
        return Math.max(ones_count, max);
    }
}