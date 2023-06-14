package Algorithm;

public class multiplyMatrix {
    public static double[] calculate(double[][] Mat, double[] MatAns) {
        int ROW = Mat.length;
        int COL = Mat[0].length;
        double[] mOut = new double[ROW];
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                mOut[i] += Mat[i][j] * MatAns[j];
            }
        }
        return mOut;
    }
}
