class Solution {
    public int characterReplacement(String s, int k) {
        var characters = s.chars().toArray();
        Map<Integer, Integer> charToOccurence = new HashMap<>();

        int left = 0;
        int maxLen = 0;

        for(int right = 0; right < characters.length; right++) {
            var charCode = characters[right];
            charToOccurence.put(charCode, charToOccurence.getOrDefault(charCode, 0) + 1);

            while(k < right - left + 1 - getHighestOccurence(charToOccurence)) {
                var prevCharCode = characters[left];
                charToOccurence.put(prevCharCode, charToOccurence.getOrDefault(prevCharCode, 0) - 1);
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    private int getHighestOccurence(Map<Integer, Integer> map) {
        return map.values().stream().max(Integer::compareTo).orElse(0);
    }
}
