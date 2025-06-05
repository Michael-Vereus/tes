package week6;
import java.util.*;
public class prauts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Pass Check Save");
        System.out.println("Masukkan Username anda");
        String username = sc.nextLine();
        int i = 1;
        while(i < 3){
            
            System.out.println("Buat Password (Minimal 8 kata)");
            String pssword = sc.nextLine();
            

            if (pssword.length() >= 8){
                i =  i + 3; ;
            }
            else {
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println("Password kurang dari 8 karakter silahkan ketik lagi !");
                System.out.println("=====================================================");
            }
        }
        System.out.println("");
        
    }
}
