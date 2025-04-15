package week1;

public class pyramidnormal {
    public static void main(String[]args){
        int baris = 10 ;
        int d = baris ;
        for (int i = 1; i <= baris;i++){
           for (int j = 1; j <= d;j++){
                System.out.print(" ");
           }
           d = d-1;
           for(int a = 1; a <= i;a++){
                System.out.print("* ");
           }
           System.out.println();
        }
    }
}
