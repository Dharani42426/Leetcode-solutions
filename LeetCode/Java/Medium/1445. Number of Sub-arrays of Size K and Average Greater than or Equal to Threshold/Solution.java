class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        double curr_sum = 0;
        int count = 0;
        int left = 0;
        for(int right = 0; right<arr.length; right++){
            curr_sum += arr[right];
            if(right >= k-1){
                double cAvg = curr_sum/k;
                if(cAvg >=threshold){
                    count++;
                }
                curr_sum -= arr[left];
                left++;
            }
        }
        return count;
    }
}