class Solution {
    public int[] productExceptSelf(int[] nums) {
        var prefix = new int[nums.length];
        var suffix = new int[nums.length];
        var result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                prefix[0] = nums[0];
                suffix[nums.length - 1] = nums[nums.length - 1];
            } else {
                prefix[i] = prefix[i - 1] * nums[i];
                suffix[nums.length - 1 - i] = suffix[nums.length - i] * nums[nums.length - 1 - i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[i] = suffix[i + 1];
            } else if (i == nums.length - 1) {
                result[i] = prefix[i - 1];
            } else {
                result[i] = prefix[i - 1] * suffix[i + 1];
            }
        }

        return result;
    }
}
