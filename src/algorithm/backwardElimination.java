package algorithm;

public class backwardElimination {
    public static void calculate(double[][] mat, double[] matAns) {
        int row = mat.length;
        int col = mat[0].length;
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

        boolean solution = true;
        if (Math.abs(mat[row - 1][col - 1]) < tolerance) {
            solution = false;
        }
        for (int i = 0; i < col - 1; i++) {
            if (Math.abs(mat[row - 1][i]) >= tolerance) {
                solution = false;
                break;
            }
        }

        if (solution) {
            for (int i = 0; i < row; i++) {
                matAns[i] = matAns[i] / mat[i][i];
                mat[i][i] = 1;
            }
        }
    }

    public static void calculateId(double[][] mat, double[][] matId) {
        int row = mat.length;
        int col = mat[0].length;
        double tolerance = 1e-8;

        for (int i = row - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                double divisor = mat[i][i];
                if (Math.abs(divisor) < tolerance) {
                    continue;
                }

                double Const = mat[j][i] / divisor;

                for (int k = 0; k < col; k++) {
                    matId[j][k] -= Const * matId[i][k];
                }
                for (int k = i; k >= 0; k--) {
                    mat[j][k] -= Const * mat[i][k];
                }
            }
        }

        boolean solution = true;
        if (Math.abs(mat[row - 1][col - 1]) < tolerance) {
            solution = false;
        }
        for (int i = 0; i < col - 1; i++) {
            if (Math.abs(mat[row - 1][i]) >= tolerance) {
                solution = false;
                break;
            }
        }

        if (solution) {
            for (int i = 0; i < row; i++) {
                double divisor = mat[i][i];
                mat[i][i] = 1;
                for (int j = 0; j < col; j++) {
                    matId[i][j] /= divisor;
                }
            }
        }
    }
}