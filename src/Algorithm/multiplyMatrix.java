package algorithm;

public class multiplyMatrix {
    public static double[] calculate(double[][] mat, double[] matAns) {
        int ROW = mat.length;
        int COL = mat[0].length;
        double[] mOut = new double[ROW];
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                mOut[i] += mat[i][j] * matAns[j];
            }
        }
        return mOut;
    }
}
