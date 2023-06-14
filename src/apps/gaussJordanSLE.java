package Apps;

import java.util.Scanner;

import Algorithm.forwardElimination;
import Algorithm.backwardElimination;
import Algorithm.backSubstitution;

import Utility.*;

public class gaussJordanSLE {
    public static void calculate() throws Exception {
        double matrix[][] = new double[0][0];
        double matrixAns[] = new double[0];
        Scanner input = new Scanner(System.in);
        int choice = inputMatrix.inputMenu();
        int ROW = 0;
        int COL = 0;

        menu.border();
        System.out.println("GAUSS-JORDAN ELIMINATION METHOD");
        menu.border();

        if (choice == 1) {
            System.out.print("Insert the size of the matrix (ROW COL): ");
            ROW = input.nextInt();
            COL = input.nextInt();
            System.out.println();

            System.out
                    .println(
                            "Insert the elements of the matrix (use space as separator and enter to move to next row): ");
            for (int i = 0; i < ROW; i++)
                for (int j = 0; j < COL; j++)
                    matrix[i][j] = input.nextDouble();
            System.out.println();

            System.out.println(
                    "Insert the elements of the matrix answer (use space as separator and enter to move to next row): ");
            for (int i = 0; i < ROW; i++)
                matrixAns[i] = input.nextDouble();
            System.out.println();

        } else if (choice == 2) {
            double[][] matrixFile = inputMatrix.readFile();
            ROW = matrixFile.length;
            COL = matrixFile[0].length;
            matrix = inputMatrix.convertMatrix(matrixFile, ROW, COL);
            matrixAns = inputMatrix.convertMatrixAns(matrixFile, ROW, COL);
        }

        forwardElimination.calculate(matrix, matrixAns);
        backwardElimination.calculate(matrix, matrixAns);
        print.echelonForm(matrix, matrixAns, 2);
        double[] solution = backSubstitution.calculate(matrix, matrixAns);
        print.solution(solution, 2);

        menu.backToMenu();
        // input.close();
    }
}