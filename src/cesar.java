import java.util.Scanner;

public class cesar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Write something: ");
        String text = scanner.nextLine();

        System.out.print("Write a number for the key: ");
        int key = scanner.nextInt();

        System.out.println("Original text: " + text);
        System.out.println("Encrypted text: " + encrypt(text, key));

        scanner.close();
    }

    public static String encrypt(String text, int key) {
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (Character.isLowerCase(c)) {
                char shifted = (char) ((c - 'a' + key + 26) % 26 + 'a');
                encryptedText.append(shifted);
            } else if (Character.isUpperCase(c)) {
                char shifted = (char) ((c - 'A' + key + 26) % 26 + 'A');
                encryptedText.append(shifted);
            } else if (Character.isDigit(c)) {
                char shifted = (char) ((c - '0' + key + 10) % 10 + '0');
                encryptedText.append(shifted);
            } else {
                encryptedText.append(c);
            }
        }
        return encryptedText.toString();
    }
}
