class Solution {
    public boolean isValid(String s) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (var character : s.chars().toArray()) {
            var action = mapCharToAction(character);
            if (action == STACK_ACTION.PUSH) {
                stack.push(character);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }

                var openingBracket = stack.pop();
                var isClosingBracket = isClosingBracket(openingBracket, character);
                if (!isClosingBracket) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public STACK_ACTION mapCharToAction(int c) {
        return switch (c) {
            case '{', '[', '(' -> STACK_ACTION.PUSH;
            case '}', ']', ')' -> STACK_ACTION.POP;
            default -> throw new IllegalStateException();
        };
    }

    public boolean isClosingBracket(Integer openingBracket, Integer closingBracket) {
        return (openingBracket == '(' && closingBracket == ')') ||
                (openingBracket == '{' && closingBracket == '}') ||
                (openingBracket == '[' && closingBracket == ']');
    }

    public enum STACK_ACTION {
        PUSH,
        POP
    }
}
