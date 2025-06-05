package week12;
import java.util.*;

public class jadwalujian {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Selamat Datang ke dalam program input Jadwal Ujian");

        System.out.print("Masukkan Tahun Ujian        : ");
        String tahun = sc.nextLine();

        System.out.print("Jumlah Matkul Ujian Tulis   : ");
        int jumlahUjianTulis = Integer.parseInt(sc.nextLine());

        System.out.print("Jumlah Matkul Ujian Praktik : ");
        int jumlahUjianPraktik = Integer.parseInt(sc.nextLine());

        int totalUjian = jumlahUjianTulis + jumlahUjianPraktik;

        String[] namaMatkul = new String[totalUjian];
        int[] tanggalUjianTulis = new int[jumlahUjianTulis];
        String[] bulanUjianTulis = new String[jumlahUjianTulis];
        int[] tanggalUjianPraktik = new int[jumlahUjianPraktik];
        String[] bulanUjianPraktik = new String[jumlahUjianPraktik];
        int[][] jamUjian = new int[totalUjian][totalUjian];

        
        inputNamaDanJadwal(sc, jumlahUjianTulis, jumlahUjianPraktik, totalUjian, namaMatkul, tanggalUjianTulis, bulanUjianTulis, tanggalUjianPraktik, bulanUjianPraktik, jamUjian);
        while (true) {
            if (!cekBentrok(sc, tanggalUjianTulis, bulanUjianTulis, tanggalUjianPraktik, bulanUjianPraktik, namaMatkul, jumlahUjianTulis, jamUjian)) {
                break;
            }
        }
        outputJadwal(totalUjian, jumlahUjianTulis, namaMatkul, tanggalUjianTulis, tanggalUjianPraktik, bulanUjianPraktik, bulanUjianTulis, tahun, jamUjian);
    }

    // proses input nama n jadwal a.k.a plotting jadwal1hari max 2 ? saya buat kodenya lebih dinamis jadi user bisa bebas menginputkan tanggalnya sehingga nanti diakhirnya user bisa mengubah tanggal bila bertabrakan
    public static void inputNamaDanJadwal(Scanner sc, int jumlahUjianTulis, int jumlahUjianPraktik, int totalUjian, String[] namaMatkul, int[] tanggalUjianTulis, String[] bulanUjianTulis, int[] tanggalUjianPraktik, String[] bulanUjianPraktik, int[][] jamUjian) {
        //input nama matkul ujian tulis
        System.out.println("\n== Matakuliah Ujian Tulis ==");
        for (int i = 0; i < jumlahUjianTulis; i++) {
            System.out.print("Nama Matkul Ujian Tulis " + (i + 1) + " : ");
            namaMatkul[i] = sc.nextLine();
        }

        //input nama matkul ujian praktik
        System.out.println("\n== Matakuliah Ujian Praktik ==");
        for (int i = jumlahUjianTulis; i < totalUjian; i++) {
            System.out.print("Nama Matkul Ujian Praktik " + (i - jumlahUjianTulis + 1) + " : ");
            namaMatkul[i] = sc.nextLine();
        }

        //input jadwal ujian tulis
        System.out.println("\n== Input Jadwal Ujian Tulis ==");
        for (int i = 0; i < jumlahUjianTulis; i++) {
            System.out.print("Tanggal Ujian " + namaMatkul[i] + " : ");
            tanggalUjianTulis[i] = Integer.parseInt(sc.nextLine());
            System.out.print("Bulan Ujian " + namaMatkul[i] + " : ");
            bulanUjianTulis[i] = sc.nextLine();
            for (int j = i; j <= i; j++){
                int k = 1;
                System.out.print("Jam Mulai : ");
                jamUjian[i][0] = Integer.parseInt(sc.nextLine());
                System.out.print("Jam Berakhir : ");
                jamUjian[i][k] = Integer.parseInt(sc.nextLine());
            }
            System.out.println("---------------------------------------");
        }
        /* trial output ujian tulis
        for (int i = 0; i < jumlahUjianTulis; i++) {
            
            for (int j = i; j <= i; j++){
                int k = 1;
                System.out.print("Jam Mulai : " + jamUjian[i][0]);
                System.out.print("Jam Berakhir : " + jamUjian[i][k]);
            }
        }*/

        //input jadwal ujian praktek
        System.out.println("\n== Input Jadwal Ujian Praktik ==");
        for (int i = 0; i < jumlahUjianPraktik; i++) {
            System.out.print("Tanggal Ujian " + namaMatkul[jumlahUjianTulis + i] + " : ");
            tanggalUjianPraktik[i] = Integer.parseInt(sc.nextLine());
            System.out.print("Bulan Ujian " + namaMatkul[jumlahUjianTulis + i] + " : ");
            bulanUjianPraktik[i] = sc.nextLine();
            for (int j = i; j <= i; j++){
                int a = jumlahUjianTulis + i;
                int b = 1;
                System.out.print("Jam Mulai : ");
                jamUjian[a][0] = Integer.parseInt(sc.nextLine());
                System.out.print("Jam Berakhir : ");
                jamUjian[a][b] = Integer.parseInt(sc.nextLine());
            }
            System.out.println("---------------------------------------");
        }
        /* trial output ujian praktik
        for (int i = 0; i < (totalUjian - jumlahUjianTulis); i++) {
            for (int j = i; j <= i; j++){
                int a = jumlahUjianTulis + i;
                int b = 1;
                System.out.print("Jam Mulai : " + jamUjian[a][0]);
                System.out.print("Jam Berakhir : " + jamUjian[a][b]);
            }
        } */
    }

    //method check bentrok jadwal a.k.a cekjadwalujianyang tidak bersamaan, menurut saya bu jadwal demo bisa satu hari dengan ujian jadwal tulis selama jam nya tidak bertabrakan
    public static boolean cekBentrok(Scanner sc, int[] tanggalUjianTulis, String[] bulanUjianTulis, int[] tanggalUjianPraktik, String[] bulanUjianPraktik, String[] namaMatkul, int jumlahUjianTulis, int[][] jamUjian) {
        boolean adaBentrok = false;
        int totalUjian = tanggalUjianTulis.length + tanggalUjianPraktik.length;

        int[] semuaTanggal = new int[totalUjian];
        String[] semuaBulan = new String[totalUjian];

        //pindah data tanggal dan bulan ujian tulis ke array baru
        for (int i = 0; i < tanggalUjianTulis.length; i++) {
            semuaTanggal[i] = tanggalUjianTulis[i];
            semuaBulan[i] = bulanUjianTulis[i].toLowerCase();
        }
        
        //pindah data tanggal dan bulan ujian praktik ke array baru
        for (int i = 0; i < tanggalUjianPraktik.length; i++) {
            semuaTanggal[jumlahUjianTulis + i] = tanggalUjianPraktik[i];
            semuaBulan[jumlahUjianTulis + i] = bulanUjianPraktik[i].toLowerCase();
        }

        // proses checking bentrok atau gak        
        for (int i = 0; i < totalUjian; i++) {
            int count = 1;
            //membandingkan satu data dengan yg lain 
            for (int j = 0; j < totalUjian; j++) {
                if (i != j && semuaTanggal[i] == semuaTanggal[j] && semuaBulan[i].equals(semuaBulan[j])) {
                    count++;
                    if (jamUjian[i][1] > jamUjian[j][0]) {
                        System.out.print("\nAda Jadwal Bentrok apakah anda ingin mengganti jam ujian " + namaMatkul[j] + " (Y/n) : ");
                        String confirmation = sc.nextLine();
                        switch (confirmation) {
                            case "Y" : {
                                System.out.println("\nJam ujian bentrok di tanggal " + semuaTanggal[i] + " " + semuaBulan[i]);
                                System.out.println("Edit jadwal untuk   : " + namaMatkul[j]);
                                System.out.print("Jam Mulai Baru      : ");
                                jamUjian[j][0] = Integer.parseInt(sc.nextLine());
                                System.out.print("Jam Berakhir Baru   : ");
                                jamUjian[j][1] = Integer.parseInt(sc.nextLine());
                            }

                            case"n" : System.out.println("");
                        }
                        
                    }
                    else {

                    }
                }
            }
            if (count > 2) {
                System.out.println("\nError! Lebih dari 2 ujian di tanggal " + semuaTanggal[i] + " " + semuaBulan[i]);
                System.out.println("Edit jadwal untuk : " + namaMatkul[i]);
                System.out.print("Tanggal Baru : ");
                semuaTanggal[i] = Integer.parseInt(sc.nextLine());
                System.out.print("Bulan Baru   : ");
                semuaBulan[i] = sc.nextLine().toLowerCase();

                if (i < jumlahUjianTulis) {
                    tanggalUjianTulis[i] = semuaTanggal[i];
                    bulanUjianTulis[i] = semuaBulan[i];
                } else {
                    tanggalUjianPraktik[i - jumlahUjianTulis] = semuaTanggal[i];
                    bulanUjianPraktik[i - jumlahUjianTulis] = semuaBulan[i];
                }

                adaBentrok = true;
                break;
            }
        }

        if (!adaBentrok) {
            System.out.println("\nSemua Jadwal Ujian aman, tidak ada bentrok jadwal.");
        }

        return adaBentrok;
    }
    // proses output
    public static void outputJadwal(int totalUjian, int jumlahUjianTulis, String[] namaMatkul, int[] tanggalUjianTulis, int[] tanggalUjianPraktik, String[] bulanUjianPraktik, String[] bulanUjianTulis, String tahun, int[][] jamUjian) {
        System.out.println("\n== Jadwal Akhir " + tahun + " ==");
        // output jadwal ujian tulis
        for (int i = 0; i < jumlahUjianTulis; i++) {
            System.out.println("Ujian Tulis   : " + namaMatkul[i]);
            System.out.println("Tanggal       : " + tanggalUjianTulis[i] + " " + bulanUjianTulis[i]);
            for (int j = i; j <= i; j++){
                int k = 1;
                System.out.println("Jam Mulai     : " + jamUjian[i][0]);
                System.out.println("Jam Berakhir  : " + jamUjian[i][k]);
            }
        }
        // output jadwal ujian praktik
        for (int i = 0; i < (totalUjian - jumlahUjianTulis); i++) {
            System.out.println("Ujian Praktik : " + namaMatkul[i+jumlahUjianTulis]);
            System.out.println("Tanggal       : " + tanggalUjianPraktik[i]  + " " + bulanUjianPraktik[i]);
            for (int j = i; j <= i; j++){
                int a = jumlahUjianTulis + i;
                int b = 1;
                System.out.println("Jam Mulai     : " + jamUjian[a][0]);
                System.out.println("Jam Berakhir  : " + jamUjian[a][b]);
            }
        }
    }
}
