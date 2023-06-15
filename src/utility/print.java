package utility;

public class print {
    public static void echelonForm(double[][] mat, double[] matAns, int type) {
        int row = mat.length;
        int col = mat[0].length;

        if (type == 1)
            System.out.println("Matrix in Echelon Form using GAUSS: ");
        else if (type == 2)
            System.out.println("Matrix in Echelon Form using GAUSS-JORDAN: ");

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("%.3f\t", mat[i][j]);
            }
            System.out.printf("  |\t%.3f\n", matAns[i]);
        }
        System.out.println();
    }
    
    public static void matrixForm(double[][] mat, int type) throws Exception {
        int row = mat.length;
        int col = mat[0].length;
        if (type == 1)
            System.out.println("Matrix after REDUCTION: ");
        else if (type == 2)
            System.out.println("Matrix after ADJOINT INVERSE:");
            
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("%.3f ", mat[i][j]);
            }  
            System.out.println();
        }
        System.out.println();

        if (type == 2 || type == 3)
            menu.backToMenu();
    }

    public static void solution(double[] solution, int type) throws Exception {
        int row = solution.length;

        if (type == 1)
            System.out.println("Solution using GAUSS:");
        else if (type == 2)
            System.out.println("Solution using GAUSS-JORDAN:");
        else if (type == 3)
            System.out.println("Solution using INVERSE:");
        else if (type == 4)
            System.out.println("Solution using CRAMMER:");

        for (int i = 0; i < row; i++) {
            System.out.printf("X%d = %.4f\n", (i + 1), solution[i]);
        }
        System.out.println();
        menu.backToMenu();
    }

    public static void determinant(double determinant, int type) throws Exception{
        if (type == 1)
            System.out.println("Determinant using COFACTOR EXPANSION:");
        else if (type == 2)
            System.out.println("Determinant using REDUCTION:");

        System.out.printf("%.4f\n", determinant);
        System.out.println();
        menu.backToMenu();
    }
}
