package src.ru.vsu.sc.savenkova_a_v;

import java.util.Stack;

public class ReversingElementsOfStack {
    public static String reverseStandardStack(String str) {
        Stack<Character> symbols = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (Character symbol : str.toCharArray()) {
            symbols.push(symbol);
        }

        while (!symbols.isEmpty()) {
            result.append(symbols.pop());
        }

        return result.toString();
    }

    public static String reverseSimpleStack(String str) {
        SimpleStack<Character> symbols = new SimpleStack<Character>();
        StringBuilder result = new StringBuilder();

        for (Character symbol : str.toCharArray()) {
            symbols.push(symbol);
        }

        while (!symbols.empty()) {
            result.append(symbols.pop());
        }

        return result.toString();
    }
}
