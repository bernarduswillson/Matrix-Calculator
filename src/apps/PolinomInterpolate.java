package apps;

import java.util.Scanner;

import algorithm.backwardElimination;
import algorithm.forwardElimination;
import algorithm.backSubstitution;
import utility.*;

public class polinomInterpolate {
    public static void calculate() throws Exception {
        menu.border();
        System.out.println("POLINOMIAL INTERPOLATION");
        menu.border();

        Scanner input = new Scanner(System.in);
        int choice = inputMatrix.inputMenu();
        double[][] matrix = new double[0][0];
        double[] matrixAns = new double[0];
        int row = 0;
        int col = 0;

        if (choice == 1) {
            System.out.print("Insert the number of data points:");
            row = input.nextInt();
            col = row;
            System.out.println();
            matrix = new double[row][col];
            matrixAns = new double[row];
            double[] X = new double[row];
            double[] Y = new double[row];

            for (int i = 0; i < row; i++) {
                System.out.print("Insert X" + (i + 1) + " coordinate: ");
                X[i] = input.nextDouble();
                System.out.print("Insert Y" + (i + 1) + " coordinate: ");
                Y[i] = input.nextDouble();
            }
            System.out.println();

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < row; j++) {
                    matrix[i][j] = Math.pow(X[i], j);
                }
                matrixAns[i] = Y[i];
            }
            System.out.println();

        } else if (choice == 2) {
            double[][] matrixFile = inputMatrix.readFile();
            row = matrixFile.length;
            col = matrixFile[0].length;
            matrix = inputMatrix.convertMatrix(matrixFile, row, col);
            matrixAns = inputMatrix.convertMatrixAns(matrixFile, row, col);

            col--;
        }

        if (row != col) {
            System.out.println("Cannot be solved because the matrix is not square!\n");
            menu.backToMenu();
        }

        System.out.print("Insert the value of X to be estimated: ");
        double x = input.nextDouble();
        forwardElimination.calculate(matrix, matrixAns);
        backwardElimination.calculate(matrix, matrixAns);
        print.echelonForm(matrix, matrixAns, 2);
        double[] solution = backSubstitution.calculate(matrix, matrixAns);
        print.solution(solution, 5);

        double sum = 0;
        for (int i = 0; i < row; i++) {
            sum += matrixAns[i] * Math.pow(x, i);
        }
        System.out.printf("P(" + x + ") = %.4f\n", sum);
        System.out.println();

        menu.backToMenu();
    }
}
