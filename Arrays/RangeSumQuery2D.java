class NumMatrix {
    int [][] prefixMatrix;
    int [][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        prefixMatrix = new int[matrix.length][matrix[0].length];
        calculate(matrix, prefixMatrix);
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total = prefixMatrix[row2][col2];

        int top = (row1 > 0) ? prefixMatrix[row1 - 1][col2] : 0;
        int left = (col1 > 0) ? prefixMatrix[row2][col1 - 1] : 0;
        int overlap = (row1 > 0 && col1 > 0) ? prefixMatrix[row1 - 1][col1 - 1] : 0;

        return total - top - left + overlap;
    }

    public void calculate(int[][] matrix, int[][] ps){
        ps[0][0] = matrix[0][0];

        for (int j = 1; j < matrix[0].length; j++) {
            ps[0][j] = matrix[0][j] + ps[0][j - 1];
        }

        for (int i = 1; i < matrix.length; i++) {
            ps[i][0] = matrix[i][0] + ps[i - 1][0];
        }

        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                ps[i][j] = matrix[i][j] + ps[i-1][j] + ps[i][j-1] - ps[i-1][j-1];
            }
        }
    }
}
