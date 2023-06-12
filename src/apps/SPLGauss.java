package apps;

import java.util.Scanner;
import function.inputMatrix;
import utility.*;

public class SPLGauss {
    static void forwardElimination(double[][] Mat, double[] MatAns) {
        int ROW = Mat.length;
        int COL = Mat[0].length;
        for (int i = 0; i < ROW - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < ROW; j++) {
                if (Math.abs(Mat[j][i]) > Math.abs(Mat[maxIndex][i])) {
                    maxIndex = j;
                }
            }
            // Swap rows in Mat and MatAns
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

    static double[] backSubstitution(double[][] Mat, double[] MatAns) throws Exception {
        int ROW = Mat.length;
        int COL = Mat[0].length;
        double[] solution = new double[ROW];
        double tolerance = 1e-10;
        for (int i = 0; i < ROW; i++) {
            int count = 0;
            for (int j = 0; j < COL; j++) {
                if (Math.abs(Mat[i][j]) < tolerance) {
                    count++;
                    if (count == COL) {
                        System.out.println("No Solution!");
                        menu.backToMenu();
                    }
                }
            }
        }
        for (int i = ROW - 1; i >= 0; i--) {
            solution[i] = MatAns[i];
            for (int j = i + 1; j < COL; j++) {
                solution[i] -= Mat[i][j] * solution[j];
            }
            solution[i] /= Mat[i][i];
        }
        return solution;
    }

    static void printEchelonForm(double[][] Mat, double[] MatAns) {
        int ROW = Mat.length;
        int COL = Mat[0].length;
        System.out.println("Matrix in Echelon Form using GAUSS: ");
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                System.out.printf("%.3f\t", Mat[i][j]);
            }
            System.out.printf("  |\t%.3f\n", MatAns[i]);
        }
        System.out.println();
    }

    static void printSolution(double[] solution) {
        int ROW = solution.length;
        System.out.println("Solution using GAUSS:");
        for (int i = 0; i < ROW; i++) {
            System.out.printf("X%d = %.4f\n", (i + 1), solution[i]);
        }
        System.out.println();
    }

    public static void functionSPLGauss() throws Exception {
        Scanner input = new Scanner(System.in);
        menu.border();
        System.out.println("GAUSS ELIMINATION METHOD");
        menu.border();
        int choice = inputMatrix.inputMenu();
        if (choice == 1) {
            System.out.print("Insert the size of the matrix (ROW COL): ");
            int ROW = input.nextInt();
            int COL = input.nextInt();
            System.out.println();
            double[][] Matrix = new double[ROW][COL];
            double[] MatrixAns = new double[ROW];
            System.out
                    .println("Insert the elements of the matrix (use space as separator and enter to move to next row): ");
            for (int i = 0; i < ROW; i++)
                for (int j = 0; j < COL; j++)
                    Matrix[i][j] = input.nextDouble();
            System.out.println();
            System.out.println(
                    "Insert the elements of the matrix answer (use space as separator and enter to move to next row): ");
            for (int i = 0; i < ROW; i++)
                MatrixAns[i] = input.nextDouble();
            System.out.println();
            forwardElimination(Matrix, MatrixAns);
            printEchelonForm(Matrix, MatrixAns);
            double[] solution = backSubstitution(Matrix, MatrixAns);
            printSolution(solution);
        } else if (choice == 2) {
            double[][] Matrix = inputMatrix.readFile();
            int ROW = Matrix.length;
            int COL = Matrix[0].length;
            if (ROW != (COL - 1)) {
                System.out.println("Matrix is not a square matrix, please try again!");
            } else {
                double[][] MatrixEq = Regression.seperateMatrix(Matrix, ROW, COL);
                double[] MatrixAns = Regression.seperateMatrix1(Matrix, ROW, COL);
                forwardElimination(MatrixEq, MatrixAns);
                printEchelonForm(MatrixEq, MatrixAns);
                double[] solution = backSubstitution(Matrix, MatrixAns);
                printSolution(solution);
            }
        }
        menu.backToMenu();
        input.close();
    }
}