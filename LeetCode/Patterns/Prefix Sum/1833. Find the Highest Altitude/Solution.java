class Solution {
    public int largestAltitude(int[] gain) {
        int[] ans = new int[gain.length+1];
        int sum = 0;
        for(int i=0; i<gain.length; i++){
            sum += gain[i];
            ans[i+1] = sum;
        }
        Arrays.sort(ans);
        return ans[ans.length-1];
    }
}