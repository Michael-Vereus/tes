package week9;
import java.util.*;

public class prosedur {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan nama anda        = ");
        String nama = sc.nextLine();
        System.out.print("Masukkan tgl lahir anda   = ");
        String tgl_lahir = sc.nextLine();
        System.out.print("Masukkan alamat anda      = ");
        String alamat = sc.nextLine();
        System.out.println();
        printbiodata(nama, tgl_lahir, alamat);
    }
    public static void printbiodata(String a, String b, String c) {
        System.out.println("========");
        System.out.println("Nama anda       : " + a);
        System.out.println("Tgl Lahir anda  : " + b);
        System.out.println("Alamat anda     : " + c);
        System.out.println("========");
    }
}
