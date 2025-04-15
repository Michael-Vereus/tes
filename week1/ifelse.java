package week1;

import java.util.Scanner;

public class ifelse {
    public static void main(String[]args){
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in) ;
        System.out.println("Masukkan Umur "); 
        int umur = sc.nextInt() ;
        if(umur <= 18){
            System.out.println("Anda tidak boleh mengakses data ini");
        }
        else {
            System.out.println("Anda boleh mengakses data ini");
            System.out.println("Lorem ipsum");
        }
    }
}
