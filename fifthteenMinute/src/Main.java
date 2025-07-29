import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> listOfSentences = new ArrayList<>();
    public static void main(String[] args) {
        boolean running = true;
        while(running){
            menu();
            String menuOpt = sc.nextLine().trim();
            switch (menuOpt){
                case "1" :
                    System.out.print("type any sentence : ");
                    String sentence = sc.nextLine();
                    listOfSentences.add(sentence);
                break;
                case "2" :
                    showSentences();
                break;
                case "3" :
                    showCountWordsResult();
                break;
                case "4" :
                    showLongestSentence();
                break;
                case "0" :
                    System.out.println("BYE BYE !");
                    running = false;
                break;
                default:
                    System.out.println("Invalid choice");
            }
            pause();
        }
    }
    public static void menu(){
        System.out.println("\nMenu:");
        System.out.println("1. Add a Sentence");
        System.out.println("2. See all of sentences");
        System.out.println("3. Count the words in a sentences");
        System.out.println("4. Show sentences with most words");
        System.out.println("0. Exit");
        System.out.print("Choose menu: ");
    }
    public static int countWords(String sentence) {
        if (sentence.trim().isEmpty()) return 0;
        String[] word = sentence.trim().split("\\s+");
        return word.length;
    }

    // Method mencari kalimat dengan jumlah kata terbanyak
    public static String findLongestSentence(ArrayList<String> listOfSentences) {
        String result = "";
        int sumMax = 0;
        for (String k : listOfSentences) {
            int sum = countWords(k);
            if (sum > sumMax) {
                sumMax = sum;
                result = k;
            }
        }
        return result;
    }
    public static void pause(){
        System.out.println("Press Enter To Continue : ");
        String ctn = sc.nextLine();
    }
    public static void showSentences(){
        if (listOfSentences.isEmpty()) {
            System.out.println("No Sentences yet");
        }
        else {
            System.out.println("\nList Of Sentences");
            for (int i = 0; i < listOfSentences.size(); i++) {
                System.out.println((i + 1) + ". " + listOfSentences.get(i));
            }
        }
    }
    public static void showCountWordsResult(){
        if (listOfSentences.isEmpty()) {
            System.out.println("There aren't any sentence yet.");
        }
        else {
            showSentences();
            System.out.print("Choose the number of sentence: ");
            int index = Integer.parseInt(sc.nextLine()) - 1;
            if (index >= 0 && index < listOfSentences.size()) {
                int jumlahKata = countWords(listOfSentences.get(index));
                System.out.println("Total words in this sentence is : " + jumlahKata);
            } else {
                System.out.println("invalid number.");
            }
        }
    }
    public static void showLongestSentence(){
        if (listOfSentences.isEmpty()) {
            System.out.println("There aren't any sentences yet");
        } else {
            String longestSentence = findLongestSentence(listOfSentences);
            System.out.println("Sentence with most words :");
            System.out.println("\"" + longestSentence + "\"");
            System.out.println("Word in total : " + countWords(longestSentence));
        }
    }

}