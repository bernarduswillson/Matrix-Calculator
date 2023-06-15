package apps;

import cek.cofactorExpansion;
import utility.*;

public class crammerSLE{
    public static void calculate() throws Exception {
        menu.border();
        System.out.println("CRAMMER'S RULE METHOD");
        menu.border();

        matrixData matrixData = inputMatrix.inputMat();
        double[][] matrix = matrixData.getMatrix();
        double[] matrixAns = matrixData.getMatrixAns();
        int row = matrix.length;
        int col = matrix[0].length;
        
        if (row != col) {
            System.out.println("Cannot be solved because the matrix is not square!\n");
            menu.backToMenu();
        }
        else if (cofactorExpansion.calculate(matrix) == 0) {
            System.out.println("Cannot be solved because the determinant is 0!\n");
            menu.backToMenu();
        }

        double[][] subMatrix = new double[row][col];
        double determinant = cofactorExpansion.calculate(matrix);
        double[] solution = new double[row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    if (k == i) {
                        subMatrix[j][k] = matrixAns[j];
                    } else {
                        subMatrix[j][k] = matrix[j][k];
                    }
                }
            }
            solution[i] = cofactorExpansion.calculate(subMatrix) / determinant;
        }
        
        print.solution(solution, 4);
    }
}