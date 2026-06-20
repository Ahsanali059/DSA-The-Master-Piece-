package stack;

public class MaximalRectangle
{
        public static int maximalRectangle(char[][] matrix) {
            // base case
            if (matrix.length == 0)
                return 0;

            // use matrix[0] to find the numbers of columns in the matrix
            int n = matrix[0].length;
            int[] heights = new int[n];
            int maxArea = 0;

            for (char[] row : matrix) {
                // Build histogram for current row
                for (int i = 0; i < n; i++) {
                    if (row[i] == '1') {
                        heights[i] += 1;
                    } else {
                        heights[i] = 0;
                    }
                }
                // Apply Largest Rectangle in Histogram
                maxArea = Math.max(maxArea, largestRectangleArea(heights));
            }
            return maxArea;
        }

        private static int largestRectangleArea(int[] heights) {
            int n = heights.length;
            java.util.Stack<Integer> stack = new java.util.Stack<>();
            int maxArea = 0;

            for (int i = 0; i <= n; i++) {
                int h = (i == n ? 0 : heights[i]);
                while (!stack.isEmpty() && h < heights[stack.peek()]) {
                    int height = heights[stack.pop()];
                    int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                    maxArea = Math.max(maxArea, height * width);
                }
                stack.push(i);
            }
            return maxArea;
        }

        public static void main(String[] args) {
            char[][] matrix = {
                    {'1','0','1','0','0'},
                    {'1','0','1','1','1'},
                    {'1','1','1','1','1'},
                    {'1','0','0','1','0'}
            };
            System.out.println("Maximal Rectangle Area: " + maximalRectangle(matrix));
            // Output: 6
        }
}
