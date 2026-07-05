class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Integer> charactersChain = new HashSet<Integer>();
        int longestSequence = 0;

        int[] chars = s.chars().toArray();
        int left = 0;

        for (int right = 0; right < chars.length; right++) {
            var charCode = chars[right];

            while(charactersChain.contains(charCode)) {
                charactersChain.remove(chars[left]);
                left++;
            }

            int seq = right - left + 1;
            longestSequence = Math.max(longestSequence, seq);

            charactersChain.add(chars[right]);
        }

        return longestSequence;
    }
}
