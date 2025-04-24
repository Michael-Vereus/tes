import java.util.*;
public class keliling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Pilih bentuk apa yang ingin anda hitung keliling bangunnya");
        System.out.println("1. Lingkaran");
        System.out.println("2. Persegi Panjang");
        System.out.println("3. Segitiga");
        int bangun = 0 ;
        try {
            bangun = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        switch (bangun) {
            case 1:
                System.out.println("Masukkan diameter lingkaran dalam bentuk cm");
                float d = sc.nextFloat();
                float phi = 22/7 ;
                float kelilingl = phi * d ;
                System.out.println("Keliling Lingkaran " + kelilingl + " cm");
                break;
            case 2:
                System.out.println("Masukkan panjang persegi panjang dalam bentuk cm");
                float p = sc.nextFloat();
                System.out.println("Masukkan lebar persegi panjang dalam bentuk cm");
                float l = sc.nextFloat();
                float kelilingp = 2*(p + l) ;
                System.out.println("Keliing Persegi Panjang " + kelilingp + " cm");
                break;
            case 3:
                System.out.println("Masukkan sisi a segitiga dalam bentuk cm");
                float a = sc.nextFloat();
                System.out.println("Masukkan sisi b segitiga dalam bentuk cm");
                float b = sc.nextFloat();
                System.out.println("Masukkan sisi c segitiga dalam bentuk cm");
                float c = sc.nextFloat();
                float kelilings = a + b + c ;
                System.out.println("Keliling Segitiga " + kelilings + " cm");
                break;
            default:
                System.out.println("Error tidak ada banngun tsb di aplikasi ini");
        }
    }
}

