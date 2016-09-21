public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        wordList.add(endWord);
        
        Map<String, Integer> distance = new HashMap<>();
        Map<String, List<String>> parents = new HashMap<>();
        for (String word : wordList) {
            parents.put(word, new ArrayList<>());
        }
        bfs(beginWord, wordList, parents, distance);
        
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(endWord, beginWord, parents, distance, result, path);
        
        return result;
    }
    
    public void dfs(
        String currWord,
        String beginWord,
        Map<String, List<String>> parents,
        Map<String, Integer> distance,
        List<List<String>> result,
        List<String> path) {
        
        path.add(currWord);
        if (currWord.equals(beginWord)) {
            List<String> solution = new ArrayList<>(path);
            Collections.reverse(solution);
            result.add(solution);
        }
        for (String parent : parents.get(currWord)) {
            if (distance.get(currWord) == distance.get(parent) + 1) {
              dfs(parent, beginWord, parents, distance, result, path);  
            }
        }
        path.remove(path.size() - 1);
    }
    
    public void bfs(
        String beginWord,
        Set<String> wordList,
        Map<String, List<String>>parents,
        Map<String, Integer> distance) {
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord, 1);
        while (!queue.isEmpty()) {
            String currWord = queue.poll();
            for (String next : getNextWords(currWord, wordList)) {
                parents.get(next).add(currWord);
                if (!distance.containsKey(next)) {
                  distance.put(next, distance.get(currWord) + 1);
                  queue.offer(next);
                }
            }
        }
    }
    
    private List<String> getNextWords(String word, Set<String> dict) {
        List<String> result = new ArrayList<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
          for (char ch = 'a'; ch <= 'z'; ch++) {
              if (chars[i] == ch) continue; 
              char temp = chars[i];
              chars[i] = ch;
              String nextWord = new String(chars);
              if (dict.contains(nextWord))
                result.add(nextWord);
              chars[i] = temp;
          }
        }
        return result;
    }
}