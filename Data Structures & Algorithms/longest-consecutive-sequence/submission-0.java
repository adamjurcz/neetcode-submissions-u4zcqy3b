class Solution {
    public int longestConsecutive(int[] nums) {
        var numsSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        var maxLength = 0;

        for(int n = 0; n < nums.length; n++) {
            if(!numsSet.contains(nums[n] - 1)) {
                var length = 0;
                while(numsSet.contains(nums[n] + length)) {
                    length += 1;
                }
                maxLength = Math.max(length, maxLength);
            }
        }
        return maxLength;
    }
}
