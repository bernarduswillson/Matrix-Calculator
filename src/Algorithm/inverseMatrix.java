package Algorithm;

public class inverseMatrix {
    public static double[][] calculate(double[][] Mat) {
        int ROW = Mat.length;
        int COL = Mat[0].length;
        double[][] inverse = new double[ROW][COL];
        if (ROW == 1) {
            inverse[0][0] = 1 / Mat[0][0];
            return inverse;
        } else {
            double[][] cofactor = cofactor(Mat);
            inverse = multiplyByConst(transpose(cofactor), (1 / determinantCofactor.calculate(Mat)));
            return inverse;
        }
    }

    static double[][] cofactor(double[][] Mat) {
        int ROW = Mat.length;
        int COL = Mat[0].length;
        double[][] Cofactor = new double[ROW][COL];

        if (ROW == 1) {
            Cofactor[0][0] = 1;
            return Cofactor;
        }

        else {
            for (int i = 0; i < ROW; i++) {
                for (int j = 0; j < COL; j++) {
                    double[][] subMatrix = new double[ROW - 1][COL - 1];
                    for (int k = 0; k < ROW - 1; k++) {
                        for (int l = 0; l < COL - 1; l++) {
                            if (k < i) {
                                if (l < j) {
                                    subMatrix[k][l] = Mat[k][l];
                                } else {
                                    subMatrix[k][l] = Mat[k][l + 1];
                                }
                            }

                            else {
                                if (l < j) {
                                    subMatrix[k][l] = Mat[k + 1][l];
                                } else {
                                    subMatrix[k][l] = Mat[k + 1][l + 1];
                                }
                            }
                        }
                    }

                    Cofactor[i][j] = (double) Math.pow(-1, i + j) * determinantCofactor.calculate(subMatrix);
                }
            }
            return Cofactor;
        }
    }

    static double[][] transpose(double[][] Mat) {
        int ROW = Mat.length;
        int COL = Mat[0].length;
        for (int i = 0; i < ROW; i++) {
            for (int j = i; j < COL; j++) {
                double Temp = Mat[i][j];
                Mat[i][j] = Mat[j][i];
                Mat[j][i] = Temp;
            }
        }
        return Mat;
    }

    static double[][] multiplyByConst(double[][] Mat, double k) {
        int ROW = Mat.length;
        int COL = Mat[0].length;
        double[][] mOut = new double[ROW][COL];
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                mOut[i][j] = Mat[i][j] * k;
            }
        }
        return mOut;
    }
}
