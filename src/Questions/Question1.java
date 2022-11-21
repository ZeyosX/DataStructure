package Questions;

public final class Question1 {
    private static int Precedence(char ch) {
        return switch (ch) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }

    private static String ConvertToPostfix(String expression) {
        var result = new StringBuilder();

        var stack = new StackCharacter(expression.length(), true);

        for (var i = 0; i < expression.length(); i++) {
            var c = expression.charAt(i);

            if (expression.charAt(i) == ' ') {
                continue;
            }

            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.peek());
                    stack.pop();
                }

                stack.pop();
            } else {
                while (!stack.isEmpty() && Precedence(c) <= Precedence(stack.peek())) {
                    result.append(stack.peek());
                    stack.pop();
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                throw new RuntimeException("Invalid Expression");
            }
            result.append(stack.peek());
            stack.pop();
        }

        return result.toString();
    }

    private static int calculatePostfix(String exp) {
        var stack = new StackInteger(exp.length(), true);

        for (var i = 0; i < exp.length(); i++) {
            var c = exp.charAt(i);

            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                var left = stack.pop();
                var right = stack.pop();

                switch (c) {
                    case '-' -> stack.push(right - left);
                    case '+' -> stack.push(right + left);
                    case '/' -> stack.push(right / left);
                    case '*' -> stack.push(right * left);
                    case '^' -> stack.push((int) Math.pow(right, left));
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String exp = "5 + 2 * (30 - 10/5)";

        System.out.println("Infix Expression: " + exp);
        System.out.println("Postfix Expression: " + ConvertToPostfix(exp));
        System.out.println("Value of the postfix expression: " + calculatePostfix(ConvertToPostfix(exp)));

    }

}
