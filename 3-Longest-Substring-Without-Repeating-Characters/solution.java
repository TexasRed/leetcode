public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> hash = new HashMap<>();
        
        int maxLen = Integer.MIN_VALUE;
        int n = s.length();
        for (int i = 0, j = 0; j < n; j++) {
            char c = s.charAt(j);
            if (!hash.containsKey(c)) {
                hash.put(c, 1);
            } else {
                // delete i
                hash.put(c, hash.get(c) + 1);
                while (hash.get(c) > 1) {
                    char d = s.charAt(i);
                    if (hash.get(d) == 1) {
                        hash.remove(d);
                    } else {
                        hash.put(d, hash.get(d) - 1);
                    }
                    i++;
                }
            }
            maxLen = Math.max(maxLen, j - i + 1);
        }
        
        return maxLen;
    }
}