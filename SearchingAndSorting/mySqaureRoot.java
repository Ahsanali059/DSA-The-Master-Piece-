package SearchingAndSorting;

class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        
        long start = 1;
        long end = x;
        long result = 0;
        
        while (start <= end) {
            long mid = (start + end) / 2;
            
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                start = mid + 1;
                result = mid;
            } else {
                end = mid - 1;
            }
        }
        
        return (int) result;
    }
}
