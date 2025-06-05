package week10;
import java.util.*;
public class inputnilai {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Selamat Datang ke Aplikasi Input Nilai");
        System.out.print("Jumlah Mahasiswa  : ");
        int kolom = Integer.parseInt(sc.nextLine());
        System.out.print("Jumlah Matakuliah : ");
        int baris = Integer.parseInt(sc.nextLine());
        double[][] nilai = new double[baris][kolom];
        String[] namaMahasiswa = new String[kolom];
        String[] namaMatakuliah = new String[baris];
        double[] arrTinggi = new double[kolom];
        double[] arrRendah = new double[kolom];
        double[] arrAvg = new double[kolom];

        System.out.println("==Input Nama Mhs==");
        for (int i = 0; i < kolom; i++) {
            System.out.print(" Nama Mahasiswa ke - " + (i+1) + "    : ");
            namaMahasiswa[i] = sc.nextLine();
        }

        System.out.println("==Input Nama Matkul==");
        for (int i = 0; i < baris; i++) {
            System.out.print(" Matakuliah ke - " + (i+1) + "    : ");
            namaMatakuliah[i] = sc.nextLine();
        }

        System.out.println("==Input Nilai==");
        System.out.println("");

        //input nilai
        for (int i = 0; i < kolom; i++) { 
            System.out.println("==Nilai " + namaMahasiswa[i] + "==");
            for (int j = 0; j < baris; j++) { 
                System.out.print("Matakuliah " + namaMatakuliah[j] + "  : ");
                nilai[j][i] = sc.nextDouble();
            }
        }
        

        //hitung nilai tertinggi, terendah, dan rata rata
        for (int i = 0; i < kolom; i++) {
            double nilaiMax = nilai[0][i];
            double nilaiMin = nilai[0][i];
            double jumlahNilai = 0;
            for (int j = 0; j < baris; j++) {
                if (nilai[j][i] > nilaiMax) {
                    nilaiMax = nilai[j][i];
                }
                if (nilai[j][i] < nilaiMin) {
                    nilaiMin = nilai[j][i];
                }
                jumlahNilai = nilai[j][i] + jumlahNilai;
            }
            arrAvg[i] = jumlahNilai/baris;
            arrTinggi[i] = nilaiMax;
            arrRendah[i] = nilaiMin;
        }

        // ouput
        for (int i = 0; i < kolom; i++) { 
            System.out.println("==Mahasiswa " + namaMahasiswa[i] + "==");
            for (int j = 0; j < baris; j++) {
                System.out.println("Matakuliah " + namaMatakuliah[j] + "  : " + nilai[j][i]);
            }
            System.out.println("Nilai Tertinggi   : " + arrTinggi[i]);
            System.out.println("Nilai Terendah    : " + arrRendah[i]);
            System.out.println("Rata - rata       : " + arrAvg[i]);
        }
        System.out.println("========END========");
        sc.close();
    }
}