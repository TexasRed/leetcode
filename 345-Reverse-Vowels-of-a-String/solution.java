public class Solution {
    public String reverseVowels(String s) {
        if (s == null) return s;
        
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        
        char[] arr = s.toCharArray();
        
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (i < s.length()) {
                if (vowels.contains(arr[i])) break;
                i++;
            }
            while (j >= 0) {
                if (vowels.contains(arr[j])) break;
                j--;
            }
            if (i >= j) break;
            char temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        
        return new String(arr);
    }
}