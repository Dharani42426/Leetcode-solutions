class Solution {
public:
    int numOfSubarrays(vector<int>& arr, int k, int threshold) {
        int n = arr.size();
        int sum = 0;
        for(int i=0; i<k; i++){
            sum += arr[i];
        }
        int count=0;
         if(sum>=k*threshold){
            count++;
         }
        int l =0, r=k-1;
        while(r<n-1){
              sum -= arr[l];
                l++;
                r++;
                sum += arr[r];
                      if(sum>=k*threshold){
            count++;
         }
        }
        return count;
    }
};