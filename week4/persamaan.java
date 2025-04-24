package week4;
import java.util.*;

public class persamaan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ini adalah program menghitugn pesamaan Q");
        System.out.println("Silahkan Masukkan variabel x anda");
        double x = sc.nextDouble();
        System.out.println("Silahlkan Masukkan variabel y anda");
        double y = sc.nextDouble();
        System.out.println("Silahkan Masukkan variabel z anda");
        double z = sc.nextDouble();
        double preQ = Math.pow(x,2) - 9*z + Math.pow(y, 2);
        if (preQ < 0) {
            System.out.println("Error: Nilai di dalam akar negatif. Tidak bisa menghitung akar kuadrat dari bilangan negatif.");
        } else {
            double Q = Math.sqrt(preQ);
            System.out.println("Hasil Anda adalah : " + Q);
        }
    }
}
