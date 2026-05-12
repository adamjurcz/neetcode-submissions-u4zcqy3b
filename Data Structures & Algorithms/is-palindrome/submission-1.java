class Solution {
    public boolean isPalindrome(String s) {
        var preparedString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        return IntStream.range(0, preparedString.length() / 2)
        .allMatch(n -> preparedString.charAt(n) == preparedString.charAt(preparedString.length() - 1 - n));
    }
}
