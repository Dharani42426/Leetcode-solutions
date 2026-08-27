class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int count = 1;
        int max = 0;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i]<nums[i+1]){
                count++;
            }
            else{
                max = Math.max(max, count);
                count = 0;
            }
        }
        return Math.max(max, count);
    }
}