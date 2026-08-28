class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder s1 = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                s1.append(Character.toLowerCase(ch));
            }
        }
        String original = s1.toString();
        String reverse = s1.reverse().toString();
        return original.equals(reverse);
    }
}