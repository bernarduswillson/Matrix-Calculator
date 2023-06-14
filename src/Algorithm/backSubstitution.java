package algorithm;

import utility.menu;

public class backSubstitution {
    public static double[] calculate(double[][] mat, double[] matAns) throws Exception {
        int ROW = mat.length;
        int COL = mat[0].length;
        double[] solution = new double[ROW];
        double tolerance = 1e-8;
        if (Math.abs(mat[ROW - 1][COL - 1]) < tolerance || Math.abs(mat[ROW - 1][COL - 2]) >= tolerance) {
            System.out.println("No Solution!");
            System.out.println();
            menu.backToMenu();
        }
        for (int i = ROW - 1; i >= 0; i--) {
            solution[i] = matAns[i];
            for (int j = i + 1; j < COL; j++) {
                solution[i] -= mat[i][j] * solution[j];
            }
            solution[i] /= mat[i][i];
        }
        return solution;
    }
}
