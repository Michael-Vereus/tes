package week4;
import java.util.*;

public class penumpang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        int n = 2 ;
        for (i = 1; i < n;i++){
            System.out.println("Selamat datang di Aplikasi Penghitung Jumlah Armada");
            System.out.println("Apa yang ingin anda lakukan hari ini ?");
            System.out.println("1. Hitung Jumlah Armada");
            System.out.println("2. Keluar");
            int num = 0;
            try {
                num = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            if(num == 1){
                System.out.println("Masukkan Jumlah Penumpang");
                int penumpang = 0;
                int sisabagi = 0;
                try {
                    penumpang = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                int kapasitasBus = 50;
                int kapasitasMinibus = 15;
                int kapasitasMobil = 7;
                int sisa = penumpang;

                int jumlahBus = sisa / kapasitasBus;
                System.out.println(sisa);
                sisa = sisa % kapasitasBus;
                System.out.println(sisa);

                int jumlahMinibus = sisa / kapasitasMinibus;
                sisa = sisa % kapasitasMinibus;
                System.out.println(sisa);


                int jumlahMobil = sisa / kapasitasMobil;
                sisa = sisa % kapasitasMobil;
                System.out.println(sisa);


                if (sisa > 0) {
                    jumlahMobil += 1;
                }
                System.out.println("Jumlah armada yang dibutuhkan:");
                System.out.println("Bus: " + jumlahBus);
                System.out.println("Minibus: " + jumlahMinibus);
                System.out.println("Mobil: " + jumlahMobil);

            }
            else if (num == 2) {
                n = i-2;
                System.out.println("Bye Bye");
            }
        }
        
    }
}
