package week6;
import java.util.*;

public class latihanuts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Data Umum Program Kerja HMSI");
        System.out.print("Masukkan Tahun Ajaran Proker HMSI: ");
        String thnAjr = sc.nextLine();

        float anggaranAwal = 0;
        float sisaAnggaran = 0;
        System.out.print("Masukkan Anggaran HMSI tahun " + thnAjr + ": ");
        try {
            anggaranAwal = Float.parseFloat(sc.nextLine());
            sisaAnggaran = anggaranAwal;
        } catch (NumberFormatException e) {
            System.out.println("Input anggaran tidak valid!");
            return;
        }

        System.out.print("Masukkan Berapa Banyak Divisi dalam HMSI: ");
        int jumlahDivisi = Integer.parseInt(sc.nextLine());

        String[] semuaDivisi = new String[jumlahDivisi];

        // Anggota
        String[] semuaAnggota = new String[100];
        String[] divisiAnggota = new String[100];
        int indexAnggota = 0;

        // Kegiatan
        String[] nama_kegiatan = new String[100];
        String[] jadwal_kegiatan = new String[100];
        float[] anggaran_kegiatan = new float[100];
        String[] divisi_kegiatan = new String[100];
        int index_kegiatan = 0;

        // Input data per divisi
        for (int i = 0; i < jumlahDivisi; i++) {
            System.out.print("Masukkan Nama Divisi ke-" + (i + 1) + ": ");
            semuaDivisi[i] = sc.nextLine();

            System.out.print("Berapa Anggota untuk Divisi " + semuaDivisi[i] + "? ");
            int jumlahAnggota = Integer.parseInt(sc.nextLine());

            for (int j = 0; j < jumlahAnggota; j++) {
                System.out.print("Masukkan Nama Anggota ke-" + (j + 1) + " dari Divisi " + semuaDivisi[i] + ": ");
                semuaAnggota[indexAnggota] = sc.nextLine();
                divisiAnggota[indexAnggota] = semuaDivisi[i];
                indexAnggota++;
            }

            System.out.print("Berapa Kegiatan untuk Divisi " + semuaDivisi[i] + "? ");
            int jumlahKegiatan = Integer.parseInt(sc.nextLine());

            for (int k = 0; k < jumlahKegiatan; k++) {
                System.out.println("Kegiatan ke-" + (k + 1) + " untuk Divisi " + semuaDivisi[i]);

                System.out.print("Nama Kegiatan: ");
                String namaKeg = sc.nextLine();

                System.out.print("Bulan Kegiatan: ");
                String bulanKeg = sc.nextLine();

                System.out.print("Anggaran Kegiatan: ");
                float anggaranKeg = Float.parseFloat(sc.nextLine());

                if (anggaranKeg > sisaAnggaran) {
                    System.out.println("Jumlah anggaran terlalu besar. Kegiatan tidak disimpan.\n");
                    continue;
                }

                sisaAnggaran -= anggaranKeg;

                nama_kegiatan[index_kegiatan] = namaKeg;
                jadwal_kegiatan[index_kegiatan] = bulanKeg;
                anggaran_kegiatan[index_kegiatan] = anggaranKeg;
                divisi_kegiatan[index_kegiatan] = semuaDivisi[i];
                index_kegiatan++;

                System.out.println("Kegiatan berhasil dicatat. Sisa anggaran: " + sisaAnggaran + "\n");
            }
        }

        // OUTPUT
        System.out.println("\n=== DATA ANGGOTA HMSI ===");
        for (int i = 0; i < indexAnggota; i++) {
            System.out.println((i + 1) + ". Divisi: " + divisiAnggota[i] + " | Anggota: " + semuaAnggota[i]);
        }

        System.out.println("\n=== DAFTAR KEGIATAN HMSI ===");
        for (int i = 0; i < index_kegiatan; i++) {
            System.out.println((i + 1) + ". Divisi: " + divisi_kegiatan[i] +
                " | Kegiatan: " + nama_kegiatan[i] +
                " | Bulan: " + jadwal_kegiatan[i] +
                " | Anggaran: " + anggaran_kegiatan[i]);
        }

        System.out.println("\nSisa anggaran akhir: " + sisaAnggaran);
    }
}
