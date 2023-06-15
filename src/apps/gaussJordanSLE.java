package apps;

import cek.backSubstitution;
import cek.backwardElimination;
import cek.forwardElimination;
import utility.*;

public class gaussJordanSLE {
    public static void calculate() throws Exception {
        menu.border();
        System.out.println("GAUSS-JORDAN ELIMINATION METHOD");
        menu.border();

        matrixData matrixData = inputMatrix.inputMat();
        double[][] matrix = matrixData.getMatrix();
        double[] matrixAns = matrixData.getMatrixAns();

        forwardElimination.calculate(matrix, matrixAns);
        backwardElimination.calculate(matrix, matrixAns);
        print.echelonForm(matrix, matrixAns, 2);
        double[] solution = backSubstitution.calculate(matrix, matrixAns);
        print.solution(solution, 2);
    }
}