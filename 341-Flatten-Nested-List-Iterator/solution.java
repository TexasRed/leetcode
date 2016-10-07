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
public class NestedIterator implements Iterator<Integer> {
    
    private Stack<Iterator<NestedInteger>> stack = new Stack<>();
    private Integer top = null;
    public NestedIterator(List<NestedInteger> nestedList) {
        if (nestedList != null) {
            Iterator<NestedInteger> itr = nestedList.iterator();
            stack.push(itr);
        }
    }

    @Override
    public Integer next() {
        int retval = top;
        top = null;
        return retval;
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            while (stack.peek().hasNext()) {
                NestedInteger ni = stack.peek().next();
                if (ni.isInteger()) {
                    top = ni.getInteger();
                    return true;
                } else {
                    stack.push(ni.getList().iterator());
                }
            }
            stack.pop();
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */