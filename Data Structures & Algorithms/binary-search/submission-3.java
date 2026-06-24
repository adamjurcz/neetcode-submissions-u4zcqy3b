class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int i = (right + left) / 2;

            if (nums[i] == target) {
                return i;
            }
            if(nums[i] < target) {
                left = i + 1;
            }
            if(nums[i] > target) {
                right = i - 1;
            }
        }

        return -1;
    }
}
