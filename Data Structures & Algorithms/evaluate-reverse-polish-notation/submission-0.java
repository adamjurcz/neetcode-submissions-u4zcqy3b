class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (String token : tokens) {
            if (isNumeric(token)) {
                deque.push(Integer.valueOf(token));
            } else {
                var secondNumber = deque.pop();
                var firstNumber = deque.pop();
                Integer result = 0;

                if (token.equals("+")) {
                    result = firstNumber + secondNumber;
                }
                if (token.equals("-")) {
                    result = firstNumber - secondNumber;
                }
                if (token.equals("*")) {
                    result = firstNumber * secondNumber;
                }
                if (token.equals("/")) {
                    result = firstNumber / secondNumber;
                }
                deque.push(result);
            }
        }

        return deque.pop();
    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
