package Questions;

public final class Question4 {

    public static int Power(int base, int exponent) {
        var stack = new StackInteger(2, false);
        if (exponent < 0) {
            throw new RuntimeException("Exponent must be greater than 0");
        }
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        stack.push(base);
        exponent--;

        while (exponent != 0) {
            stack.push(base);
            exponent--;
            var temp = stack.pop() * stack.pop();
            stack.push(temp);
        }
        return stack.pop();
    }
}
