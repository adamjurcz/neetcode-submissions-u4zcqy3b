class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Deque<Double> stack = new ArrayDeque<>();
        int cars[][] = new int[position.length][2];

        for(int i = 0; i < position.length; i++) {
            cars[i][0] = speed[i];
            cars[i][1] = position[i];
        }

        Arrays.sort(cars, (a, b) -> a[1] - b[1]);

        for(int i = position.length - 1; i >= 0; i--) {
            var distance = target - cars[i][1];
            var currentSpeed = cars[i][0];

            double timeToFinish = (double)distance/currentSpeed;

            if(stack.isEmpty()) {
                stack.push(timeToFinish);
                continue;
            }

            double nextTimeToFinish = stack.peek();
            if(timeToFinish > nextTimeToFinish) {
                stack.push(timeToFinish);
            }

        }
        
        return stack.size();
    }

}
