class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowInd = findRowIndex(matrix, target);
        if(rowInd == -1) {
            return false;
        }

        int x = matrix[0].length;
        int left = 0;
        int right = x - 1;


        while (left <= right) {
            int mid = (left + right) / 2;

            if (target < matrix[rowInd][mid]) {
                right = mid - 1;
            }
            else if (target > matrix[rowInd][mid]) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }

    private int findRowIndex(int[][] matrix, int target) {
        int y = matrix.length;
        int left = 0;
        int right = y - 1;

        int x = matrix[0].length;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (target < matrix[mid][0]) {
                right = mid - 1;
            }
            else if (target > matrix[mid][x - 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
