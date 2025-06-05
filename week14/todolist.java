package week14;
import java.sql.SQLOutput;
import java.util.*;
abstract class Person {
    private String nama;
    private int umur;

    public Person(String nama, int umur){
        this.nama = nama;
        this.umur = umur;
    }

    public String getNama(){
        return nama;
    }

    public int getUmur(){
        return umur;
    }

    public abstract void perkenalan();
}

class Student extends Person{
    private String npm;
    public Student(String nama, int umur, String npm){
        super(nama, umur);
        this.npm = npm;
    }

    public String getNpm(){
        return npm;
    }

    @Override
    public void perkenalan(){
        System.out.println("Name : " + getNama() + "\nAge : " + getUmur());
        System.out.println("NPM  : " + getNpm());
        System.out.println("Role : Student");
    }
}

class Teacher extends Person{
    private String npd;
    public Teacher(String nama, int umur, String npd){
        super(nama, umur);
        this.npd = npd;
    }

    public String getNpd() {return npd;}

    public void perkenalan(){
        System.out.println("Name : " + getNama() + "\nAge : " + getUmur());
        System.out.println("NPM  : " + getNpd());
        System.out.println("Role : Teacher");
    }
}

public class todolist {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Person> listofPeople = new ArrayList<>();

    public static void main(String[] args) {
        inputStudent();
        outputResult();
    }

    public static void inputStudent(){
        boolean loop = true;
        while(loop){
            String role = roleChecker();
            if(role.equals("Student")){
                System.out.println("Hello Student !");
                System.out.print("Name : ");
                String tempNama = sc.nextLine();
                System.out.print("Age  : ");
                int tempUmur = Integer.parseInt(sc.nextLine());
                System.out.print("NPM  : ");
                String tempNpm = sc.nextLine();
                Person p = new Student(tempNama,tempUmur,tempNpm);
                listofPeople.add(p);
            } else if (role.equals("Teacher")){
                System.out.println("Hello Teacher !");
                System.out.print("Name : ");
                String tempNama = sc.nextLine();
                System.out.print("Age  : ");
                int tempUmur = Integer.parseInt(sc.nextLine());
                System.out.print("NPD  : ");
                String tempNpd = sc.nextLine();
                Person p = new Teacher(tempNama,tempUmur,tempNpd);
                listofPeople.add(p);
            }


            while (true){
                System.out.println("Add another person ? (Y/n)");
                String opt = sc.nextLine();
                if(opt.equalsIgnoreCase("Y")){
                    break;
                }
                else if (opt.equalsIgnoreCase("n")){
                    loop = false;
                    break;
                }else {
                    System.out.println("Error input. Try Again !");
                }
            }
        }

    }
    public static void outputResult(){
        System.out.println("\n ==== List of Peoples ====");
        for(Person p : listofPeople){
            p.perkenalan();
            System.out.println("---------------------");
        }
    }

    public static String roleChecker(){
        String tempRole = "";
        while (true){
            System.out.print("Are you a student or a teacher ? (S / T)");
            String inputStatus = sc.nextLine();
            String tempStatus = inputStatus.trim();
            if (tempStatus.equalsIgnoreCase("S")){
                tempRole = "Student";
                break;
            }
            else if(tempStatus.equalsIgnoreCase("T")){
                tempRole = "Teacher";
                break;
            }
            else {
                System.out.println("Try again");
            }
        }
        return tempRole;
    }
}
