package Algorithm;

public class forwardElimination {
    public static void calculate(double[][] Mat, double[] MatAns) {
        int ROW = Mat.length;
        int COL = Mat[0].length;
        double tolerance = 1e-10;
        
        for (int i = 0; i < ROW - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < ROW; j++) {
                if (Math.abs(Mat[j][i]) > Math.abs(Mat[maxIndex][i])) {
                    maxIndex = j;
                }
            }

            if (Math.abs(Mat[maxIndex][i]) < tolerance) {
                continue;
            }

            double[] tempRow = Mat[i];
            Mat[i] = Mat[maxIndex];
            Mat[maxIndex] = tempRow;

            double tempAns = MatAns[i];
            MatAns[i] = MatAns[maxIndex];
            MatAns[maxIndex] = tempAns;

            for (int k = i + 1; k < ROW; k++) {
                double ratio = Mat[k][i] / Mat[i][i];
                MatAns[k] -= ratio * MatAns[i];
                for (int l = i; l < COL; l++) {
                    Mat[k][l] -= ratio * Mat[i][l];
                }
            }
        }
    }
}
