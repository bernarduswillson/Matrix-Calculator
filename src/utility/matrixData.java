package utility;

public class matrixData {
    private double[][] matrix;
    private double[] matrixAns;

    public matrixData(double[][] matrix, double[] matrixAns) {
        this.matrix = matrix;
        this.matrixAns = matrixAns;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public double[] getMatrixAns() {
        return matrixAns;
    }
}