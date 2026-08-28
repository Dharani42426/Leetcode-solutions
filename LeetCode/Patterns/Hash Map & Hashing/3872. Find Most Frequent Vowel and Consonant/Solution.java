class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }
        int maxvowel = 0;
        int maxconsonant = 0;
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            char ch = entry.getKey();
            int freq = entry.getValue();
            if("aeiou".indexOf(ch) != -1){
                maxvowel = Math.max(maxvowel, freq);
            }
            else{
                maxconsonant = Math.max(maxconsonant, freq);
            }
        }
        return maxvowel + maxconsonant;
    }
}