class Solution {
    public int minimumRecolors(String blocks, int k) {
        int whitecount = 0;
        for(int i=0; i<k; i++){
            if(blocks.charAt(i)=='W'){
                whitecount++;
            }
        }
        int min = whitecount;
        for(int i=k; i<blocks.length(); i++){
            if(blocks.charAt(i)=='W'){
                whitecount++;
            }
            if(blocks.charAt(i-k)=='W'){
                whitecount--;
            }
            min = Math.min(min, whitecount);
        }
        return min;
    }
}