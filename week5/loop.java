package week5;
import java.util.*;
public class loop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Masukkan berapa baris piramida yang ingin dibuat");
        int baris = sc.nextInt();
        int d = baris ;
        int c = 0;
        for(int j = 1; j <= baris;j++){
            for (int i = 1;i <= d;i++){
                System.out.print("a");
                System.out.print(" ");
            }
            d = d - 1;
            c = c + 1;
            for (int a = 1;a <= c;a++ ){
                System.out.print("|");
                System.out.print("   ");
            }
            
            System.out.println();
        }
    }
}
