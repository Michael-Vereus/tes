package week14;
import java.util.*;

public class daftarbelanja {
    static ArrayList<String> daftarBelanja = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while(true){
            menuOutput();
            String opt = sc.nextLine();
            switch(opt) {
                case "1" :
                break;
                case "2" :
                break;
                case "3" :
                break;
                case "0" : 
                System.out.println("Thank You For Using Our Services");
                return;
                default:
                System.out.println("Error invalid menu");
            }
        }
    }

    public static void menuOutput(){
        System.out.println("=== Grocery Helper ===");
        System.out.println("1. Input Grocery");
        System.out.println("2. Remove Grocery");
        System.out.println("3. Grocery List");
        System.out.println("0. Exit");
        System.out.print("Choose the menu : ");
    }

    public static void inputGrocery(){
        System.out.println("How Many Groceries Would You Like to Input Today ?");
        System.out.print("");
        System.out.print("Nama barang: ");
        String barang = sc.nextLine();
        daftarBelanja.add(barang);
        System.out.println("✔ Barang ditambahkan.");
    }
}
