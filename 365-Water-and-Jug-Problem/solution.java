public class Solution {
    public static int gcd(int x, int y) {
        while (true) {
            if (x == y || y == 0) break;
            if (x > y) {
                x = x - y;
            } else {
                x = x ^ y;
                y = x ^ y;
                x = x ^ y;
            }
        }
        return x;
    }
    
    public boolean canMeasureWater(int x, int y, int z) {
        return (x + y == z) || ((x + y > z) && (z % gcd(x, y) == 0));
    }
}