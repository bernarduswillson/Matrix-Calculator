package algorithm;

public class forwardElimination {
    public static void calculate(double[][] mat, double[] matAns) {
        int ROW = mat.length;
        int COL = mat[0].length;
        double tolerance = 1e-10;
        
        for (int i = 0; i < ROW - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < ROW; j++) {
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

            for (int k = i + 1; k < ROW; k++) {
                double ratio = mat[k][i] / mat[i][i];
                matAns[k] -= ratio * matAns[i];
                for (int l = i; l < COL; l++) {
                    mat[k][l] -= ratio * mat[i][l];
                }
            }
        }
    }
}
