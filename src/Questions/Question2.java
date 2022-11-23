package Questions;

public final class Question2 {

    public static int gcd(int i, int j) {
        var stack = new StackInteger(10, true);
        while (i != j) {
            if (i > j) {
                stack.push(i);
                i = i - j;
            } else {
                stack.push(j);
                j = j - i;
            }
        }
        return i;
    }
}
