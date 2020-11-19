import java.util.Stack;

/**
 * @Author: zy
 * @Date: 2020/11/5 23:12
 * @Description:
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> help;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        help = new Stack<>();
        help.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack.push(x);
        help.push(Math.min(x,help.peek()));
    }

    public void pop() {
        if(stack.isEmpty()){
            throw new NullPointerException("stack is null");
        }
        stack.pop();
        help.pop();
    }

    public int top() {
        if(stack.isEmpty()){
            throw new NullPointerException("stack is null");
        }
        return stack.peek();
    }

    public int getMin() {
        if(stack.isEmpty()){
            throw new NullPointerException("stack is null");
        }
        return help.peek();
    }
}
