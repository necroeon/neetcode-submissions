class MinStack {
    long min;
    private Stack<Long> stack;

    public MinStack() {
        stack = new Stack <>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(0L); //0L is 0 Long, prevents overflow
            min = val;
        }else{
            stack.push((long) val - min);
            if (val < min) min = (long) val; //to check if newly added val is new min
        }
    }
    
    public void pop() {
        if (stack.isEmpty()) return;

        long pop = stack.pop();

        if (pop < 0) min = min - pop;
    }
    
    public int top() {
        long top  = stack.peek();
        if (top > 0){
            return (int) (top + min);
        }else{
            return (int) min;
        }
    }
    
    public int getMin() {
        return (int) min;
    }
}