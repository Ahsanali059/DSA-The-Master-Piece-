package stack;

import java.util.Stack;

public class LargestRactangleInHistogram 
{
    public static int LargestRactangle(int []heights)
    {
        Stack<Integer> stack = new Stack<>();

        int maxArea = 0;

        //step 1:find current height 
        for(int i=0;i<=heights.length;i++)
        {
            int currentHeight = 0;

            if(i==heights.length)
            {
                currentHeight=0;

            }
            else{
                currentHeight = heights[i];
            }

            //find width and height 
            while(!stack.isEmpty() && heights[currentHeight]<heights[stack.peek()])
            {
                int height = heights[stack.pop()];

                int width = 0;

                if(stack.isEmpty())
                {
                    width=i;
                }
                else {
                    width = i - stack.peek() -1;
                }

                maxArea = Math.max(maxArea, height*width);
            }

            stack.push(i);
        }

        return maxArea;
    } 

    public static void main(String[] args) 
    {
        
    }
    
}
