class TimeMap {
    private final Map<String, List<TimedValue>> store;

    public TimeMap() {
        store = new HashMap<String, List<TimedValue>>();
    }

    public void set(String key, String value, int timestamp) {
        store.computeIfAbsent(key, k -> new ArrayList()).add(new TimedValue(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (store.get(key) == null) {
            return "";
        }

        var timedValueList = store.get(key);
        int left = 0;
        int right = timedValueList.size() - 1;
        String highestValue = "";

        while(left <= right) {
            int mid = (left + right) / 2;
            var midItem = timedValueList.get(mid);

            if(timestamp < midItem.timestamp()) {
                right = mid - 1;
            } else if (timestamp > midItem.timestamp()) {
                highestValue = midItem.value();
                left = mid + 1;
            } else {
                return midItem.value();
            }
        }

        return highestValue;
    }

    private record TimedValue(Integer timestamp, String value) {}
}
