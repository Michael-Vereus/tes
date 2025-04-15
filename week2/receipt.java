package week2;

import java.util.Scanner;

public class receipt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Masukkan Nama Pelanngan");
        String nama = sc.nextLine();
        System.out.println("Masukkan Produk Apa yang dibeli");
        String namaProduk = sc.nextLine();
        System.out.println("Masukkan Jumlah Produk");
        float kuantitas = sc.nextFloat();
        System.out.println("Masukkan Harga");
        float harga = sc.nextFloat();
        System.out.println("Masukkan diskon yang didapat(dalam persen)");
        float diskon = sc.nextFloat();
        float totalHarga = kuantitas*harga ;
        float hargaDiskon = totalHarga*diskon/100;
        float grandTotal = totalHarga - hargaDiskon;
        System.out.println("---------------------");
        System.out.println(nama);
        System.out.println(namaProduk);
        System.out.println(kuantitas);
        System.out.println(harga);
        System.out.println(diskon);
        System.out.println(totalHarga);
        System.out.println(grandTotal);
        System.out.println("---------------------");
    }
}