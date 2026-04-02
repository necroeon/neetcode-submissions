class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length; //only takes how many inner arrays are present (Rows)
        int COLS = matrix[0].length; //only takes the length of the index array (Columns)

        int l = 0, r = ROWS * COLS - 1; //l is first item in array and r is last item in array

        while (l <= r){
            int m = l + (r - l) / 2; //find the middle element index of all existing elements 
            int row = m / COLS, col = m % COLS; //find the middle row and middle column

            if (target > matrix[row][col]){ //if the element in middle is smaller than target, move l forward
                l = m + 1;
            }else if(target < matrix[row][col]){ //if element in middle is greater than target, move r backward
                r = m - 1;
            }else{
                return true; //if already found, return true
            }
        }
        return false;
    }
}
