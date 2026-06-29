class MinStack {
    private final List<Integer> stackStructure;
    private final List<Integer> sortedValues;

    public MinStack() {
        stackStructure = new ArrayList<Integer>();
        sortedValues = new ArrayList<Integer>();
    }

    public void push(int val) {
        Integer smallestValue = val;
        if (stackStructure.size() > 0) {
            int lastElementInd = stackStructure.size() - 1;
            Integer prevSmallestValue = sortedValues.get(lastElementInd);

            if (val > prevSmallestValue) {
                smallestValue = prevSmallestValue;
            }
        }

        stackStructure.add(Integer.valueOf(val));
        sortedValues.add(smallestValue);
    }

    public void pop() {
        int lastElementInd = stackStructure.size() - 1;
        stackStructure.remove(lastElementInd);
        sortedValues.remove(lastElementInd);
    }

    public int top() {
        int lastElementInd = stackStructure.size() - 1;
        return stackStructure.get(lastElementInd);
    }

    public int getMin() {
        int lastElementInd = stackStructure.size() - 1;

        return sortedValues.get(lastElementInd);
    }
}
