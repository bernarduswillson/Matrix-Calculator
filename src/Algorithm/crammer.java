package algorithm;

import utility.menu;

public class crammer {
    static void calculate(double[][] mat, double[] matAns) throws Exception {
        int ROW = mat.length;
        int COL = mat[0].length;
        double[][] submatrix = new double[ROW][COL];
        double determinant = determinantCofactor.calculate(mat);
        if (ROW != COL) {
            System.out.println("Cannot be solved because the matrix is not square!\n");
            menu.backToMenu();
        }
        else if (determinantCofactor.calculate(mat) == 0) {
            System.out.println("Cannot be solved because the determinant is 0!\n");
            menu.backToMenu();
        }
        else {
            for (int i = 0; i < ROW; i++) {
                for (int j = 0; j < ROW; j++) {
                    for (int k = 0; k < COL; k++) {
                        if (k == i) {
                            submatrix[j][k] = matAns[j];
                        }
                        else {
                        submatrix[j][k] = mat[j][k];
                        }
                    }                  
                }
            System.out.printf("X"+(i+1)+" = %.4f\n", (determinantCofactor.calculate(submatrix)/determinant));
            }
        }
    }
}
