package week10;
import java.util.*;
public class latdua {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Berapa Karyawan yang ingin anda absen ?");
        int baris = Integer.parseInt(sc.nextLine());
        System.out.println("Ketikkan berapa hari yang ingin anda absensi  :");
        int kolom = Integer.parseInt(sc.nextLine());
        String[][] kehadiran = new String[baris][kolom];
        for (int i = 0; i < baris; i++) {
            System.out.println("\nKaryawan ke - " + i);
            System.out.println("Ketik Y apabila hadir dan n apabila tidak hadir");
            for (int j = 0; j < kolom; j++) {
                System.out.print("Hari ke - " + j + " (Y/n) :");
                kehadiran[i][j] = sc.nextLine();
                
                
            }
        }
    }
}
