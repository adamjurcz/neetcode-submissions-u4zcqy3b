class Solution {
    public boolean isAnagram(String s, String t) {
        var sSorted = Stream.of(s.split("")).sorted().collect(Collectors.joining());
        var tSorted = Stream.of(t.split("")).sorted().collect(Collectors.joining());

        return tSorted.equals(sSorted);
    }
}
