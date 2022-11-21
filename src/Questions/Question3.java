package Questions;

import java.util.Stack;

public final class Question3 {

    public static boolean isPalindrome(String s) {

        var stack = new StackCharacter(s.length(), true);

        for (var i = 0; i < s.length() / 2; i++) {
            stack.push(s.charAt(i));
        }

        var offset = s.length() % 2 == 0 ? 0 : 1;

        for (var i = s.length() / 2 + offset; i < s.length(); i++) {
            if (stack.pop() != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

    }
}
