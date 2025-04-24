package week3;
import java.util.*;

public class latihanm3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float satuan = 5000 ;
        float biaya = 0 ;
        String nama_jenis = "";
        System.out.println("Selamat datang ke dalam Aplikasi Kasir Laundry");
        System.out.println("Silahkan Masukkan Nama Pelanggan");
        String nama = sc.nextLine();
        System.out.println("Silahkan Pilih jenis cucian yang dipilih (ketikkan angkanya saja)");
        System.out.println("1. Cuci Kering");
        System.out.println("2. Cuci Kering Lipat");
        System.out.println("3. Cuci Kering Lipat Setrika");
        int jenis_cucian = sc.nextInt();
        System.out.println("Silahkan Masukkan Berat Cucian");
        float berat = sc.nextFloat();
        System.out.print("");
        String err = sc.nextLine();
        System.out.println("Silahkan Masukkan No HP");
        String noHP = sc.nextLine();
        System.out.println("Silahlan Masukkan Tanggal Pengambilan");
        String tglsls = sc.nextLine();
        if (jenis_cucian == 1){
            satuan = 5000 ;
            nama_jenis = "Cuci Kering";
        }
        else if (jenis_cucian == 2){
            satuan = 6000 ;
            nama_jenis = "Cuci Kering Lipat";
        }
        else if (jenis_cucian == 3){
            satuan = 10000 ;
            nama_jenis = "Cuci Kering Lipat Setrika";
        }
        else {
            System.out.println("rrrr");
        }
        biaya = satuan * berat ;
        System.out.println(nama);
        System.out.println(nama_jenis);
        System.out.println(noHP);
        System.out.println(tglsls);
        System.out.println(biaya);
    }
}
