class Solution {
    public int largestRectangleArea(int[] heights) {
        int largestArea = 0;
        Deque<Bar> stack = new ArrayDeque<>();

        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            int startPoint = i;

            while (!stack.isEmpty() && height < stack.peek().height()) {
                Bar bar = stack.pop();
                int prevHeight = bar.height();
                int prevIndex = bar.index();
                int width = i - prevIndex;

                int area = width * prevHeight;
                largestArea = Math.max(largestArea, area);
                startPoint = prevIndex;
            }

            stack.push(new Bar(height, startPoint));
        }

        while (!stack.isEmpty()) {
            Bar bar = stack.pop();
            
            int area = (heights.length - bar.index()) * bar.height();
            largestArea = Math.max(largestArea, area);
        }

        return largestArea;
    }

    private record Bar(int height, int index) {}
}
