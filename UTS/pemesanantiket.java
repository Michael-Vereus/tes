package UTS;
import java.util.*;
public class pemesanantiket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tanggal_penerbangan = new String[100];
        String[] waktu_penerbangan = new String[100];
        String[] maskapai_penerbangan = new String[100];
        String[] kota_asal = new String[100];
        String[] kota_tujuan = new String[100];
        String[] nama_pemesan = new String[100];
        String[] nama_penumpang = new String[100];
        String[] nik_penunpang = new String[100];
        int[] jumlah_penumpang = new int[100];
        float[] harga_tiket = new float[100];
        

        String[] riwayat_tanggal = new String[100];
        String[] riwayat_waktu = new String[100];
        String[] riwayat_maskapai = new String[100];
        String[] riwayat_asal = new String[100];
        String[] riwayat_tujuan = new String[100];
        float[] riwayat_harga = new float[100];
        float totalHarga = 0;

        int index = 0;
        int riwayatIndex = 0;
        while(true){
            System.out.println("===== TiketDotCom =====");
            System.out.println("1. Entry Data");
            System.out.println("2. Pesan Tiket");
            System.out.println("3. Riwayat");
            System.out.println("4. Keluar");
            System.out.println("=======================");
            String menu = sc.nextLine();
            switch (menu){
                case "1" : 
                System.out.println("Berapa banyak jadwal penerbangan yang ingin anda entry hari ini ? ");
                int quantity = Integer.parseInt(sc.nextLine());
                for (int i = 0; i < quantity;i++) {
                    System.out.println("=============================");
                    System.out.print("Tanggal Penerbangan (DD / MM / YY ) : ");
                    tanggal_penerbangan[index] = sc.nextLine();
                    System.out.print("Waktu Penerbangan                   : ");
                    waktu_penerbangan[index] = sc.nextLine();
                    System.out.print("Maskapai Penerbangan                : ");
                    maskapai_penerbangan[index] = sc.nextLine();
                    System.out.print("Kota Asal                           : ");
                    kota_asal[index] = sc.nextLine().trim();
                    System.out.print("Kota Tujuan                         : ");
                    kota_tujuan[index] = sc.nextLine().trim();
                    System.out.print("Harga tiket                         : ");
                    harga_tiket[index] = Float.parseFloat(sc.nextLine());
                    System.out.println("=============================");
                    index++;
                }
                
                break;

                case "2" : 
                System.out.println("=== Pesan Tiket ===");
                System.out.print("Cari Kota Asal   : ");
                String query_asal = sc.nextLine().trim();
                System.out.print("Cari Kota Tujuan : ");
                String query_tujuan = sc.nextLine().trim();
                boolean ditemukan = false;

                ArrayList<Integer> queryResult = new ArrayList<>();
                    System.out.println("=== Hasil Pencarian Tiket ===");
                    for (int i = 0; i < index; i++) {
                        if (kota_asal[i].equalsIgnoreCase(query_asal) && kota_tujuan[i].equalsIgnoreCase(query_tujuan)) {

                            queryResult.add(i);
                            int nomor = queryResult.size(); 
                            System.out.println("[" + nomor + "]");
                            System.out.println("=== Hasil Pencarian ===");
                            System.out.println("Tanggal  : " + tanggal_penerbangan[i]);
                            System.out.println("Waktu    : " + waktu_penerbangan[i]);
                            System.out.println("Maskapai : " + maskapai_penerbangan[i]);
                            System.out.println("Harga    : Rp " + harga_tiket[i]);
                            
                            ditemukan = true;
                        }
                    
                    }
                    if (queryResult.isEmpty()) {
                            System.out.println("Tidak ada penerbangan dari " + query_asal + " ke " + query_tujuan);
                        } else {
                            System.out.print("Pilih tiket yang ingin anda beli [masukkan nomor]: ");
                            int option = Integer.parseInt(sc.nextLine());
                            System.out.print("Pemesan          : ");
                            nama_pemesan[riwayatIndex] = sc.nextLine();
                            System.out.print("Jumlah Penumpang : ");
                            jumlah_penumpang[riwayatIndex] = Integer.parseInt(sc.nextLine());
                            System.out.println("==== Data Penumpang ====");
                            for(int k = 0; k < jumlah_penumpang[riwayatIndex];k++){
                                System.out.print("Masukkan Nama Penumpang  : ");
                                nama_penumpang[riwayatIndex] = sc.nextLine();
                                System.out.print("Masukkan NIK Penumpang   : ");
                                nik_penunpang[riwayatIndex] = sc.nextLine();
                                System.out.println("");
                            }
                            if (option >= 1 && option <= queryResult.size()) {
                                int idx = queryResult.get(option - 1);
                                System.out.println("=== Struk Pembelian ===");
                                System.out.println("Tanggal     : " + tanggal_penerbangan[idx]);
                                System.out.println("Waktu       : " + waktu_penerbangan[idx]);
                                System.out.println("Maskapai    : " + maskapai_penerbangan[idx]);
                                System.out.println("Kota Asal   : " + kota_asal[idx]);
                                System.out.println("Kota Tujuan : " + kota_tujuan[idx]);
                                System.out.println("Harga       : Rp " + harga_tiket[idx]);
                                System.out.println("==> Tiket berhasil dipesan!");

                                riwayat_tanggal[riwayatIndex] = tanggal_penerbangan[idx];
                                riwayat_maskapai[riwayatIndex] = maskapai_penerbangan[idx];
                                riwayat_waktu[riwayatIndex] = waktu_penerbangan[idx];
                                riwayat_asal[riwayatIndex] = kota_asal[idx];
                                riwayat_tujuan[riwayatIndex] = kota_tujuan[idx];
                                riwayat_harga[riwayatIndex] = harga_tiket[idx];
                                riwayatIndex++;

                            } else {
                                System.out.println("Nomor tiket tidak valid.");
                            }
                        }
                        
                    if (!ditemukan) {
                        System.out.println("Tidak ada penerbangan dari " + query_asal + " ke " + query_tujuan);
                    }
                    System.out.println("=============================");
                break;

                case "3" : 
                    System.out.println(" === Riwayat Pembelian Tiket ===");
                    if(riwayatIndex == 0){
                        System.out.println("Tidak ada tiket yang dipesan.");
                    }
                    else{
                        for (int x = 0; x < riwayatIndex; x++){
                            System.out.println("[" + (x + 1) + "]");
                            System.out.println("Nama Pemesan         : " + nama_pemesan[x]);
                            System.out.println("Nama Penumpang       : " + nama_penumpang[x]);
                            System.out.println("NIK Penumpang        : " + nik_penunpang[x]);
                            System.out.println("Jumlah Penumpang     : " + jumlah_penumpang[x]);
                            System.out.println("Tanggal              : " + riwayat_tanggal[x]);
                            System.out.println("Maskapai             : " + riwayat_maskapai[x]);
                            System.out.println("Asal                 : " + riwayat_asal[x]);
                            System.out.println("Waktu                : " + riwayat_waktu[x]);
                            System.out.println("Tujuan               : " + riwayat_tujuan[x]);
                            System.out.println("Harga Tiket /orang   : Rp " + riwayat_harga[x]);
                            totalHarga = riwayat_harga[x] * jumlah_penumpang[x];
                            if (totalHarga > 1500000){
                                float diskon = totalHarga * 10 / 100;
                                totalHarga = totalHarga - diskon;
                            }
                            System.out.println("Total Harga          : Rp " + (totalHarga));
                            
                            System.out.println("-----------------------------");
                        }
                    }
                break;

                case "4" :
                System.out.println("Terima kasih, selamat bepergian !");
                return;
            }
        }
    }
}
