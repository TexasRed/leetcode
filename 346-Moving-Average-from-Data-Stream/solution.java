public class MovingAverage {
    int sum;
    int capacity;
    Deque<Integer> deque;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.deque = new LinkedList<>();
        this.capacity = size;
    }
    
    public double next(int val) {
        deque.offer(val);
        sum += val;
        if (deque.size() <= capacity) {
            return (double) sum / deque.size();
        } else {
            sum -= deque.pollFirst();
            return (double) sum / capacity;
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */