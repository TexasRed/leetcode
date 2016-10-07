public class MovingAverage {
    int start;
    int end;
    int[] ring_buffer;
    int sum;
    int size;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.sum = 0;
        this.ring_buffer = new int[size];
        this.size = size;
        this.start = -1;
        this.end = 0;
    }
    
    public double next(int val) {
        if (start == end) {
            sum = sum - ring_buffer[start] + val;
            ring_buffer[start] = val;
            start = (start + 1) % size;
            end = start;
            return (double) sum / size;
        } else {
            sum += val;
            if (start == -1) {
                start += 1;
            }
            ring_buffer[end] = val;
            int len = end - start + 1;
            end = (end + 1) % size;
            return (double) sum / len;
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */