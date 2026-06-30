class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < len; i++) {            
            int left = i + 1;
            int right = len - 1;
            int target = nums[i];

            if(i > 0 && target == nums[i - 1]) {
                continue;
            }

            while(left < right) {
                int sum = nums[left] + nums[right] + target;

                if(sum < 0) {
                    left++;
                } else if(sum > 0) {
                    right--;
                } else {
                    List<Integer> trio = List.of(target, nums[left], nums[right]);
                    result.add(trio);
                    left++;

                    while(left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }
        return result;
    }


}
