package Apps;

import java.util.Scanner;

import Algorithm.forwardElimination;
import Algorithm.backwardElimination;
import Utility.inputMatrix;
import Utility.menu;
public class PolinomInterpolate {
    
    public static void functionPolinomInterpolate() throws Exception {
        Scanner input = new Scanner(System.in);
        gaussSLE obe1 = new gaussSLE();
        gaussJordanSLE obe2 = new gaussJordanSLE();
        menu.border();
        System.out.println("PROGRAM INTERPOLASI POLINOM\n");
        menu.border();
        int choice = inputMatrix.inputMenu();
        if (choice == 1)
        {
            System.out.print("Masukkan jumlah titik: ");
            int N = input.nextInt();
            System.out.println();
            double[][] Matrix = new double[N][N];
            double[] MatrixAns = new double[N];
            double[] X = new double[N];
            double[] Y = new double[N];
            for (int i = 0; i < N; i++) {
                System.out.print("Masukkan nilai X"+(i+1)+": ");
                X[i] = input.nextDouble();
                System.out.print("Masukkan nilai Y"+(i+1)+": ");
                Y[i] = input.nextDouble();
            }
            System.out.println();
            System.out.print("Masukkan nilai X yang akan ditaksir: ");
            double x = input.nextDouble();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    Matrix[i][j] = Math.pow(X[i], j);
                }
                MatrixAns[i] = Y[i];
            }
            System.out.println();
            forwardElimination.calculate(Matrix, MatrixAns);
            backwardElimination.calculate(Matrix, MatrixAns);
            System.out.println();
            double Sum = 0;
            for (int i = 0; i < N; i++) {
                Sum += MatrixAns[i] * Math.pow(x, i);
            }
            System.out.printf("P("+x+") = %.4f",Sum);
        }
        else if (choice == 2)
        {
            double[][] Matrix = inputMatrix.readFile();
            int ROW = Matrix.length;
            int COL = Matrix[0].length;
            double[][] MatrixEq = Regression.seperateMatrix(Matrix, ROW, COL);
            double[] MatrixAns = Regression.seperateMatrix1(Matrix, ROW, COL);
            System.out.print("Masukkan nilai X yang akan ditaksir: ");
            double x = input.nextDouble();
            System.out.println();
            forwardElimination.calculate(Matrix, MatrixAns);
            backwardElimination.calculate(Matrix, MatrixAns);
            System.out.println();
            double Sum = 0;
            for (int i = 0; i < Matrix.length; i++) {
                Sum += MatrixAns[i] * Math.pow(x, i);
            }
            System.out.printf("P("+x+") = %.4f",Sum);
        }
        else
        {
            System.out.println("Input tidak valid!");
        }
        menu.backToMenu();
    }
}
    