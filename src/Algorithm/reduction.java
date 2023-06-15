package algorithm;

public class reduction {
    public static double calculate(double[][] mat, int row) {
        int[] p = { 0 };
        forwardElimination.calculate(mat, p);

        double determinant = 1;
        for (int i = 0; i < row; i++) {
            determinant *= mat[i][i];
        }
        
        if (p[0] % 2 == 1) {
            determinant *= -1;
        }

        return determinant;
    }
}
