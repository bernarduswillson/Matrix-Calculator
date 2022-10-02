import java.util.*;
import java.lang.*;
public class bicubic {
    static double[][] Cofactor(double[][] Mat) {
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
                    double[][] subMatrix = new double[ROW-1][COL-1];
                    for (int k = 0; k < ROW-1; k++) {
                        for (int l = 0; l < COL-1; l++) {
                            if (k < i) {
                                if (l < j) {
                                    subMatrix[k][l] = Mat[k][l];
                                }
                                else {
                                    subMatrix[k][l] = Mat[k][l+1];
                                }
                            }
                            else {
                                if (l < j) {
                                    subMatrix[k][l] = Mat[k+1][l];
                                }
                                else {
                                    subMatrix[k][l] = Mat[k+1][l+1];
                                }
                            }
                        }
                    }
                    Cofactor[i][j] = (double)Math.pow(-1,i+j)*Determinant(subMatrix);
                }
            }
            return Cofactor;
        }
    }

    static double[][] Inverse(double[][] Mat) {
        int ROW = Mat.length;
        int COL = Mat[0].length;
        double[][] Inverse = new double[ROW][COL];
        if (ROW == 1) {
            Inverse[0][0] = 1/Mat[0][0];
            return Inverse;
        }
        else {
            double[][] Cofactor = Cofactor(Mat);
            Inverse = MultiplyByConst(Transpose(Cofactor),(1/Determinant(Mat)));
            return Inverse;
        }
    }

    static double[][] MultiplyByConst(double[][] Mat, double k) {
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

    static double[][] Transpose(double[][] Mat) {
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
            if (Determinant == 0) {
                System.out.println("Matriks tidak memiliki invers karena determinannya 0!");
                System.exit(0);
            }
        return Determinant;
        }  
    }

    public static double[][] bicubic()
    {
        // Scanner input = new Scanner(System.in);
        // double[][] A = new double[4][4];
        // for (int i = 0; i < 4; i++) {
        //     for (int j = 0; j < 4; j++) {
        //         A[i][j] = input.nextDouble();
        //     }
        // }
        // double[][] B = new double[16][1];

        // int k = 0;
        // for (int i = 0; i < 4; i++) 
        // {
        //     for (int j = 0; j < 4; j++) 
        //     {
        //         B[k][0] = A[i][j];
        //         k++;
        //     }
        // }
        double[][] X = new double[16][16];
        double[][] Y = new double[16][1];
        int K = 0;
        for (int j= 0; j<4; j++){
            for (int i=0; i<4; i++){
                X[0][K]= Math.pow((-1), i) * Math.pow((-1), j); 
                X[1][K] = Math.pow((0), i) * Math.pow((-1), j); 
                X[2][K] = Math.pow((1), i) * Math.pow((-1), j); 
                X[3][K] = Math.pow((2), i) * Math.pow((-1), j);             
                X[4][K]= Math.pow((-1), i) * Math.pow((0), j); 
                X[5][K]= Math.pow((0), i) * Math.pow((0), j); 
                X[6][K]= Math.pow((1), i) * Math.pow((0), j); 
                X[7][K]= Math.pow((2), i) * Math.pow((0), j); 
                X[8][K]= Math.pow((-1), i) * Math.pow((1), j); 
                X[9][K]= Math.pow((0), i) * Math.pow((1), j); 
                X[10][K] = Math.pow((1), i) * Math.pow((1), j); 
                X[11][K] = Math.pow((2), i) * Math.pow((1), j); 
                X[12][K] = Math.pow((-1), i) * Math.pow((2), j); 
                X[13][K] = Math.pow((0), i) * Math.pow((2), j); 
                X[14][K] = Math.pow((1), i) * Math.pow((2), j); 
                X[15][K] = Math.pow((2), i) * Math.pow((2), j);
                K++;
            }
        }
        //Inverse(X);
        
        return X;
        
        //B = reshape(A,16,1);
        //return B;
    }
    
    static void PrintMatrix(double[][] B) {
        int ROW = B.length;
        int COL = B[0].length;
        System.out.println("Hasil invers matriks bicubic: ");
        for (int i = 0; i < ROW; i++) 
        {
            for (int j = 0; j < COL; j++) 
            {
                System.out.printf("%.3f\t", B[i][j]);
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        PrintMatrix(bicubic());
        
    }  

}

