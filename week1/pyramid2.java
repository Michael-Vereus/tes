package week1;
import java.util.*;
public class pyramid2 {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner (System.in);
        System.out.println("Masukkan angka yg anda inginkan");
        int baris = sc.nextInt();
        int d = baris ;
        for(int i = 1; i <= baris; i++){
            for(int j = 1; j <= d;j++){
                System.out.print("  ");
            }
            d = d - 1 ;
            for(int a = 1; a <= i;a++){
                System.out.print("  * ");
            }
            System.out.println();
        }
        
    }
}
