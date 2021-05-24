package datastructures.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String parenthesis1 = "{}[]()";
        System.out.println(isValidParenthesis(parenthesis1));

        String parenthesis2 = "{}[]([{}])";
        System.out.println(isValidParenthesis(parenthesis2));

        String parenthesis3 = "{}[]()[(])";
        System.out.println(isValidParenthesis(parenthesis3));

        String parenthesis4 = "{[]()[(){[]()}]}";
        System.out.println(isValidParenthesis(parenthesis4));


    }

    public static boolean isValidParenthesis(String parenthesis){

        Map<Character, Character> parenthesisMap = new HashMap<>(){{
            put('{','}');
            put('[',']');
            put('(',')');
        }};

        Stack<Character> stack = new Stack<>();
        for (char character:parenthesis.toCharArray()) {
            if (parenthesisMap.containsKey(character)){
                stack.push(character);
            }else {
                char lastChar = stack.pop();
                if(character != parenthesisMap.get(lastChar)){
                    return  false;
                }
            }
        }

        if (stack.isEmpty())
            return true;
        return false;

    }
}
