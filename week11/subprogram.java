package week11;
import java.util.*;

public class subprogram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("===========");
        System.out.print("Banyak Mahasiswa : ");
        int kolom = Integer.parseInt(sc.nextLine());
        System.out.print("Banyak Mata Kuliah : ");
        int baris = Integer.parseInt(sc.nextLine());
        double[][] nilaiTugas = new double[kolom][baris];
        double[][] nilaiUTS = new double[kolom][baris];
        double[][] nilaiUAS = new double[kolom][baris];
        double[][] nilaiAkhir = new double[kolom][baris];
        String[] namaMhs = new String[kolom];
        String[] namaMatkul = new String[baris];
        //double[][] rataMhs = new double[kolom][baris];

        //input namaMHS
        System.out.println("======");
        for (int i = 0; i < kolom; i++){
            namaMhs[i] = inputNama(i,sc);
        }
        System.out.println("======");
        //input namaMatkul
        for (int i = 0; i < baris; i++){
            namaMatkul[i] = inputMatkul(i,sc);
        }

        //input nilai para mhs
        for (int i = 0; i < kolom; i++){
            System.out.println("== " + namaMhs[i] + " ==");
            for (int j = 0; j < baris; j++){
                String namaMtl = namaMatkul[j];
                nilaiTugas[i][j] = inputTugas(sc, namaMtl);
                nilaiUTS[i][j] = inputUts(sc, namaMtl);
                nilaiUAS[i][j] = inputUas(sc, namaMtl);
                System.out.println("-------------");
            } 
        }

        //proses nilai akhir
        for (int i = 0; i < kolom; i++){
            for (int j = 0; j < baris; j++){
                double ntgs = nilaiTugas[i][j];
                double nuts = nilaiUTS[i][j];
                double nuas = nilaiUAS[i][j];
                nilaiAkhir[i][j] = prosesNA(ntgs, nuts, nuas);
            }
        }

        //output akhir
        System.out.println("");
        System.out.println("");
        System.out.println("==Rapot Para Mhs==");
        outputMhs(nilaiAkhir, nilaiUAS, nilaiUTS, nilaiUAS, namaMhs, namaMatkul, baris, kolom);
        
    }
    public static String inputNama(int i, Scanner sc){
        System.out.print("Nama Mahasiswa ke - " + (i+1) + " : ");
        String nama = sc.nextLine();
        return nama;
    }
    public static String inputMatkul(int i, Scanner sc){
        System.out.print("Nama Matkul ke - " + (i+1) + " : ");
        String namaMatkul = sc.nextLine();
        return namaMatkul;
    }
    public static double inputTugas(Scanner sc, String namaMtl){
        System.out.print("Nilai Tugas " + namaMtl + " : ");
        double nilaiTgs = Integer.parseInt(sc.nextLine());
        return nilaiTgs;
    }
    public static double inputUts(Scanner sc, String namaMtl){
        System.out.print("Nilai UTS " + namaMtl + " : ");
        double nilaiUts = Integer.parseInt(sc.nextLine());
        return nilaiUts;
    }
    public static double inputUas(Scanner sc, String namaMtl){
        System.out.print("Nilai UAS " + namaMtl + " : ");
        double nilaiUas = Integer.parseInt(sc.nextLine());
        return nilaiUas;
    }
    public static double  prosesNA(double ntgs, double nuts, double nuas){
        double na = 0.6 * ntgs + 0.2 * nuts + 0.2 * nuas ;
        return na;
    }
    /*
    public static double  avg(double ntgs, double nuts, double nuas){
        double avg = (ntgs+nuts+nuas)/3;
        return avg;
    }
    */
    public static void outputMhs(double[][] nilaiAkhir, double[][] nilaiTgs, double[][] nilaiUTS, double[][] nilaiUAS, String[] namaMhs, String[] namaMatkul, int baris, int kolom){
        for (int i = 0; i < kolom; i++){
            System.out.println("== " + namaMhs[i] + " ==");
            for(int j = 0; j < baris; j++){
                System.out.println("====="+ namaMatkul[j]+"=====");
                System.out.println("Nilai Tugas " + namaMatkul[j] + " : " + nilaiTgs[i][j]);
                System.out.println("Nilai UTS " + namaMatkul[j] + " : " + nilaiUTS[i][j]);
                System.out.println("Nilai UAS " + namaMatkul[j]+ " : " + nilaiUAS[i][j]);
                System.out.println("Nilai Akhir " + namaMatkul[j] + " : " + nilaiAkhir[i][j] );
            }
        }
    }
}
