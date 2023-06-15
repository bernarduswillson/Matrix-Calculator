package algorithm;

public class cofactorExpansion {
    public static double calculate(double[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        if (row == 1) {
            return mat[0][0];
        }

        else {
            double determinant = 0;
            for (int i = 0; i < row; i++) {
                double[][] submatrix = new double[row - 1][col - 1];
                for (int j = 0; j < row - 1; j++) {
                    for (int k = 0; k < col - 1; k++) {
                        if (k < i) {
                            submatrix[j][k] = mat[j + 1][k];
                        } else {
                            submatrix[j][k] = mat[j + 1][k + 1];
                        }
                    }
                }
                determinant += mat[0][i] * Math.pow(-1, i) * calculate(submatrix);
            }
            
            return determinant;
        }
    }
}
