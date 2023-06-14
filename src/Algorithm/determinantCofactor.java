package Algorithm;

public class determinantCofactor {
    static double calculate(double[][] Mat) {
        int ROW = Mat.length;
        int COL = Mat[0].length;

        if (ROW == 1) {
            return Mat[0][0];
        }

        else {
            double Determinant = 0;
            for (int i = 0; i < ROW; i++) {
                double[][] subMatrix = new double[ROW - 1][COL - 1];
                for (int j = 0; j < ROW - 1; j++) {
                    for (int k = 0; k < COL - 1; k++) {
                        if (k < i) {
                            subMatrix[j][k] = Mat[j + 1][k];
                        } else {
                            subMatrix[j][k] = Mat[j + 1][k + 1];
                        }
                    }
                }
                Determinant += Mat[0][i] * Math.pow(-1, i) * calculate(subMatrix);
            }
            
            return Determinant;
        }
    }
}
