package week1;

public class circlegagal {
    public static void main(String[]args){
        int baris1 = 5 ;
        int kolom1 = 4 ;
        int klm1 = kolom1 ;
        int klm2 = klm1 ;
        int brs1 = baris1 ;
        for(int i = 1; i <= brs1;i++){
            for(int j = 1;j <= klm1 ;j++){
                System.out.print(" ");
            }
            for(int k = 1;k <= klm2;k++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
