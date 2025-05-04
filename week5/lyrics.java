package week5;

public class lyrics {
    public static void main(String[] args) {
        String text = "Forget about where we are and let go, we're  so close       ";
        typeWriter(text,150);
        String text2 = "If you don't know where to start Just Hold on and Don't run, no     ";
        typeWriter(text2, 150);
        String text3 = "We're looking back, we mess around, But that was then and this is now     ";
        typeWriter(text3, 100);
        String text4 = "All we need is enough love to hold us..... Where we are";
        typeWriter(text4, 100);
    }

    public static void typeWriter(String text, int delayMillis) {
        for (char ch : text.toCharArray()) {
            System.out.print(ch);
            try {
                Thread.sleep(delayMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(); // for newline after typing
    }
}
