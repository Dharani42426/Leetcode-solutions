class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] target = s1.toCharArray();
    Arrays.sort(target);
    int k = s1.length();
    for (int i = 0; i <= s2.length() - k; i++) {
        char[] window = s2.substring(i, i + k).toCharArray();
        Arrays.sort(window);
        if (Arrays.equals(target, window)) {
            return true;
        }
    }
    return false;
    }
}