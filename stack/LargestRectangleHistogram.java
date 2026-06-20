package stack;

import java.util.Stack;

/*
Problem statement: Ek array heights jisma har element ek histogram
ki height represent karta hai.

-> Find karna ha histogram ka andar banana wala sub sa barha area.

Har bar ke liye rectangle banane ke liye uska Previous Smaller Element (PSE) aur Next Smaller Element (NSE) find karna hota hai.

Optimize approach:
-> Traverse array from left to right
-> Maintain a stack of indices with increasing heights
-> jab b current height stack ke top sa choti hotab pop karo and area calculate karo.
            Area = height[top] * width;
            width = rightIndex - leftIndex - 1;
-> Har bar ek hi baar push/pop hota hai → O(n) time.

Dry Run with Stack
We maintain a monotonic increasing stack of indices.

i=0, h=2

Stack empty → push 0

Stack = [0]

i=1, h=1

h < heights[0]=2 → pop 0

Area = 2 × (i=1 since stack empty) = 2

Push 1 → Stack = [1]

i=2, h=5

h ≥ heights[1]=1 → push 2

Stack = [1,2]

i=3, h=6

h ≥ heights[2]=5 → push 3

Stack = [1,2,3]

i=4, h=2

h < heights[3]=6 → pop 3

Area = 6 × (i - stack.peek() - 1 = 4-2-1=1) = 6

h < heights[2]=5 → pop 2

Area = 5 × (i - stack.peek() - 1 = 4-1-1=2) = 10 ✅

Push 4 → Stack = [1,4]

i=5, h=3

h ≥ heights[4]=2 → push 5

Stack = [1,4,5]

i=6, h=0 (sentinel)

h < heights[5]=3 → pop 5

Area = 3 × (i - stack.peek() - 1 = 6-4-1=1) = 3

h < heights[4]=2 → pop 4

Area = 2 × (i - stack.peek() - 1 = 6-1-1=4) = 8

h < heights[1]=1 → pop 1

Area = 1 × (i=6 since stack empty) = 6
 */
public class LargestRectangleHistogram
{
    public static int findLargestRectangleArea(int []heights)
    {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < n; i++)
        {
            int nextHeight = (i == 0) ? 0 : heights[i];

            while (!st.isEmpty() && nextHeight < heights[st.peek()])
            {
                int height = heights[st.peek()];
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                maxArea = Math.max(maxArea, width * height);
            }

            st.push(i);
        }

        return maxArea;
    }
    
}
