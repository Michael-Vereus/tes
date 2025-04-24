package week4;
import java.util.*;


public class biayapdam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Masukkan Jumlah penumpang yang ingin diinput");
        int ii = 0;
        int n = 0 ;
        try {
            n = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        String[] nama_Penumpang = new String[n];
        int[] asal = new int[n];
        int asal1 = 0 ;
        int[] tujuan = new int[n];
        int tujuan1 = 0 ;
        int[] maskapai = new int[n];
        int maskapai1 = 0;
        int[] bulan = new int[n];
        int bulan1 = 0 ;
        int[] tanggalb = new int[n];
        int tanggal1 = 0 ;
        int[] tanggalp = new int[n] ;
        int tanggal2 = 0 ;
        for (int i = 0; i < n ;i++){
            ii = i+1;
            System.out.println("Masukkan nama penumpang ke " + ii);
            nama_Penumpang[i] = sc.nextLine();
            System.out.println("Masukkan Asal penerbangan penumpang ke " + nama_Penumpang[i]);
            System.out.println("1. Surabaya");
            System.out.println("2. JAKARTA");
            System.out.println("3. Medan");
            System.out.println("KETIKKAN ANGKANYA SAJA!!!");
            try {
                asal1 = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            asal[i] = asal1;
            System.out.println("Masukkan Tujuan penerbangan penumpang ke " + nama_Penumpang[i]);
            System.out.println("1. Bali");
            System.out.println("2. Yogyakarta");
            System.out.println("KETIKKAN ANGKANYA SAJA!!!");
            try {
                tujuan1 = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            tujuan[i] = tujuan1 ;
            System.out.println("Masukkan Maskapai penerbangan penumpang ke " + nama_Penumpang[i]    );
            System.out.println("1. Air Asia");
            System.out.println("2. Lion Air");
            System.out.println("KETIKKAN ANGKANYA SAJA!!!");
            try {
                maskapai1 = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            maskapai[i] = maskapai1 ;
            System.out.println("Masukkan Bulan penerbangan penumpang ke " + nama_Penumpang[i]    );
            System.out.println("KETIKKAN ANGKA BULANNYA SAJA!!!");
            try {
                bulan1 = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            bulan[i] = bulan1;
            System.out.println("Masukkan Tanggal Keberangkatan penerbangan penumpang ke " + nama_Penumpang[i]    );
            System.out.println("KETIKKAN ANGKA TANGGAL SAJA!!!");
            try {
                tanggal1 = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            tanggalb[i] = tanggal1 ;
            System.out.println("Masukkan Tanggal Pulang penerbangan penumpang ke " + nama_Penumpang[i]    );
            System.out.println("KETIKKAN ANGKA TANGGAL SAJA!!!");
            try {
                tanggal1 = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            tanggalp[i] = tanggal2 ;
            if (tujuan[i] == 1 ){
                if(asal[i] == 1){
                    if(bulan[i] == 2){

                    }
                    else if(bulan[i] == 3){
                    
                    }
                    else{
                        System.out.println("Tidak ada tiket untuk di bulan tsb");
                    }
                }
                else if(asal[i] == 2){

                }
                else if(asal[i] == 3){

                }
                else {
                    System.out.println("Tujuan tidak ter indeks");
                }
            }
            else if (tujuan[i] == 2){
                if(asal[i] == 2){
                    
                }
                else{
                    System.out.println("Tidak ada tiket untuk kota tujuan");
                }
            }
        }
    }
}
