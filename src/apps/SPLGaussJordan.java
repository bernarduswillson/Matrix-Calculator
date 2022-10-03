import java.util.Scanner;
public class SPLGaussJordan {
    static void BackwardOBE(double[][] Mat, double[] MatAns) {
        int ROW = Mat.length;
        for (int i = ROW - 1; i >= 0; i--) {
            for (int j = i-1; j >= 0; j--) {
                double Const = Mat[j][i] / Mat[i][i];
                MatAns[j] -= Const * MatAns[i];
                for (int k = i; k >= 0; k--) {
                    Mat[j][k] -= Const * Mat[i][k];
                } 
            }
        }
        PrintEselon(Mat, MatAns);
        System.out.println();
        System.out.println("Solusi SPL dengan metode GAUSS-JORDAN: ");
        for (int i = 0; i < MatAns.length; i++) {
            System.out.printf("X"+(i+1)+" = %.4f\n", MatAns[i]);
        }
    }
    
    static void PrintEselon(double[][] Mat, double[] MatAns) {
        int ROW = Mat.length;
        int COL = Mat[0].length;
        System.out.println("Hasil matriks setelah menggunakan GAUSS-JORDAN: ");
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                System.out.printf("%.3f\t ", Mat[i][j]);
            }
            System.out.printf("  |\t%.3f\n", MatAns[i]);
        }
    }

    public static void functionSPLGaussJordan() {
        Scanner input = new Scanner(System.in);
        SPLGauss obe1 = new SPLGauss();
        System.out.println("PROGRAM ELIMINASI GAUSS\n");
        System.out.print("Masukkan ukuran matriks baris X kolom (gunakan spasi sebagai pemisah): ");
        int ROW = input.nextInt();
        int COL = input.nextInt();
        System.out.println();
        double[][] Matrix = new double[ROW][COL];
        double[] MatrixAns = new double[ROW];
        System.out.println("Masukkan elemen matriks (gunakan spasi sebagai pemisah dan enter untuk pindah baris): ");
        for (int i = 0; i < ROW; i++)
            for (int j = 0; j < COL; j++)
                Matrix[i][j] = input.nextDouble();
        System.out.println();
        System.out.println("Masukkan elemen matriks jawaban (gunakan spasi sebagai pemisah dan enter untuk pindah baris): ");
        for (int i = 0; i < ROW; i++)
            MatrixAns[i] = input.nextDouble();
        System.out.println();
        obe1.ForwardOBE(Matrix, MatrixAns);
        BackwardOBE(Matrix, MatrixAns);
    }
}