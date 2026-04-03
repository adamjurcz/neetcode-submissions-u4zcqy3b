class Solution {
    public boolean hasDuplicate(int[] nums) {
        var set = Arrays.stream(nums)
        .boxed()
        .collect(Collectors.toCollection(HashSet::new));
        
        return set.size() < nums.length;
    }
}