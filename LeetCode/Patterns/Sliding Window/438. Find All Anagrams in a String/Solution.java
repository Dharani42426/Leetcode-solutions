class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] freq = new int[26];
        int[] currfreq = new int[26];
        for(char ch : p.toCharArray()){
            freq[ch-'a']++;
        }
        int left = 0;
        for(int right = 0; right<s.length(); right++){
            currfreq[s.charAt(right)-'a']++;
            if(right-left+1>p.length()){
                currfreq[s.charAt(left)-'a']--;
                left++;
            }
            if(right-left+1==p.length()){
                if(Arrays.equals(freq, currfreq)){
                    result.add(left);
                }
            }
        }
        return result;
    }
}