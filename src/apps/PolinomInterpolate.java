package apps;
import java.util.Scanner;
import function.inputMatrix;
import utility.menu;
public class PolinomInterpolate {
    
    public static void functionPolinomInterpolate() throws Exception {
        Scanner input = new Scanner(System.in);
        SPLGauss obe1 = new SPLGauss();
        SPLGaussJordan obe2 = new SPLGaussJordan();
        menu.batas();
        System.out.println("PROGRAM INTERPOLASI POLINOM\n");
        menu.batas();
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
            obe1.ForwardOBE(Matrix, MatrixAns);
            obe2.BackwardOBE(Matrix, MatrixAns);
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
            obe1.ForwardOBE(MatrixEq, MatrixAns);
            obe2.BackwardOBE(MatrixEq, MatrixAns);
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
    