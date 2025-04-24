import java.util.*;

public class jadwal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Masukkan Hari yang ingin anda cari");
        String day = sc.nextLine();
        String matkul1 = "";
        String matkul2 = "";
        String matkul3 = "";
        switch (day) {
            case "Senin":
                matkul1 = "Aljabar Linear";
                matkul2 = "Matematika Bisnis";
                matkul3 = "Pemograman Berbasis Object";
                System.out.println("Mata Kuliah Anda ");
                System.out.println("1. " + matkul1);
                System.out.println("2. " + matkul2);
                System.out.println("3. " + matkul3 );
                break;
            case "Selasa":
                matkul1 = "Pemograman Dasar";
                matkul2 = "Basis Data";
                System.out.println("Mata Kuliah Anda ");
                System.out.println("1. " + matkul1);
                System.out.println("2. " + matkul2);
                break;
            case "Rabu":
                matkul1 = "Pemasaran Digital";
                matkul2 = "Jaringan Komputer";
                System.out.println("Mata Kuliah Anda ");
                System.out.println("1. " + matkul1);
                System.out.println("2. " + matkul2);
                break;
            default:
                System.out.println("Anda tidak memiliki jadwal kuliah di hari tsb");
        }
    }
}
