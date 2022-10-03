package apps;
import java.util.*;
import utility.*;
import function.*;
public class SPLInverse {
    static double[] multiplyMatrix(double[][] Mat, double[] MatAns) {
        int ROW = Mat.length;
        int COL = Mat[0].length;
        double[] mOut = new double[ROW];
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                mOut[i] += Mat[i][j] * MatAns[j];
            }
        }
        return mOut;
    }

    public static void functionSPLInverse() throws Exception {
        Scanner input = new Scanner(System.in);
        InverseAdj inv = new InverseAdj();
        menu.batas();
        System.out.println("PROGRAM SPL INVERS\n");
        menu.batas();
        int choice = inputMatrix.inputMenu();
        if (choice == 1)
        {
            System.out.println("Masukkan ukuran matriks baris X kolom (gunakan spasi sebagai pemisah): ");
            int ROW = input.nextInt();
            int COL = input.nextInt();
            System.out.println();
            double[][] Matrix = new double[ROW][COL];
            double[] MatrixAns = new double[ROW];
            if (ROW != COL) {
                System.out.println("Tidak dapat diperoleh penyelesaian karena bukan matriks persegi!\n");
            }
            else {
                System.out.println("Masukkan elemen matriks (gunakan spasi sebagai pemisah dan enter untuk pindah baris): ");
                for (int i = 0; i < ROW; i++) {
                    for (int j = 0; j < COL; j++) {
                        Matrix[i][j] = input.nextDouble();
                    }
                }
                System.out.println();
                System.out.println("Masukkan matriks hasil (gunakan enter untuk pindah baris): ");
                for (int i = 0; i < ROW; i++) {
                    MatrixAns[i] = input.nextDouble();
                }
                System.out.println();
                double[] MatrixOut = multiplyMatrix(inv.Inverse(Matrix), MatrixAns);
                System.out.println("Solusi SPL dengan metode INVERS: ");
                for (int i = 0; i < ROW; i++) {
                    System.out.printf("X"+(i+1)+" = %.4f\n", MatrixOut[i]);
                }
            }
        }
        else if (choice == 2)
        {
            double[][] Matrix = inputMatrix.readFile();
            int ROW = Matrix.length;
            int COL = Matrix[0].length;
            if (ROW != (COL - 1)) 
            {
                System.out.println("Tidak dapat diperoleh penyelesaian karena bukan matriks persegi!\n");
            }
            else
            {
                double[][] MatrixEq = Regression.seperateMatrix(Matrix, ROW, COL);
                double[] MatrixAns = Regression.seperateMatrix1(Matrix, ROW, COL);
                double[] MatrixOut = multiplyMatrix(inv.Inverse(MatrixEq), MatrixAns);
                System.out.println("Solusi SPL dengan metode INVERS: ");
                for (int i = 0; i < ROW; i++) {
                    System.out.printf("X"+(i+1)+" = %.4f\n", MatrixOut[i]);
                }
            }
            
        }
    }
}