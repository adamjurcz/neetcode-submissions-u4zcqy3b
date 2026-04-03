class Solution {
    public boolean isAnagram(String s, String t) {
        var firstMap = new HashMap<Character, Integer>();
        var secondMap = new HashMap<Character, Integer>();

        if(s.length() != t.length()) {
            return false;
        }

        for(int i = 0; i < s.length(); i++) {
            firstMap.putIfAbsent(s.charAt(i), 0);
            secondMap.putIfAbsent(t.charAt(i), 0);

            firstMap.merge(s.charAt(i), 1, Integer::sum);
            secondMap.merge(t.charAt(i), 1, Integer::sum);
        }

        System.out.println(firstMap);
        System.out.println(secondMap);

        return firstMap.size() == secondMap.size() &&
                firstMap.entrySet().stream().allMatch(entry -> {
                    return entry.getValue().equals(secondMap.getOrDefault(entry.getKey(), 0));
                });
        
    }
}
