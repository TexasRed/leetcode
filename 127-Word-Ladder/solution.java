public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        wordList.add(endWord);
        
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        
        int level = 1;
        if (beginWord.equals(endWord)) return level;
        queue.offer(beginWord);
        visited.add(beginWord);
        
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                String word = queue.poll();
                List<String> nextWords = getWordList(word, wordList);
                for (String next : nextWords) {
                    if (visited.contains(next)) continue;
                    if (next.equals(endWord)) return level + 1;
                    visited.add(next);
                    queue.offer(next);
                }
            }
            level++;
        }
        return 0;
    }
    
    public List<String> getWordList(String word, Set<String> wordList) {
        List<String> result = new ArrayList<>();
        int m = word.length();
        for (int i = 0; i < m; i++) {
            char d = word.charAt(i);
            for (char c = 'a'; c <='z'; c++) {
                if (c == d) continue;
                char[] arr = word.toCharArray();
                arr[i] = c;
                String next = new String(arr);
                if (wordList.contains(next)) {
                    result.add(next);
                }
            }
        }
        return result;
    }
}