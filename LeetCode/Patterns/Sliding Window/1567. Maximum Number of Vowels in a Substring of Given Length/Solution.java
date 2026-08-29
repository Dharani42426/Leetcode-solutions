class Solution {
    public int maxVowels(String s, int k) {
        int count = 0;
        for(int i=0; i<k; i++){
            if(isVowel(s.charAt(i))){
                count++;
            }
        }
        int max = count;
        int left = 0;
        for(int right=k; right<s.length(); right++){
            if(isVowel(s.charAt(left))){
                 count--;
            }
            if(isVowel(s.charAt(right))){
                count++;
            }
            left++;
            max = Math.max(count,max);
        }
        return max;
    }
    public boolean isVowel(char ch){
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
    }
}