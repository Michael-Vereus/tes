package week10;
import java.util.*;

public class inventorygudang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("==============");
        System.out.println("Selamat Datang ke Inventaris Gudang");
        System.out.print("Silahkan Masukkan Berapa Gudang Anda  : ");
        int kolom = Integer.parseInt(sc.nextLine());
        System.out.print("Jenis barang yang ada di gudang       : ");
        int baris = Integer.parseInt(sc.nextLine());
        int [] totalBarang = new int[baris];
        int [] totalBarangGudang = new int[kolom];
        int[][] barang = new int[kolom][baris];
        String[] namaGudang = new String[kolom];
        String[] namaBarang = new String[baris];
        int a = 0;
        int b = 0;
        System.out.println("==============");
        for (int i = 0; i < kolom; i++){
            System.out.print("Nama Gudang ke - " + (i+1) + "    : " );
            namaGudang[i] = sc.nextLine();
        }
        System.out.println("==============");
        for (int i = 0; i < baris; i++){
            System.out.print("Nama Barang ke - " + (i+1) + "    : ");
            namaBarang[i] = sc.nextLine();
        }
        System.out.println("==============");
        for (int i = 0; i < kolom; i++){
            System.out.println("Gudang " + namaGudang[i]);
            for (int j = 0; j < baris; j++){
                System.out.print("Stok barang " + namaBarang[j] + "    : ");
                barang[i][j] = Integer.parseInt(sc.nextLine());
                a = a + barang[i][j];
            }
            totalBarangGudang[i] = a;
            a = 0;
        }
        for (int j = 0; j < baris; j++){
            for(int i = 0; i < kolom; i++){
                if(i == 0){
                    b = 0;
                }
                else{
                    b = b + barang[i][j];
                }
            }
            totalBarang[j] = b + barang[0][j];
        }
        System.out.println("==============");
        System.out.println("\nTabel Inventaris Gudang");
        for (int i = 0; i < kolom; i++){
            System.out.print(namaGudang[i] + "\t");
        }
        System.out.println("");
        for (int i = 0; i < baris; i++){
            for (int j = 0; j < kolom; j++){
                System.out.print(barang[j][i] + "\t");
            }
            System.out.print(namaBarang[i] + "\t");
            System.out.println();
        }
        System.out.println("==Total Stok Per Barang==");
        for (int i =0; i < baris; i++){
            System.out.println("Total Stok " + namaBarang[i] + "\t: " + totalBarang[i]);
        }
        System.out.println("==Total Stok Per Gudang==");
        for (int i =0; i < kolom; i++){
            System.out.println("Total Stok Gudang " + namaGudang[i] + "\t: " + totalBarangGudang[i]);
        }
        System.out.println("==Peringatan Stock Rendah==");
        int check = 0;
        for (int i = 0; i < kolom; i++){
            for (int j = 0; j < baris; j++){
                if (barang[i][j] < 10){
                    System.out.println("Stock barang " + namaBarang[j] + " di Gudang " + namaGudang[i] + " tersisa " + barang[i][j] + " unit.");
                }
                else {
                    System.out.print("");
                }
                if (check > 0){
                    System.out.println("Semua Stock Masih Cukup.");
                }
                else{

                }
            }
        }
        System.out.println("=============");
        sc.close();
    }
}
