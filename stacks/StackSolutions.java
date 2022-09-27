package stacks;

import java.util.Stack;

public class StackSolutions {

    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length();i++){
            char x = expression.charAt(i);

            if (x == '(' || x == '[' || x == '{'){
                stack.push(x);
            }

            if (stack.isEmpty()){
                return false;
            }
            char check;
            switch (x){
                case ')' :
                    check = stack.pop();
                    if (check == '{' || check == '['){
                        return false;
                    }
                    break;
                case '}' :
                    check = stack.pop();
                    if (check == '(' || check == '['){
                        return false;
                    }
                    break;
                case ']' :
                    check = stack.pop();
                    if (check == '(' || check == '{'){
                        return false;
                    }
                    break;
            }
        }

        return (stack.isEmpty());
    }

    public static boolean isBalancedBetter(String expression){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++){
            if (expression.charAt(i)=='('){
                stack.push(expression.charAt(i));
            }
            else if (expression.charAt(i)==')'){
                if (stack.isEmpty()){
                    return false;
                }
                char topchar = stack.pop();
                if (expression.charAt(i) == ')' && topchar == '('){
                    continue;
                }else{
                    return false;
                }

            }
        }
        return stack.isEmpty();
    }

    public static void reverseStack(Stack<Integer> input, Stack<Integer> extra) {

        if (input.size()== 0 || input.size() == 1){
            return;
        }

        int temp = input.pop();
        reverseStack(input,extra);
        while (!input.isEmpty()){
            extra.add(input.pop());
        }
        input.add(temp);
        while(!extra.isEmpty()){
            input.add(extra.pop());
        }

    }

//    public static boolean checkRedundantBrackets(String expression) {

//    }

    public static int[] stockSpan(int[] price) {
        int n = price.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        ans[0] = 1;
        for (int i = 1; i < n ; i++){
            while (!stack.empty() && price[stack.peek()] <= price[i]) {
                stack.pop();
            }
            if (stack.isEmpty()){
                ans[i] = i + 1;
            }
            else{
                ans[i] = i - stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    private static boolean find(char ch){
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/'  ){
            return true;
        }
        return false;
    }
    public static boolean checkRedundantBrackets(String expression) {
        Stack<Character> stk = new Stack<>();
        for (int i = 0 ; i < expression.length(); i++){
            if (expression.charAt(i) == '(' || find(expression.charAt(i))){
                stk.push(expression.charAt(i));
            }else if(expression.charAt(i) == ')'){
                boolean hasOperator = false;

                while (!stk.isEmpty() && stk.peek() != '('){
                    stk.pop();
                    hasOperator = true;
                }
                if (!hasOperator){
                    return true;
                }
                if (!stk.isEmpty()){
                    stk.pop();
                }
            }
        }
        return false;
    }

    public static int countBracketReversals(String input) {
        int len = input.length();

        if (len%2 != 0){
            return -1;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < len; i++){
            char c = input.charAt(i);
            if (c == '}' && !stack.isEmpty()){
                if (stack.peek() =='{'){
                    stack.pop();
                }
                else{
                    stack.push(c);
                }
            }
            else {
                stack.push(c);
            }

        }
        int reduced_len = stack.size();

        int n = 0;
        while (!stack.isEmpty() && stack.peek() == '{'){
            stack.pop();
            n++;
        }
        return(reduced_len / 2 + n % 2);
    }
    public static int countBracketReversalsBetter(String input){
        int len = input.length();

        if (len%2 != 0){
            return -1;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < len; i++){
            char c = input.charAt(i);
            if (c == '}' && !stack.isEmpty()){
                if (stack.peek() =='{'){
                    stack.pop();
                }
                else{
                    stack.push(c);
                }
            }
            else {
                stack.push(c);
            }

        }
        int count = 0;

        while(!stack.isEmpty()){
            char char1 = stack.pop();
            char char2 = stack.pop();

            if (char1 != char2){
                count += 2;
            }else{
                count+=1;
            }

        }
        return count;
    }
}
