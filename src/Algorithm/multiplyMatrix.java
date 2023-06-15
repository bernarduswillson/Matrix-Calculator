package algorithm;

public class multiplyMatrix {
    public static double[] calculate(double[][] mat, double[] matAns) {
        int row = mat.length;
        int col = mat[0].length;
        double[] mOut = new double[row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mOut[i] += mat[i][j] * matAns[j];
            }
        }
        return mOut;
    }

    static double[][] multiplyByConst(double[][] mat, double k) {
        int row = mat.length;
        int col = mat[0].length;
        double[][] mOut = new double[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mOut[i][j] = mat[i][j] * k;
            }
        }
        return mOut;
    }
}
