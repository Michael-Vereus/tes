package week14;

import java.time.LocalTime;
import java.util.*;

class hadirin{
    String nama;
    LocalTime jam;

    public hadirin(String nama, LocalTime jam){
        this.nama = nama;
        this.jam = jam;
    }
}
class inputHandler{
    ArrayList<hadirin> listHadirin = new ArrayList<>();
    Scanner sc;
    public inputHandler(Scanner sc){
        this.sc = sc;
    }

    public void tambahHadirin(){
        boolean loop = true;
        while(loop){
            System.out.print("Masukkan Nama Depan    : ");
            String tempNama = sc.nextLine().trim();
            LocalTime tempJam = null;
            while (true) {
                try{
                    System.out.print("Masukkan Jam Kehadiran (HH:mm) : ");
                    String inputJam = sc.nextLine().trim();
                    tempJam =  LocalTime.parse(inputJam);
                    break;
                } catch (Exception e) {
                    System.out.println("Format jam salah ! Harus dalam format HH : mm (08:30)");
                }
            }
            listHadirin.add(new hadirin(tempNama,tempJam));
            while (true) {
                System.out.print("Tambah lagi ? (Y/n)");
                String add = sc.nextLine();
                if (add.equalsIgnoreCase("Y")){
                    break;
                } else if (add.equalsIgnoreCase("n")){
                    loop = false;
                    break;
                } else {
                    System.out.println("Error");
                }
            }
        }
    }
    public void lihatHadirin(){
        if(listHadirin.isEmpty()){
            System.out.println("Daftar hadir kosong.");
            return;
        }
        System.out.printf("%-4s %-15s %-10s\n", "No", "Nama", "Jam");
        System.out.println("-----------------------------------------");
        for(int i = 0; i < listHadirin.size(); i++){
            hadirin h = listHadirin.get(i);
            System.out.printf("%-4s %-15s %-10s\n", (i+1), h.nama, h.jam);
        }
        System.out.println("------------------------------------------");
    }
    public void cariHadirin(){
        boolean cari = true;
        while (cari){
            System.out.print("Search nama : ");
            String query = sc.nextLine().trim();
            for (int i =0; i < listHadirin.size(); i++){
                hadirin h = listHadirin.get(i);
                if(h.nama.toLowerCase().contains(query)){
                    System.out.printf("%-4s %-15s %-10s\n", (i+1), h.nama, h.jam);
                }
                else {
                    System.out.println("Nama tidak ditemukan.");
                }
            }
            while (true) {
                System.out.print("Cari lagi ? (Y/n)");
                String add = sc.nextLine();
                if (add.equalsIgnoreCase("Y")){
                    break;
                } else if (add.equalsIgnoreCase("n")){
                    cari = false;
                    break;
                } else {
                    System.out.println("Error");
                }
            }
        }
    }

    public void hapusHadirin(){
        boolean erase = true;
        if(listHadirin.isEmpty()){
            System.out.println("Daftar Hadir Kosong");
            return;
        }
        while (erase){
            lihatHadirin();
            System.out.println("Masukkan angka nya : ");
            String rm = sc.nextLine().trim();
            try{
                int index = Integer.parseInt(rm) - 1;
                if(index >= 0 && index < listHadirin.size()){
                    hadirin removed = listHadirin.remove(index);
                    System.out.println(" '" + removed.nama + "' Berhasil Dihapus." );
                } else {
                    System.out.println("Pilihan invalid\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka");
            }
            while (true) {
                System.out.print("Hapus lagi ? (Y/n)");
                String add = sc.nextLine();
                if (add.equalsIgnoreCase("Y")){
                    break;
                } else if (add.equalsIgnoreCase("n")){
                    erase = false;
                    break;
                } else {
                    System.out.println("Error");
                }
            }
        }
    }
}

public class inputDaftarHadir {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean runtime = true;
        inputHandler ih = new inputHandler(sc);
        while (runtime){
            menu();
            String opsi = sc.nextLine().trim();
            switch (opsi) {
                case "1" :
                    ih.tambahHadirin();
                    break;
                case "2" :
                    ih.lihatHadirin();
                    break;
                case "3" :
                    ih.cariHadirin();
                    break;
                case "4" :
                    ih.hapusHadirin();
                    break;
                case "0" :
                    System.out.println("Bye bye");
                    runtime = false;
                    break;

            }
            pause();
        }
    }
    //menu
    public static void menu(){
        System.out.println("=== Input Daftar Hadir ===");
        System.out.println("1. Input Daftar Hadir");
        System.out.println("2. Lihat Daftar Hadir");
        System.out.println("3. Cari Daftar Hadir");
        System.out.println("4. Hapus Daftar Hadir");
        System.out.println("0. Exit");
        System.out.print("Pilih opsi : ");
    }
    //pause
    public static void pause(){
        System.out.println("Press Any Key To Continue");
        String ctn = sc.nextLine();
        if(ctn.equals("")){
        }
        else {
        }
    }
}