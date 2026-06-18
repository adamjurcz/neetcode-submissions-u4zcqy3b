class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] nextHigherTemp = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];

            while(!stack.isEmpty() && temp > temperatures[stack.peek()]) {
                int previousIndex = stack.pop();

                nextHigherTemp[previousIndex] = i - previousIndex;
            }

            stack.push(i);
        }

        return nextHigherTemp;
    }
}
