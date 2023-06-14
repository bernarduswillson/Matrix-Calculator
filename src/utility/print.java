package Utility;

public class print {
    public static void echelonForm(double[][] Mat, double[] MatAns, int type) {
        int ROW = Mat.length;
        int COL = Mat[0].length;

        if (type == 1)
            System.out.println("Matrix in Echelon Form using GAUSS: ");
        else if (type == 2)
            System.out.println("Matrix in Echelon Form using GAUSS-JORDAN: ");
            
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                System.out.printf("%.3f\t", Mat[i][j]);
            }
            System.out.printf("  |\t%.3f\n", MatAns[i]);
        }
        System.out.println();
    }

    public static void solution(double[] solution, int type) {
        int ROW = solution.length;

        if (type == 1)
            System.out.println("Solution using GAUSS:");
        else if (type == 2)
            System.out.println("Solution using GAUSS-JORDAN:");
        else if (type == 3)
            System.out.println("Solution using INVERSE:");

        for (int i = 0; i < ROW; i++) {
            System.out.printf("X%d = %.4f\n", (i + 1), solution[i]);
        }
        System.out.println();
    }
}
