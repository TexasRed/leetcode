public class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows <= 1) return s;
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
          int j = 0; 
          while (true) {
            int pos1 = i + j * 2 * (numRows - 1);
            int pos2 = i + (j + 1) * 2 * (numRows - 1) - 2 * i;
            if (pos1 < s.length()) {
                sb.append(s.charAt(pos1));
            } else {
                break;
            }
            if (pos2 < s.length()) {
                if ( i > 0 && i < numRows - 1)
                    sb.append(s.charAt(pos2));
            } else {
                break;
            }
            j++;
          }
        }
        return sb.toString();
    }
}