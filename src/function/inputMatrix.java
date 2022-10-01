import java.io.*;
import java.util.*;

public class inputMatrix {
    public static double[][] readFile() throws Exception
    {
        try {
            // input file
            System.out.println("Masukkan nama file (contoh: bernard.java): ");
            Scanner input = new Scanner(System.in);
            String fileName = input.nextLine();

            // kalau file kosong
            if (Objects.isNull(fileName))
            {
                throw new Exception();
            }
            
            // update path
            String path = System.getProperty(fileName);
            System.out.println(path);
            File file = new File(path);
            Scanner fileContent = new Scanner(file);

            // hitung row, col
            int col = 0, row = 0;
            while (fileContent.hasNextLine()) 
            {
                String lineKotor = fileContent.nextLine();
                String[] lineBersih = lineKotor.trim().split(" ");
                col = lineBersih.length;
                row++;
            }
            fileContent.close();
            
            // input matrix
            double[][] Matrix = new double[row][col];
            Scanner fileMatrix = new Scanner(file);
            while (fileMatrix.hasNextLine()) 
            {
                for (int i = 0; i < row; i++) 
                {
                    for (int j = 0; j < col; j++) 
                    {
                        Matrix[i][j] = fileMatrix.nextDouble();
                    }
                }
            }
            fileMatrix.close();
            return Matrix;
        }

        catch (FileNotFoundException e) {
            System.out.println("File tidak ditemukan!");
            return new double[0][0];
        }
    }
}
