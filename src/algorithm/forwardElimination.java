package algorithm;

public class forwardElimination {
    public static void calculate(double[][] mat, double[] matAns) {
        int row = mat.length;
        int col = mat[0].length;
        double tolerance = 1e-10;

        for (int i = 0; i < row - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < row; j++) {
                if (Math.abs(mat[j][i]) > Math.abs(mat[maxIndex][i])) {
                    maxIndex = j;
                }
            }

            if (Math.abs(mat[maxIndex][i]) < tolerance) {
                continue;
            }

            double[] tempRow = mat[i];
            mat[i] = mat[maxIndex];
            mat[maxIndex] = tempRow;

            double tempAns = matAns[i];
            matAns[i] = matAns[maxIndex];
            matAns[maxIndex] = tempAns;

            for (int k = i + 1; k < row; k++) {
                double ratio = mat[k][i] / mat[i][i];
                matAns[k] -= ratio * matAns[i];
                for (int l = i; l < col; l++) {
                    mat[k][l] -= ratio * mat[i][l];
                }
            }
        }
    }
    
    public static void calculate(double[][] mat, int[] p) {
        int row = mat.length;
        int col = mat[0].length;
        double tolerance = 1e-10;

        for (int i = 0; i < row - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < row; j++) {
                if (Math.abs(mat[j][i]) > Math.abs(mat[maxIndex][i])) {
                    maxIndex = j;
                }
            }

            if (Math.abs(mat[maxIndex][i]) < tolerance) {
                continue;
            }

            double[] tempRow = mat[i];
            mat[i] = mat[maxIndex];
            mat[maxIndex] = tempRow;

            if (i != maxIndex) {
                p[0]++;
            }

            for (int k = i + 1; k < row; k++) {
                double ratio = mat[k][i] / mat[i][i];
                for (int l = i; l < col; l++) {
                    mat[k][l] -= ratio * mat[i][l];
                }
            }
        }
    }

    public static void calculateId(double[][] mat, double[][] matId) {
        int row = mat.length;
        int col = mat[0].length;
        double tolerance = 1e-10;

        for (int i = 0; i < row - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < row; j++) {
                if (Math.abs(mat[j][i]) > Math.abs(mat[maxIndex][i])) {
                    maxIndex = j;
                }
            }

            if (Math.abs(mat[maxIndex][i]) < tolerance) {
                continue;
            }

            double[] tempRow = mat[i];
            mat[i] = mat[maxIndex];
            mat[maxIndex] = tempRow;

            double[] tempRowId = matId[i];
            matId[i] = matId[maxIndex];
            matId[maxIndex] = tempRowId;

            for (int k = i + 1; k < row; k++) {
                double ratio = mat[k][i] / mat[i][i];
                for (int l = i; l < col; l++) {
                    mat[k][l] -= ratio * mat[i][l];
                }
                for (int l = 0; l < col; l++) {
                    matId[k][l] -= ratio * matId[i][l];
                }
            }
        }
    }
}
