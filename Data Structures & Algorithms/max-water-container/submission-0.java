class Solution {
    public int maxArea(int[] heights) {
        var list = Arrays.stream(heights).boxed().toList();

        int left = 0;
        int right = list.size() - 1;
        int res = 0;

        while(left < right) {

            int leftCol = list.get(left);
            int rightCol = list.get(right);

            res = Math.max((right - left) * Math.min(leftCol, rightCol), res);

            if(leftCol < rightCol) {
                left++;
            } else {
                right--;
            }
        }

        return res;
    }
}
