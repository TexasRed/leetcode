/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    // LeetCode does not support static variable!!!
    private static class Pair {
        int depth;
        int complete;
        public Pair(int depth, int complete) {
            this.depth = depth;
            this.complete = complete;
        }
    }
    public int depthSumInverse(List<NestedInteger> nestedList) {
        Pair pair = new Pair(0, 0);
        int partial = weightedDepthSum(nestedList, 1, pair);
        return pair.complete * (pair.depth + 1) - partial;
    }
    
    private int weightedDepthSum(List<NestedInteger> nestedList, int level, Pair pair) {
        int sum = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                sum += ni.getInteger() * level;
                pair.depth = Math.max(pair.depth, level);
                pair.complete += ni.getInteger();
            } else {
                sum += weightedDepthSum(ni.getList(), level + 1, pair);
            }
        }
        return sum;
    }
    
}