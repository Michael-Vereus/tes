//@author thali
 
import java.util.Scanner;
public class GajiPegawai {
 
    public static double hitungTotalGaji(double gajiPokok, double tunjangan) {
        return gajiPokok + tunjangan;
    }

    public static double hitungPajak(double totalGaji) {
        if (totalGaji > 10000000) {
            return totalGaji * 0.10;
        } 
        else if (totalGaji > 5000000) {
            return totalGaji * 0.05;
        } 
        else {
            return 0;
        }
    }

    public static double hitungGajiAkhir(double totalGaji, double pajak) {
        return totalGaji - pajak;
    }
    
    public static void cetakSlip(String nama, double totalGaji, double pajak, double gajiAkhir) {
        System.out.println("========== SLIP GAJI ==========");
        System.out.println("Nama Pegawai  : " + nama);
        System.out.printf("Total Gaji    : Rp %.2f\n", totalGaji);
        System.out.printf("Pajak         : Rp %.2f\n", pajak);
        System.out.printf("Gaji Akhir    : Rp %.2f\n", gajiAkhir);
        System.out.println("==============================");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan Nama Pegawai: ");
        String nama = input.nextLine();

        System.out.print("Masukkan Gaji Pokok: ");
        double gajiPokok = input.nextDouble();

        System.out.print("Masukkan Tunjangan: ");
        double tunjangan = input.nextDouble();

        double totalGaji = hitungTotalGaji(gajiPokok, tunjangan);
        double pajak = hitungPajak(totalGaji);
        double gajiAkhir = hitungGajiAkhir(totalGaji, pajak);

        cetakSlip(nama, totalGaji, pajak, gajiAkhir);

        input.close();
    }
}

   
