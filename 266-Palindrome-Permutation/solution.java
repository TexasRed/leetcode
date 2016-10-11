public class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() < 2) return true;
        
        int len = s.length();
        Map<Character, Integer> hash = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (hash.get(c) == null) {
                hash.put(c, 1);
            } else {
                hash.put(c, hash.get(c) + 1);
            }
        }
        int count = 0;
        for (Character c : hash.keySet()) {
            if (hash.get(c) % 2 != 0) {
                count++;
            }
        }
        if (len % 2 == 0)
            return count == 0;
        else
            return count == 1;
    }
}