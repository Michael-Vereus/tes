import java.util.*;

public class trial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double diskon = 0;
        //untuk menampilkan daftar dan layanan untuk pelanggan memilih 
        String[][] layananSalon = {
            {"Keramas" , "15000"},
            {"Cut Hair" , "25000"},
            {"Smoothing" , "200000"},
            {"Hair Mask" , "35000"},
            {"Creambath" , "200000"}
        };
        //menyimpan jumlah harga  total layanan yang dipilih dan mengontrol perulangan selama pelanggan memilih
        int total = 0;
        String lanjut = "yes";
        System.out.println("=== WELCOME IN SALON ===");

        //setiap pelanggann mengatakan tes perulangan akan terus berjalan
        while (lanjut.equalsIgnoreCase("yes")) {

            while (true) {
            
            //menamilkan daftar layanan beserta harga
            System.out.println("DAFTAR LAYANAN");
            
            for (int i = 0; i < layananSalon.length; i++) {
                System.out.println((i + 1) + ", " + layananSalon[i][0] + " - Rp" + layananSalon[i][1]); //agar tampil 1-5 bukan 0-4
            }
            //pelanggan diminta untuk memilih layanan
            System.out.println("Pilih Nomor Layanan : ");
            int pilihan = input.nextInt();

            //untuk cek pilihan jika valid harga akan ditambah ke total  dan jika pilihan-1 akan dimulai dari indeks 0
            if(pilihan >= 1 && pilihan <= layananSalon.length) {
                int harga = Integer.parseInt(layananSalon[pilihan - 1][1]);
                total += harga;
                System.out.println("Layanan \"" + layananSalon[pilihan - 1][0] + "\" ditambahkan.");
            } else {
                System.out.println("Pilihan tidak valid");
            }
            //menentukan apakah pelanggan ingin tambah atau tidak
            System.out.println("Ingin tambah layanan lagi ? (y/n) : ");
            lanjut = input.next();
            if (lanjut.equals("n")){
                break;
            }
            else{}
            }
        }

        double totalAkhir = totalAkhir(total, diskon);
        double diskonOutput = total-totalAkhir;
        //untuk mencetak struk keseluruhan
        System.out.println("\n==== STRUK PEMBAYARAN ====");
        System.out.println("Total sebelum diskon    : Rp " + total);
        System.out.println("Diskon                  : Rp " + diskonOutput);
        System.out.println("Total Payment           : Rp " + totalAkhir);
        System.out.println("THANK YOUFOR KUNJUNGANNYA");

        input.close();
    }
    public static double totalAkhir(double total, double diskon){
        double totalAkhirTemp;
        //menghitungdiskon
        if (total > 100000) {
            diskon = total * 0.10;
        }
        else {
            diskon = 0;
        }
        totalAkhirTemp = total - diskon;
        return totalAkhirTemp;
    }
}

