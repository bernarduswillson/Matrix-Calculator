package algorithm;

public class determinantCofactor {
    public static double calculate(double[][] mat) {
        int ROW = mat.length;
        int COL = mat[0].length;

        if (ROW == 1) {
            return mat[0][0];
        }

        else {
            double Determinant = 0;
            for (int i = 0; i < ROW; i++) {
                double[][] submatrix = new double[ROW - 1][COL - 1];
                for (int j = 0; j < ROW - 1; j++) {
                    for (int k = 0; k < COL - 1; k++) {
                        if (k < i) {
                            submatrix[j][k] = mat[j + 1][k];
                        } else {
                            submatrix[j][k] = mat[j + 1][k + 1];
                        }
                    }
                }
                Determinant += mat[0][i] * Math.pow(-1, i) * calculate(submatrix);
            }
            
            return Determinant;
        }
    }
}
