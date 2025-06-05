package week14;
import java.util.*;

public class ourStore {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> namaStock = new ArrayList<>();
    static ArrayList<Integer> Stock = new ArrayList<>();
    static ArrayList<Double> hargaPer = new ArrayList<>();
    static ArrayList<ArrayList<String>> riwayatNamaBarang = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> riwayatJumlahBarang = new ArrayList<>();
    static ArrayList<Double> totalPerTransaksi = new ArrayList<>();
    static String optMenu;
    static double harga = 0;

    public static void main(String[] args) {
        while (true) {
            menu();
            optMenu = sc.nextLine();
            switch (optMenu) {
                case "1":
                    inputStock();
                    break;
                case "2":
                    cekStock();
                    break;
                case "3":
                    inputPembelian();
                    break;
                case "4":
                    riwayatTransaksi();
                    break;
                case "0":
                    System.out.println("Terima kasih telah menggunakan Our Store!");
                    System.exit(0);
                    break;
            }
            while (true) {
                System.out.println("Tekan Any Key to Continue");
                String ans = sc.nextLine();
                if (ans.equalsIgnoreCase("a")) {
                    break;
                } else {
                    break;
                }
            }
        }
    }

    public static void menu() {
        System.out.println("------ OUR STORE ------");
        System.out.println("1. Input Stok Barang");
        System.out.println("2. Cek Stok Barang");
        System.out.println("3. Input Pembelian");
        System.out.println("4. Riwayat Transaksi");
        System.out.println("0. Exit");
        System.out.print("Pilih Menu : ");
    }

    public static void inputStock() {
        while (true) {
            System.out.println("Stock Barang (ketik -1 untuk berhenti)");
            System.out.println("---------------------------");
            System.out.print("Nama Barang       : ");
            String nameTemp = sc.nextLine();
            if (nameTemp.equals("-1")) {
                break;
            }
            System.out.print("Banyak Stock      : ");
            int temp = Integer.parseInt(sc.nextLine());
            System.out.print("Harga Per Buah    : ");
            double priceTemp = Double.parseDouble(sc.nextLine());
            if (temp < 0) {
                System.out.println("invalid stock");
            } else {
                boolean notfound = true;
                for (int i = 0; i < namaStock.size(); i++) {
                    if (namaStock.get(i).equalsIgnoreCase(nameTemp)) {
                        int change = Stock.get(i) + temp;
                        Stock.set(i, change);
                        notfound = false;
                        break;
                    }
                }
                if (notfound) {
                    namaStock.add(nameTemp);
                    Stock.add(temp);
                    hargaPer.add(priceTemp);
                }
            }
        }
    }

    public static void inputPembelian() {
        boolean status = true;
        double totalHarga = 0;
        ArrayList<String> barangDalamTransaksi = new ArrayList<>();
        ArrayList<Integer> jumlahDalamTransaksi = new ArrayList<>();

        while (status) {
            String temp = "";
            boolean checkBarang = true;
            double price = 0;
            int indexBarang = -1;

            while (checkBarang) {
                System.out.print("Nama Barang : ");
                temp = sc.nextLine();
                for (int i = 0; i < namaStock.size(); i++) {
                    if (temp.equalsIgnoreCase(namaStock.get(i))) {
                        checkBarang = false;
                        price = hargaPer.get(i);
                        indexBarang = i;
                        break;
                    }
                }
                if (checkBarang) {
                    System.out.println("Error Produk Tidak Ditemukan.");
                }
            }

            int qTemp = 0;
            boolean checkStock = true;
            while (checkStock) {
                System.out.print("Kuantitas   : ");
                qTemp = Integer.parseInt(sc.nextLine());

                if (qTemp > Stock.get(indexBarang)) {
                    System.out.println("Stock produk " + namaStock.get(indexBarang) + " tersisa : " + Stock.get(indexBarang));
                    System.out.println("Apakah Anda Ingin Ubah Jumlah Pembelian produk ini ? (Y/n)");
                    String ans = sc.nextLine();
                    if (ans.equalsIgnoreCase("n")) {
                        checkStock = false;
                        qTemp = 0;
                    } else if (ans.equalsIgnoreCase("Y")) {
                        continue;
                    }
                } else if (qTemp < 0) {
                    System.out.println("Jumlah Barang Invalid Silahkan Re Input Lagi !");
                } else {
                    int newStock = Stock.get(indexBarang) - qTemp;
                    Stock.set(indexBarang, newStock);
                    checkStock = false;
                }
            }

            if (qTemp > 0) {
                barangDalamTransaksi.add(temp);
                jumlahDalamTransaksi.add(qTemp);
                totalHarga = totalHarga + (qTemp * price);
            }

            while (true) {
                System.out.println("Tambah barang ? Y/n");
                String ans = sc.nextLine();
                if (ans.equalsIgnoreCase("Y")) {
                    break;
                } else if (ans.equalsIgnoreCase("n")) {
                    status = false;
                    break;
                }
            }
        }

        riwayatNamaBarang.add(barangDalamTransaksi);
        riwayatJumlahBarang.add(jumlahDalamTransaksi);
        totalPerTransaksi.add(totalHarga);
        harga += totalHarga;

        System.out.println("Total Harga Transaksi Ini: Rp. " + totalHarga);
    }

    public static void cekStock() {
        System.out.print("Masukkan nama barang : ");
        String search = sc.nextLine();

        for (int i = 0; i < namaStock.size(); i++) {
            if (namaStock.get(i).equalsIgnoreCase(search)) {
                System.out.println("Nama Barang : " + namaStock.get(i));
                System.out.println("Stock       : " + Stock.get(i));
            }
        }
    }

    public static void riwayatTransaksi() {
        if (riwayatNamaBarang.size() == 0) {
            System.out.println("Belum ada transaksi yang dilakukan.");
            return;
        }

        System.out.println("------ Riwayat Transaksi ------");
        for (int i = 0; i < riwayatNamaBarang.size(); i++) {
            System.out.println("Transaksi #" + (i + 1));
            ArrayList<String> barang = riwayatNamaBarang.get(i);
            ArrayList<Integer> jumlah = riwayatJumlahBarang.get(i);
            for (int j = 0; j < barang.size(); j++) {
                int indexHarga = namaStock.indexOf(barang.get(j));
                double hargaBarang = hargaPer.get(indexHarga);
                System.out.println("- " + barang.get(j) + " x " + jumlah.get(j) + " = Rp. " + (jumlah.get(j) * hargaBarang));
            }
            System.out.println("Total Transaksi: Rp. " + totalPerTransaksi.get(i));
            System.out.println("----------------------------------");
        }
        System.out.println("Total Semua Transaksi: Rp. " + harga);
    }
}
