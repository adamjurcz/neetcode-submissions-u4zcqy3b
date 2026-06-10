class Solution {
    public int trap(int[] height) {
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        int sum = 0;

        for(int i = 0; i < height.length; i++) {
            if(i == 0) {
                maxLeft[i] = height[i];
                continue;
            }

            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }


        for(int i = height.length - 1; i >= 0; i--) {
            if(i == height.length - 1) {
                maxRight[i] = height[i];
                continue;
            }

            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }

        for(int i = 0; i < height.length; i++) {
            if(i == 0 || i == height.length - 1) continue;

            int waterBar = Math.min(maxLeft[i - 1], maxRight[i + 1]) - height[i];
            if(waterBar > 0) sum += waterBar; 
        }

        return sum;
    }
}
