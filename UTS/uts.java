package UTS;
import java.util.*;
public class uts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nomor Satu");
        for(int j = 1; j < 5; j++){
            int num = 0;
            if(j % 2 == 0){
                num = 4;
                System.out.print(" ");
                for (int i = 1; i < num; i++) {
                    if(i % 2 == 1){
                        System.out.print("*");
                    }
                    else{
                        System.out.print("  ");
                    }
                }
            }
            else{
                num = 7;
                for (int i = 1; i < num; i++) {
                if(i % 2 == 1){
                    System.out.print("*");
                }
                else{
                    System.out.print("  ");
                }
                }
            }
        System.out.println("");
        }
    }
}
