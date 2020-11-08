package Problem1;

import java.util.Stack;

public class ReverseStack {
    public static void reverseStack(Stack<Integer> stack) {

        if (stack.size() != 0)
        {
            int i = stack.pop();

            reverseStack(stack);
            reverseOrder(stack, i);
        }
    }


    public static void reverseOrder(Stack<Integer> stack, int i) {

        if (stack.size() == 0)
        {
            stack.push(i);
        }

        else
        {
            int x = stack.pop();

            reverseOrder(stack, i);
            stack.push(x);
        }
    }
}