package apps;
import java.util.*;

import function.inputMatrix;
import utility.*;

public class BicubicInterpolate {
    public static  double[] bicubicinterpolation(double[] matriks) {
        InverseReduct obe = new InverseReduct();
        double [][] matrix2 = new double[16][16];
        int K = 0;
        for (int j= 0; j<4; j++) {
            for (int i=0; i<4; i++) {
                matrix2[0][K]= Math.pow((-1), i) * Math.pow((-1), j); 
                matrix2[1][K] = Math.pow((0), i) * Math.pow((-1), j); 
                matrix2[2][K] = Math.pow((1), i) * Math.pow((-1), j); 
                matrix2[3][K] = Math.pow((2), i) * Math.pow((-1), j);             
                matrix2[4][K]= Math.pow((-1), i) * Math.pow((0), j); 
                matrix2[5][K]= Math.pow((0), i) * Math.pow((0), j); 
                matrix2[6][K]= Math.pow((1), i) * Math.pow((0), j); 
                matrix2[7][K]= Math.pow((2), i) * Math.pow((0), j); 
                matrix2[8][K]= Math.pow((-1), i) * Math.pow((1), j); 
                matrix2[9][K]= Math.pow((0), i) * Math.pow((1), j); 
                matrix2[10][K] = Math.pow((1), i) * Math.pow((1), j); 
                matrix2[11][K] = Math.pow((2), i) * Math.pow((1), j); 
                matrix2[12][K] = Math.pow((-1), i) * Math.pow((2), j); 
                matrix2[13][K] = Math.pow((0), i) * Math.pow((2), j); 
                matrix2[14][K] = Math.pow((1), i) * Math.pow((2), j); 
                matrix2[15][K] = Math.pow((2), i) * Math.pow((2), j);
                K++;
            }
        }
        double[][] IdentityMat = new double[16][16];
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                if (i == j) {
                    IdentityMat[i][j] = 1;
                } else {
                    IdentityMat[i][j] = 0;
                }
            }
        }
        double[] matriksa = new double[16];
        obe.ForwardOBE(matrix2, IdentityMat);
        obe.BackwardOBE(matrix2, IdentityMat);
        matriksa = multiplyMatrix(IdentityMat, matriks);
        return matriksa;
    }
    
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
  
      static void PrintEselon(double[][] Mat, double[][] MatAns) {
        int ROW = Mat.length;
        int COL = Mat[0].length;
        System.out.println("Hasil matriks setelah di-REDUKSI: ");
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                System.out.printf("%.3f\t", Mat[i][j]);
            }
            System.out.print("  |\t");
            for (int j = 0; j < COL; j++) {
                System.out.printf("%.3f\t", MatAns[i][j]);
            }
            System.out.println();
        }
    }

    public static double[] reshape(double[][] matrix, int row) {
        double[] matrixs = new double[row];
        int x = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrixs[x] = matrix[i][j];
                x++;
            }
        }
        return matrixs;
    }
    
    public static void functionBicubicInterpolate() throws Exception{
        Scanner input = new Scanner(System.in);
        menu.batas();
        System.out.println("PROGRAM INTERPOLASI BIKUBIK\n");
        menu.batas(); 
        int choice = inputMatrix.inputMenu();
        if (choice == 1)
        {
            System.out.println("Masukkan elemen matriks (gunakan spasi sebagai pemisah dan enter untuk pindah baris): ");
            double[][] matrix = new double[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    matrix[i][j] = input.nextDouble();
                }
            }
            System.out.println();
            double[] matrixs = new double[16];
            matrixs = reshape(matrix,16);
            double[] matriksa = new double[16];
            matriksa =bicubicinterpolation(matrixs);
            double count = 0;
            System.out.print("Masukan Nilai X: ");
            double x = input.nextDouble();
            System.out.print("Masukan Nilai Y: ");
            double y = input.nextDouble();
            int k = 0;
            for (int i=0;i<4;i++){
                for (int j=0;j<4;j++){
                    count = count + matriksa[k]*Math.pow(x,i)*Math.pow(y,j);
                    k++;
                }
            }
            System.out.println();
            System.out.printf("f("+x+","+y+") = %.3f\n",count);
        }
        else if (choice == 2)
        {
            double[][] Matrix = inputMatrix.readFileBicubic(); 
            double[][] m1 = new double[4][4];
            for (int i = 0; i < 4; i++)
            {
                for (int j = 0; j < 4; j++)
                {
                    m1[i][j] = Matrix[i][j];
                }
            }
            double x = Matrix[4][0];
            double y = Matrix[4][1];

            System.out.println();
            double[] matrixs = new double[16];
            matrixs = reshape(m1,16);
            double[] matriksa = new double[16];
            matriksa = bicubicinterpolation(matrixs);

            double count = 0;
            int k = 0;
            for (int i=0;i<4;i++){
                for (int j=0;j<4;j++){
                    count = count + matriksa[k]*Math.pow(x,i)*Math.pow(y,j);
                    k++;
                }
            }
            System.out.println();
            System.out.printf("f("+x+","+y+") = %.3f\n",count);
        }
        else
        {
            System.out.println("Inputan salah");
        }
        menu.backToMenu();
    }
}
