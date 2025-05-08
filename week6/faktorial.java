package week6;
import java.util.*;
public class faktorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        System.out.println("Masukkan Angka");
        try {
            n = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        int nsimpan = n;
        int nkali = n-1;
        for(int i = 1;i<n;i++){
            nsimpan = nsimpan*nkali;
            nkali = nkali - 1;
        }
        System.out.println(nsimpan);
    }   
}
