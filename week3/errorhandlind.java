package week3;
import java.util.*;

public class errorhandlind {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Pilih angka dari satu sampai 4");
        int angka = sc.nextInt();
        if(angka == 1){
            System.out.println("Selamat anda mendapatkan hp");

        }
        else if (angka == 2 ){
            System.out.println("Selamat anda mendapatkan Laptop");

        }
        else if (angka == 3){
            System.out.println("Selamat anda mendapatkan farrel");

        }
        else if (angka == 4){
            System.out.println("Selamat anda mendapatkan makan siang gratis");

        }
        else {
            System.err.println("Bro berfikir diluar kotak");
        }
    }
}