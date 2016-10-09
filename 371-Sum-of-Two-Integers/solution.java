public class Solution {
    public int getSum(int a, int b) {
        int carrier = 0;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int da = (a >> i) & 1;
            int db = (b >> i) & 1;
            res = res | ((da ^ db ^ carrier) << i);
            carrier = ((da & db & carrier) == 1 
            || ((da ^ 1) & db & carrier) == 1
            || ((db ^ 1) & da & carrier) == 1
            || ((carrier ^ 1) & da & db) == 1) ? 1 : 0;
        }
        return res;
    }
}