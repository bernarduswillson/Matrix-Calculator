package Algorithm;

public class backwardElimination {
    public static void calculate(double[][] Mat, double[] MatAns) {
        int ROW = Mat.length;
        double tolerance = 1e-8;

        for (int i = ROW - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                double divisor = Mat[i][i];
                if (Math.abs(divisor) < tolerance) {
                    continue;
                }

                double Const = Mat[j][i] / divisor;
                MatAns[j] -= Const * MatAns[i];
                
                for (int k = i; k >= 0; k--) {
                    Mat[j][k] -= Const * Mat[i][k];
                }
            }
        }
    }
}
