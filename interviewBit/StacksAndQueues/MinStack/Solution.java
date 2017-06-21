import java.util.*;

class Solution {
    
    int top = -1;
    ArrayList<Integer> stack = new ArrayList<Integer>();
    ArrayList<Integer> minStack = new ArrayList<Integer>();
    
    public void push(int x) {
        
        if(top == -1)
        {
            top++;
            stack.add(x);
            minStack.add(x);
        }
        else
        {
            if(minStack.get(top) > x)
            {
                top++;
                stack.add(x);
                minStack.add(x);
            }
            else
            {
                top++;
                stack.add(x);
                minStack.add(top,minStack.get(top - 1));
            }
        }
    }

    public void pop() {
        if(top == -1)
        {
            return;
        }
        else
        {
            stack.remove(top);
            minStack.remove(top);
            top--;
        }
        
    }

    public int top() {
        if(top != -1)
            return stack.get(top);
        else
            return -1;
    }

    public int getMin() {
        if(top != -1)
            return minStack.get(top);
        else
            return -1;
        
    }
}
