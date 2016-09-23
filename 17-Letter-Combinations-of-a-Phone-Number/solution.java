public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if (digits == null || digits.length() == 0) return result;
        dfs(digits, 0, result, sb);
        return result;
    }
    
    private String[] options = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    private void dfs(String digits, int start, List<String> result, StringBuilder sb) {
        if (start >= digits.length()) {
            result.add(sb.toString());
            return;
        }
        for (char ch : options[digits.charAt(start) - '0'].toCharArray()) {
            sb.append(ch);
            dfs(digits, start + 1, result, sb);
            sb.setLength(sb.length() - 1);
        }
    }
}