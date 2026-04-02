class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (String num : tokens){
                if(num.equals("+")){
                    stack.push(stack.pop() + stack.pop());
                }else if(num.equals("-")){
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b-a);
                }else if(num.equals("*")){
                    stack.push(stack.pop() * stack.pop());
                }else if(num.equals("/")){
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b/a);
                }else{
                    stack.push(Integer.parseInt(num));
                }
        }
        return stack.pop();
    }
}
