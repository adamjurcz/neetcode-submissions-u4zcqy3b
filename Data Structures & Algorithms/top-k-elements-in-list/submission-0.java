class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var numToOccurences = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++) {
            numToOccurences.putIfAbsent(nums[i], 0);
            numToOccurences.merge(nums[i], 1, Integer::sum);
        }

        return numToOccurences.entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .mapToInt(entry -> entry.getKey())
        .limit(k)
        .toArray();
    }
}
