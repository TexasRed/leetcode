public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        if (s.length() < 2) return s.length();
        
        Map<Character, Integer> hash = new HashMap<>();
        int maxLen = Integer.MIN_VALUE;
        for (int i = -1, j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            if (!hash.containsKey(ch)) {
                hash.put(ch, j);
                maxLen = Math.max(maxLen, j - i);
            } else {
                int start = hash.get(ch);
                for (int k = i + 1; k <= start; k++) {
                    hash.remove(s.charAt(k));
                }
                i = start;
                hash.put(ch, j);
            }
        }
        return maxLen;
    }
}