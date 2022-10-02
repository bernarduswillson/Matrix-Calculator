import java.util.Scanner;
public class SPLCrammer{
    static void Crammer(double[][] Mat, double[] MatAns) {
        DeterminantCofact Det = new DeterminantCofact();
        int ROW = Mat.length;
        int COL = Mat[0].length;
        double[][] subMatrix = new double[ROW][COL];
        double Determinant = Det.DeterminantC(Mat);
        if (ROW != COL) {
            System.out.println("Tidak dapat diperoleh penyelesaian karena bukan matriks persegi!\n");
        }
        else if (Det.DeterminantC(Mat) == 0) {
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
            System.out.printf("X"+(i+1)+" = %.4f\n", (Det.DeterminantC(subMatrix)/Determinant));
            }
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("PROGRAM SPL CRAMMER\n");
        System.out.print("Masukkan ukuran matriks baris X kolom (gunakan spasi sebagai pemisah): ");
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
                    Matrix[i][j] = input.nextDouble();
                }
            }
            System.out.println();
            System.out.println("Masukkan matriks hasil (gunakan enter untuk pindah baris): ");
            for (int i = 0; i < MatrixAns.length; i++) {
                MatrixAns[i] = input.nextDouble();
            }
            System.out.println();
            Crammer(Matrix, MatrixAns);
        }
    }
}