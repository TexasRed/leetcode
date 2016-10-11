public class Solution {
    public char findTheDifference(String s, String t) {
        int[] count = new int[256];
        for (char c : t.toCharArray()) {
            count[c] += 1;
        }
        for (char c : s.toCharArray()) {
            count[c] -= 1;
        }
        char res = '*';
        for (int i = 0; i < 256; i++) {
            if (count[i] == 1)
                return (char) i;
        }
        return res;
    }
}