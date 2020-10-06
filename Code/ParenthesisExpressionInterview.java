import java.util.Stack;
public class ParenthesisExpressionInterview {
    // Given a String with open and closed parenthesis, determine if it is valid. 
    public static void main(String[] args) {
        String expression = "y = 1 + (((mx) + b) + ((3*3)/7))";
        System.out.println(new ParenthesisExpressionInterview().isValid(expression));
    }

    public boolean isValid(String expression) {
        Stack<String> stack = new Stack<String>();

        for(int i=0; i<expression.length(); i++) {
            if(expression.charAt(i) == '(') {
                stack.push("(");
            }
            else if(expression.charAt(i) == ')') {
                try {
                    stack.pop();
                }
                catch(Exception e) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
