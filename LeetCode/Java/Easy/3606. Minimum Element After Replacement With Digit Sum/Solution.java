class Solution {
    public int minElement(int[] nums) {
        int[] sumarr = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            int sum = 0;
            while(nums[i]>0){
                int d = nums[i]%10;
                sum += d;
                nums[i]/=10;
            }
            sumarr[i] = sum;
        }
        int min = sumarr[0];
        for(int i=0; i<sumarr.length; i++){
            if(sumarr[i]<min){
                min = sumarr[i];
            }
        }
        return min;
    }
}