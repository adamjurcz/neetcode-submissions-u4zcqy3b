class Solution {
    public int[] twoSum(int[] nums, int target) {
        var valueToInd = new HashMap<Integer, Integer>(); 

        for(int i = 0; i < nums.length; i++) {
            var diff = target - nums[i];
            if(valueToInd.containsKey(diff)) {
                return new int[]{valueToInd.get(diff), i};
            } else {
                if(!valueToInd.containsKey(nums[i])) {
                    valueToInd.put(nums[i], i);
                }
            }
        }
        return null;
    }
}
