/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    private static class Pair {
        List<NestedInteger> li;
        Integer level;
        public Pair(List<NestedInteger> li, Integer level) {
            this.li = li;
            this.level = level;
        }
    }
    public int depthSum(List<NestedInteger> nestedList) {
      Stack<Pair> stack = new Stack<>();
      int sum = 0;
      stack.push(new Pair(nestedList, 1));
      while (!stack.isEmpty()) {
          Pair curr = stack.pop();
          int level = curr.level;
          for (NestedInteger ni : curr.li) {
              if (ni.isInteger()) {
                  sum += ni.getInteger() * level;
              } else {
                  stack.push(new Pair(ni.getList(), level + 1));
              }
          }
      }
      return sum;
    //   return weightedDepthSum(nestedList, 1);
    }
    
    private int weightedDepthSum(List<NestedInteger> nestedList, int level) {
        int sum = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
               sum += ni.getInteger() * level; 
            } else {
               sum += weightedDepthSum(ni.getList(), level + 1);
            }
        }
        return sum;
    }
}