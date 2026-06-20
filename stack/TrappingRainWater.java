package stack;

import java.util.Stack;

/*
Problem Statement
Diya gaya: Ek array height[] jisme har element ek bar ki height represent karta hai.

Find karna hai: Bars ke beech trap hone wale total water units.

Condition: Water tabhi trap hoga jab kisi bar ke left aur right dono taraf taller bars exist karte ho.
 */
public class TrappingRainWater
{
    public static int trap(int[] height) {
        int n = height.length;
        int water = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();

                if (stack.isEmpty()) break;

                int distance = i - stack.peek() - 1;
                int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[top];
                water += distance * boundedHeight;
            }
            stack.push(i);
        }
        return water;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Total trapped water: " + trap(height));
        // Output: 6
    }
}
