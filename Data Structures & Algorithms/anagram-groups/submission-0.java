class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var sortedToString = new HashMap<String, List<String>>();

        for(int i = 0; i < strs.length; i++) {
            String sorted = Stream.of(strs[i].split("")).sorted().collect(Collectors.joining());

            sortedToString.computeIfAbsent(sorted, k -> new ArrayList<String>()).add(strs[i]);
        }

        return sortedToString.values().stream().toList();
    }
}
