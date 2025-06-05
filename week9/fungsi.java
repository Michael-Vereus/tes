package week9;
import java.util.*;

public class fungsi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Aplikasi penghitung luas pesergi ");
        System.out.print("Panjang(cm)   : ");
        double panjang = sc.nextDouble();
        System.out.print("Lebar(cm)     : ");
        double lebar = sc.nextDouble();
        double hasil = luaspesergi(panjang, lebar);
        System.out.println();
        System.out.println("Luas    = " + hasil + " cm");
    }
    public static double luaspesergi(double p, double l){
        double luas = p * l ;
        return luas;
    }
}
