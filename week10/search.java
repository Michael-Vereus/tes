package week10;
import java.util.*;

public class search {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in) ;
        System.out.println("==== Aplikasi Inventaris Gudang ====");
        System.out.print("Banyak Barang   : ");
        int quantity = Integer.parseInt(sc.nextLine());
        String[] nama = new String[quantity];
        int[] stok = new int[quantity];
        System.out.println("INPUT NAMA BARANG");

        //input nama barang
        for (int i = 0; i <quantity; i++) {
            System.out.print("Nama Barang ke - " + (i+1) + " : ");
            nama[i] = sc.nextLine();
        }
        
        //input stock per barang
        for (int i = 0; i < quantity; i++) {
            System.out.print("Stock " + nama[i] + " : ");
            stok[i] = Integer.parseInt(sc.nextLine());
        }

        //check stock per barang
        for (int i = 0; i < quantity; i++) {
            int stokBarang = stok[i];
            String namaBarang = nama[i];
            String kondisi = "";
            int status = checkStockBarang(stokBarang);
            switch (status) {
                case 2:
                    kondisi = "Banyak";
                    
                break;
                case 1:
                    kondisi = "Segera Jadwalkan Restock (<50)";
                break;
                case 0:
                    kondisi = "STOCK HAMPIR HABIS(<10)";
                break;
                default:
                    throw new AssertionError();
            }
        }
        
    }
    public static int checkStockBarang(int stokBarang) {
        if (stokBarang < 10) {
            return 0;
        }
        else if (stokBarang < 50) {
            return 1;
        }
        else {
            return 2;
        }
    }
    public static void warning(String kondisi) {
        System.out.println("Status Stok : " + kondisi);
    }
}
