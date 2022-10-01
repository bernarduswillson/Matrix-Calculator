import java.util.*;
public class Menu 
{
    
    public static void main(String[] args) 
    {
        //int choice = 0;
        mainMenu();
        while(true)
        {
            Scanner input = new Scanner(System.in);
            System.out.print("Masukkan pilihan anda : ");
            int choice = input.nextInt();
            mainMenu();
        }
    }
    
    public static void mainMenu ()
    {
        String batas = "=======================================";
        Scanner input = new Scanner(System.in);

        System.out.println("KALKULATOR MATRIKS");
        Boolean status = true;
        while (status)
        {
            System.out.println(batas);
            System.out.println("MENU");
            System.out.println("1. Sistem Persamaan Linier");
            System.out.println("2. Determinan");
            System.out.println("3. Matriks balikan");
            System.out.println("4. interpolasi Polinom");
            System.out.println("5. Interpolasi Bicubic");
            System.out.println("6. Regresi linier berganda");
            System.out.println("7. Keluar");
            System.out.println(batas);
            System.out.println("Pilih metode yang akan digunakan (1-7) : ");
            try {
                int choice = input.nextInt();
                // if (choice <= 7 && choice >= 1)
                // {
                //     status = false;
                // }
                // else
                // {
                //     System.out.println("Inputan salah");
                // }
            } 
            catch (NumberFormatException e) 
            {
                System.out.println("Inputan tidak valid");
                mainMenu();
                continue;
            }
            catch (Exception e) 
            {
                exit();
            }   
            
        }
        switch (choice) {
            case 1:
                splMenu()
                break;
            case 2:
                detMenu();
                break;
            case 3:
                invMenu();
                break;

            // case 4-6 gaada menu kan ya? lgsg fungsinya?
            case 4:
                polyMenu();
                break;
            case 5:
                bicubicMenu();
                break;
            case 6:
                regMenu();
                break;
            case 7:
                exit();
                break;
            default:
                break;
        }
    }

    public static void splMenu ()
    {

    }
    public static void detMenu ()
    {

    }
    public static void invMenu ()
    {

    }
    public static void backToMenu ()
    {

    }
}
