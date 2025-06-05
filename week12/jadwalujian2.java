package week12;
import java.util.*;

public class jadwalujian2 {
    static Scanner sc = new Scanner(System.in);

    // Maksimal 10 hari, maksimal 2 matkul per hari
    static String[][] jadwalManualHari = new String[10][2];
    static String[][] jadwalManualJenis = new String[10][2];
    static String[] namaHari = new String[10];
    static int jumlahHariManual = 0;
    static int[] jumlahMatkulPerHari = new int[10];

    public static void main(String[] args) {
        System.out.println("== Aplikasi Penjadwalan Ujian Manual ==");

        plottingJadwal1HariMax2Ujian(); // input dari user
        outputManual(); // tampilkan hasil
        cekJadwalUjianYangTidakBersamaanDenganDemo(); // validasi
    }

    // Input manual dari user, maksimal 2 matkul per hari
    public static void plottingJadwal1HariMax2Ujian() {
        System.out.print("Berapa hari ingin diisi manual? ");
        jumlahHariManual = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < jumlahHariManual; i++) {
            System.out.println("\n=== Hari ke-" + (i + 1) + " ===");
            System.out.print("Masukkan nama hari (Senin-Jumat): ");
            namaHari[i] = sc.nextLine();

            boolean inputValid = false;
            while (!inputValid) {
                System.out.print("Berapa jumlah matkul di hari " + namaHari[i] + "? (maks 2): ");
                int jumlahMatkul = Integer.parseInt(sc.nextLine());

                if (jumlahMatkul < 1 || jumlahMatkul > 2) {
                    System.out.println("Jumlah matkul per hari harus 1 atau 2.");
                    continue;
                }

                jumlahMatkulPerHari[i] = jumlahMatkul;
                int jumlahTulis = 0;
                int jumlahPraktik = 0;

                for (int j = 0; j < jumlahMatkul; j++) {
                    System.out.print("Nama matkul ke-" + (j + 1) + ": ");
                    jadwalManualHari[i][j] = sc.nextLine();

                    System.out.print("Jenis ujian (tulis/praktik): ");
                    jadwalManualJenis[i][j] = sc.nextLine().toLowerCase();

                    if (jadwalManualJenis[i][j].equals("tulis")) {
                        jumlahTulis++;
                    } else if (jadwalManualJenis[i][j].equals("praktik")) {
                        jumlahPraktik++;
                    }
                }

                if (jumlahTulis > 0 && jumlahPraktik > 0) {
                    System.out.println("Tidak boleh ada ujian tulis dan praktik dalam hari yang sama.");
                    System.out.println("Silakan input ulang untuk hari " + namaHari[i] );
                } else {
                    inputValid = true;
                }
            }
        }
    }

    // Tampilkan hasil jadwal yang telah diinput
    public static void outputManual() {
        System.out.println("\n== Jadwal Ujian Manual ==");
        for (int i = 0; i < jumlahHariManual; i++) {
            System.out.println("Hari " + namaHari[i] + ":");
            for (int j = 0; j < jumlahMatkulPerHari[i]; j++) {
                System.out.println("   - " + jadwalManualHari[i][j] + " (" + jadwalManualJenis[i][j] + ")");
            }
        }
    }

    // Validasi: tidak boleh campuran tulis & praktik dalam 1 hari
    public static void cekJadwalUjianYangTidakBersamaanDenganDemo() {
        System.out.println("\n== Pengecekan Ujian Tidak Boleh Bersamaan Tulis dan Praktik ==");

        boolean aman = true;

        for (int i = 0; i < jumlahHariManual; i++) {
            boolean adaTulis = false;
            boolean adaPraktik = false;

            for (int j = 0; j < jumlahMatkulPerHari[i]; j++) {
                String jenis = jadwalManualJenis[i][j];
                if (jenis.equals("tulis")) adaTulis = true;
                if (jenis.equals("praktik")) adaPraktik = true;
            }

            if (adaTulis && adaPraktik) {
                System.out.println("Hari " + namaHari[i] + " terdapat ujian tulis DAN praktik. Harus diperbaiki.");
                aman = false;
            }
        }

        if (aman) {
            System.out.println("Jadwal valid. Tidak ada bentrok antara ujian tulis dan praktik dalam 1 hari.");
        }
    }
}
