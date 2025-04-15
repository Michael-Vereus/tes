package week3;
import java.util.*;

public class ipkskscounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.err.println("Masukkan Nama anda");
        String username = sc.nextLine();
        System.out.println("Selamat datang "+ username);
        String[]nama_matkul = {"Agama", "Dasar Teknologi dan Informasi", "Kewarganegaraan", "Logika dan Algoritma", "Etika Profesi", "Kepemimpinan dan Manejemen Organisasi", "Aljabar Linear", "Statiska dan Probabilitas"};
        double[] sks_matkul = {2,2,2,3,2,3,3,3};
        double[] nilai_akhir = new double[8];
        double[] bobot = new double[8];
        double[] bobot_final = new double[8];
        double[] nilai_tugas = new double[8];
        double[] nilai_uts = new double[8];
        double[] nilai_uas = new double[8];
        String[] huruf = new String[8];

    
        double total_bobot = 0 ;
        double total_sks = 20 ;
        double ips = 0 ;
        for (int i = 0; i < 8 ;i++){
            System.out.println("Masukkan nilai TUGAS mata kuliah " + nama_matkul[i]);
            nilai_tugas[i] = sc.nextDouble();
        }
        for (int i = 0; i < 8 ;i++){
            System.out.println("Masukkan nilai UTS mata kuliah " + nama_matkul[i]);
            nilai_uts[i] = sc.nextDouble();
        }
        for (int i = 0; i < 8 ;i++){
            System.out.println("Masukkan nilai UAS mata kuliah " + nama_matkul[i]);
            nilai_uas[i] = sc.nextDouble();
        }
        for (int i = 0; i < 8 ;i++){
            System.out.println("Masukkan nilai akhir mata kuliah " + nama_matkul[i]);
            nilai_akhir[i] = (0.3*nilai_uas[i]) + (0.3*nilai_uts[i]) + (0.4*nilai_tugas[i]);
        }
        for (int i = 0; i < 8 ;i++){
            System.out.println("Nilai akhir mata kuliah " + nama_matkul[i] + " anda adalah " + nilai_akhir[i]);
        }
        for (int i = 0; i < 8 ; i++){
            if(nilai_akhir[i] <= 100 && nilai_akhir[i] >= 80){
                bobot[i] = 4 ;
                huruf[i] = "A";
            }
            else if (nilai_akhir[i] <= 79 && nilai_akhir[i] >= 75){
                bobot[i] = 3.5;
                huruf[i] = "B+";
            }
            else if (nilai_akhir[i] <= 74 && nilai_akhir[i] >= 65){
                bobot[i] = 3;
                huruf[i] = "B";
            }
            else if (nilai_akhir[i] <= 64 && nilai_akhir[i] >= 60){
                bobot[i] = 2.5;
                huruf[i] = "C+";
            }
            else if (nilai_akhir[i] <= 59 && nilai_akhir[i] >= 50){
                bobot[i] = 2;
                huruf[i] = "C";
            }
            else if (nilai_akhir[i] <= 49 && nilai_akhir[i] >= 45){
                bobot[i] = 1.5;
                huruf[i] = "D";
            }
            else if (nilai_akhir[i] <= 44){
                bobot[i] = 1;
                huruf[i] = "E";
            }
        }
        for (int i = 0; i < 8 ;i++){
            System.out.println("Ini nilai mata kuliah "+ nama_matkul[i] + " : " + huruf[i] + " , " + bobot[i]);
        }
        for (int i = 0; i < 8 ;i++){
            bobot_final[i] = bobot[i] * sks_matkul[i] ;
        }
        for (int i = 0; i < 8 ; i++){
            total_bobot = total_bobot + bobot_final[i];
        }
        System.out.println(total_bobot);
        ips = total_bobot / total_sks ;
        System.out.println(ips);
        if (ips <= 4 && ips >=3.5){
            System.out.println("Total SKS Maksimum yang bisa diambil : 24 sks");
        }
        else if (ips < 3.5  && ips >=3.0){
            System.out.println("Total SKS Maksimum yang bisa diambil : 22 sks");
        }
        else if (ips < 3.0  && ips >=2.5){
            System.out.println("Total SKS Maksimum yang bisa diambil : 20 sks");
        }
        else if (ips < 3.0  && ips >=2.5){
            System.out.println("Total SKS Maksimum yang bisa diambil : 18 sks");
        }
        else if (ips < 2.5  && ips >=2.0){
            System.out.println("Total SKS Maksimum yang bisa diambil : 15 sks");
        }
        else if (ips < 2.0 ){
            System.out.println("Total SKS Maksimum yang bisa diambil : 12 sks");
        }
        else {
            System.out.println("Invalid IPS Silahkan ke AAK untuk info lebih lanjut.");
        }
    }   
}
