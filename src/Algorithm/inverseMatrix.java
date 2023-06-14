package algorithm;

public class inverseMatrix {
    public static double[][] calculate(double[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        double[][] inverse = new double[row][col];
        if (row == 1) {
            inverse[0][0] = 1 / mat[0][0];
            return inverse;
        } else {
            double[][] cofactor = cofactor(mat);
            inverse = multiplyByConst(transpose(cofactor), (1 / cofactorExpansion.calculate(mat)));
            return inverse;
        }
    }

    static double[][] cofactor(double[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        double[][] Cofactor = new double[row][col];

        if (row == 1) {
            Cofactor[0][0] = 1;
            return Cofactor;
        }

        else {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    double[][] submatrix = new double[row - 1][col - 1];
                    for (int k = 0; k < row - 1; k++) {
                        for (int l = 0; l < col - 1; l++) {
                            if (k < i) {
                                if (l < j) {
                                    submatrix[k][l] = mat[k][l];
                                } else {
                                    submatrix[k][l] = mat[k][l + 1];
                                }
                            }

                            else {
                                if (l < j) {
                                    submatrix[k][l] = mat[k + 1][l];
                                } else {
                                    submatrix[k][l] = mat[k + 1][l + 1];
                                }
                            }
                        }
                    }

                    Cofactor[i][j] = (double) Math.pow(-1, i + j) * cofactorExpansion.calculate(submatrix);
                }
            }
            return Cofactor;
        }
    }

    static double[][] transpose(double[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = i; j < col; j++) {
                double Temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = Temp;
            }
        }
        return mat;
    }

    static double[][] multiplyByConst(double[][] mat, double k) {
        int row = mat.length;
        int col = mat[0].length;
        double[][] mOut = new double[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mOut[i][j] = mat[i][j] * k;
            }
        }
        return mOut;
    }
}
