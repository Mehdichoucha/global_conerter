import java.util.Scanner;

public class converter {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            // Ask a sentence
            System.out.print("Write something : ");
            String text = scanner.nextLine();

            // Ask the language to translate
            System.out.println("h = hexadecimal");
            System.out.println("o = octal");
            System.out.println("d = decimal");
            System.out.println("b = binary");
            System.out.println("t = text");

            String language = "";

            while (true) {
                System.out.print("Choose the language (h/o/d/b/t) : ");
                language = scanner.nextLine().toLowerCase();

                if (language.equals("h")) {
                    System.out.println(text + " 1");
                    break;
                }

                if (language.equals("o")) {
                    System.out.println(text + " 2");
                    break;
                }

                if (language.equals("d")) {
                    System.out.println(text + " 3");
                    break;
                }

                if (language.equals("b")) {
                    System.out.println(text + " 4");
                    break;
                }

                if (language.equals("t")) {
                    System.out.println(text + " 5");
                    break;
                }
            }
        }
    }
}
