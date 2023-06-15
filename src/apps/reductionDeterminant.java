package apps;

import cek.reduction;
import utility.*;

public class reductionDeterminant {
    public static void calculate() throws Exception {
        menu.border();
        System.out.println("REDUCTION METHOD FOR DETERMINANT");
        menu.border();

        matrixData matrixData = inputMatrix.inputMatOnly();
        double[][] matrix = matrixData.getMatrix();
        int row = matrix.length;
        int col = matrix[0].length;
        
        if (row != col) {
            System.out.println("Cannot be solved because the matrix is not square!\n");
            menu.backToMenu();
        }

        double determinant = reduction.calculate(matrix, row);
        print.matrixForm(matrix, 1);
        print.determinant(determinant, 2);
    }
}