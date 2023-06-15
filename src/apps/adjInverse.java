package apps;

import algorithm.adjointInverse;
import utility.*;

public class adjInverse{
    public static void calculate() throws Exception {
        menu.border();
        System.out.println("ADJOINT INVERSE METHOD");
        menu.border();
        
        matrixData matrixData = inputMatrix.inputMatOnly();
        double[][] matrix = matrixData.getMatrix();
        int row = matrix.length;
        int col = matrix[0].length;
        
        if (row != col) {
            System.out.println("Cannot be solved because the matrix is not square!\n");
            menu.backToMenu();
        }

        double invMatrix[][] = adjointInverse.calculate(matrix);
        print.matrixForm(invMatrix, 2);
    }
}