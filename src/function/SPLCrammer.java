import java.util.Scanner;
public class SPLCrammer{
    static double Determinant(double[][] Mat) {
        int ROW = Mat.length;
        int COL = Mat[0].length;
        if (ROW == 1) {
            return Mat[0][0];
        }
        else {
            double Determinant = 0;
            for (int i = 0; i < ROW; i++) {
                double[][] subMatrix = new double[ROW-1][COL-1];
                for (int j = 0; j < ROW-1; j++) {
                    for (int k = 0; k < COL-1; k++) {
                        if (k < i) {
                            subMatrix[j][k] = Mat[j+1][k];
                        }
                        else {
                            subMatrix[j][k] = Mat[j+1][k+1];
                        }
                    }
                }
                Determinant += Mat[0][i]*Math.pow(-1,i)*Determinant(subMatrix);
            }
        return Determinant;
        }  
    }

    static void Crammer(double[][] Mat, double[] MatAns) {
        int ROW = Mat.length;
        int COL = Mat[0].length;
        double[][] subMatrix = new double[ROW][COL];
        double Determinant = Determinant(Mat);
        if (ROW != COL) {
            System.out.println("Tidak dapat diperoleh penyelesaian karena bukan matriks persegi!\n");
        }
        else if (Determinant(Mat) == 0) {
            System.out.println("Tidak dapat diperoleh penyelesaian karena determinannya 0!");
            System.exit(0);
        }
        else {
            System.out.println("Solusi SPL dengan metode CRAMMER: ");
            for (int i = 0; i < ROW; i++) {
                for (int j = 0; j < ROW; j++) {
                    for (int k = 0; k < COL; k++) {
                        if (k == i) {
                            subMatrix[j][k] = MatAns[j];
                        }
                        else {
                        subMatrix[j][k] = Mat[j][k];
                        }
                    }                  
                }
            System.out.printf("X"+(i+1)+" = %.3f\n", (Determinant(subMatrix)/Determinant));
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("PROGRAM SPL CRAMMER\n");
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
            for (int i = 0; i < Matrix.length; i++) {
                for (int j = 0; j < Matrix[i].length; j++) {
                    Matrix[i][j] = input.nextInt();
                }
            }
            System.out.println();
            System.out.println("Masukkan matriks hasil (gunakan enter untuk pindah baris): ");
            for (int i = 0; i < MatAns.length; i++) {
                MatrixAns[i] = input.nextInt();
            }
            System.out.println();
            Crammer(Matrix, MatrixAns);
        }
    }
}