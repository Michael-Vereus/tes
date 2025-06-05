package week11;
import java.util.*;
public class luasfunction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("==Aplikasi Penghitung Luas==");
        while (true) {
            System.out.println("Menu");
            System.out.println("1. Hitung Luas");
            System.out.println("2. Hitung Keliling");
            System.out.println("3. Exit");
            String menuOpt = sc.nextLine();
            String bangunOpt = "";
            double panjang = 0;
            double lebar = 0;
            double tinggi = 0;
            double sisi1 = 0;
            double sisi2 = 0;
            double sisi3 = 0;
            double luasBgn = 0;
            double kelilingBgn = 0;
            switch (menuOpt) {
                case "1" :
                System.out.println("====Luas====");
                System.out.println("1. Persegi Panjang");
                System.out.println("2. Persegi");
                System.out.println("3. Segitiga");
                System.out.print("Bangun yang dipilih : ");
                bangunOpt = sc.nextLine();
                System.out.println("=============");
                    switch (bangunOpt) {
                        case "1":
                            System.out.print("Masukkan Panjang (cm) : ");
                            panjang = sc.nextDouble();
                            System.out.print("Masukkan Lebar (cm) : ");
                            lebar = sc.nextDouble();
                            luasBgn = luasPersegiPanjang(panjang, lebar);
                        break;
                        case "2":
                            System.out.print("Masukkan Panjang Sisi (cm) : ");
                            panjang = sc.nextDouble();
                            luasBgn = luasPersegi(panjang);
                        break;
                        case "3":
                            System.out.print("Masukkan Panjang Alas (cm) : ");
                            panjang = sc.nextDouble();
                            System.out.print("Masukkan Tinggi (cm) : ");
                            tinggi = sc.nextDouble();
                            luasBgn = luasSegitiga(panjang, tinggi);
                        break;
                        default:
                            System.out.println("Error");
                    }
                System.out.println("Luas Bangun : " + luasBgn);
                
                break;
                case "2" :
                System.out.println("====Keliling====");
                System.out.println("1. Persegi Panjang");
                System.out.println("2. Persegi");
                System.out.println("3. Segitiga");
                System.out.print("Bangun yang dipilih : ");
                bangunOpt = sc.nextLine();
                System.out.println("=============");
                    switch (bangunOpt) {
                        case "1":
                            System.out.print("Masukkan Panjang (cm) : ");
                            panjang = sc.nextDouble();
                            System.out.print("Masukkan Lebar (cm) : ");
                            lebar = sc.nextDouble();
                            kelilingBgn = kelilingPersegiPanjang(panjang, lebar);
                        break;
                        case "2":
                            System.out.print("Masukkan Panjang Sisi (cm) : ");
                            panjang = sc.nextDouble();
                            kelilingBgn = kelilingPersegi(panjang);
                        break;
                        case "3":
                            System.out.print("Masukkan Panjang Sisi 1 (cm) : ");
                            sisi1 = sc.nextDouble();
                            System.out.print("Masukkan Panjang Sisi 2 (cm) : ");
                            sisi2 = sc.nextDouble();
                            System.out.print("Masukkan Panjang Sisi 3 (cm) : ");
                            sisi3 = sc.nextDouble();
                            kelilingBgn = kelilingSegitiga(sisi1, sisi2, sisi3);
                        break;
                        default:
                            System.out.println("Error");
                    }
                System.out.println("Keliling Bangun : " + kelilingBgn);
                break;
                case "3" :
                    System.out.println("Bye Bye");
                return;
            }       
        }
    }
    public static double luasPersegi(double panjang) {
        double luas = panjang * panjang;
        return luas;
    }
    public static double luasPersegiPanjang(double panjang, double lebar) {
        double luas = panjang * lebar;
        return luas;
    }
    public static double luasSegitiga (double panjang, double tinggi) {
        double luas = 0.5 * panjang * tinggi;
        return luas;
    }
    public static double kelilingPersegi (double panjang) { 
        double keliling = 4 * panjang;
        return keliling;
    } 
    public static double kelilingPersegiPanjang (double panjang, double lebar) {
        double keliling = 2 * (panjang+lebar);
        return keliling;
    }
    public static double kelilingSegitiga (double sisi1, double sisi2, double sisi3) {
        double keliling = sisi1 + sisi2 + sisi3 ;
        return keliling;
    }
}

