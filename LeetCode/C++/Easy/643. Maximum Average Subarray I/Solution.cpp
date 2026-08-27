class Solution {
public:
    double findMaxAverage(vector<int>& nums, int k) {
        int n = nums.size();
        int sum = 0;
        for(int i=0; i<k; i++){
            sum += nums[i];
        }
        int l = 0, r = k-1;
        int maxSum = sum;
        while(r<n-1){
            sum -= nums[l];
            l++;
            r++;
            sum += nums[r];
            maxSum = max(maxSum, sum);
        }
        return (double)maxSum/k;
    }
};