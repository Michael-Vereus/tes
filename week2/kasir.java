package week2;

import java.util.Scanner;

public class kasir {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Selamat Datang di Kasir 1.0");
        System.out.println("Masukkan Berapa Produk yang Ingin anda Masukkan");
        int a = sc.nextInt();
        int [] namaArr = new int[a];
        System.out.println("Masukkan Nama - Nama Produknya");
        for (int i = 0 ; i < a ; i++ ){
            if(sc.hasNextInt()){
                namaArr[i] = sc.nextInt();
                
            }
        }
        System.out.println("List :");
        for (int i = 0 ; i < a ; i++){
            System.out.println(namaArr[i]+ "");
        }
        sc.close();
    }
}
