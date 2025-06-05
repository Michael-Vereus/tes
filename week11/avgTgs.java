package week11;
import java.util.*;

public class avgTgs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=================");
        System.out.println("Aplikasi penghitung rata rata matkul Prog Das");
        System.out.print("Banyak Mhs : ");
        int kolom = Integer.parseInt(sc.nextLine());
        System.out.print("Banyak Pertemuan : ");
        int baris = Integer.parseInt(sc.nextLine());
        double[][] nilaiTugasKls = new double[kolom][baris];
        double[][] nilaiPraktikum = new double[kolom][baris];
        double[] avgTugas = new double[kolom];
        String[] namaMhs = new String[kolom];
        
        //input namaMhs
        for (int i = 0; i < kolom; i++){
            System.out.print("Nama Mhs ke - " + (i+1) + " : ");
            namaMhs[i] = sc.nextLine();
        }
        //input nilai
        for (int i = 0; i < kolom; i++){
            System.out.println("===== "  +namaMhs[i] + " =====");
            for (int j = 0; j < baris; j++){
                System.out.println("=== Week " + (j+1) + " ===");
                System.out.print("Nilai Tugas ke - " + (j+1) + " : ");
                nilaiTugasKls[i][j] = Integer.parseInt(sc.nextLine());
                System.out.print("Nilai Praktikum ke - " + (j+1) + " : ");
                nilaiPraktikum[i][j] = Integer.parseInt(sc.nextLine());
            }
        }
        //proses avg
        for (int i = 0; i < kolom; i++){
            avgTugas[i] = avgCounter(nilaiTugasKls, nilaiPraktikum, baris, kolom, i);
        }
        //output
        for (int i = 0; i < kolom; i ++) {
            System.out.println("=========== Nilai " + namaMhs[i] + " =============");
            for (int j = 0; j < baris; j++) {
                System.out.println("------------------------------");
                System.out.println("Nilai Tugas Week - " + (j+1) + " : " + nilaiTugasKls[i][j]);
                System.out.println("Nilai Praktikum Week - " + (j+1) + " : " + nilaiPraktikum[i][j]);
                double nilaiTotalWeekly = (nilaiTugasKls[i][j] + nilaiPraktikum[i][j]);
                System.out.println("Total Nilai Week - " + (j+1) + " : " + nilaiTotalWeekly);

            }
            System.out.println("Rata - rata : " + avgTugas[i]);
        }
    }
    public static double avgCounter(double[][] nilaiTugasKls, double[][] nilaiPraktikum ,int baris, int kolom, int i) {    
        double temptotal = 0;
        for (int j = 0; j < kolom; j++){
            temptotal = nilaiPraktikum[i][j] + nilaiTugasKls[i][j] + temptotal;
        }
        System.out.println(temptotal);
        double avg = temptotal / (kolom * 2); 
        return avg;
    }

}
