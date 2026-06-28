class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();

        int resultSpeed = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if(isEnoughSpeed(piles, mid, h)) {
                resultSpeed = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return resultSpeed;
    }

    private boolean isEnoughSpeed(int[] piles, int speed, int h) {
        int allocatedHours = 0;

        for(int i = 0; i < piles.length; i++) {
            int hours = (piles[i] + speed - 1) / speed;
            allocatedHours+=hours;

            if(allocatedHours > h) {
                return false;
            }
        }

        return true;
    }
}
