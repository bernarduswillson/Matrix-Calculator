package cek;

public class backwardElimination {
    public static void calculate(double[][] mat, double[] matAns) {
        int row = mat.length;
        double tolerance = 1e-8;

        for (int i = row - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                double divisor = mat[i][i];
                if (Math.abs(divisor) < tolerance) {
                    continue;
                }

                double Const = mat[j][i] / divisor;
                matAns[j] -= Const * matAns[i];
                
                for (int k = i; k >= 0; k--) {
                    mat[j][k] -= Const * mat[i][k];
                }
            }
        }
    }
}
