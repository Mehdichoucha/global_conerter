import java.util.Scanner;

public class converter {

    // Start the main code
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            // Ask a sentence
            System.out.print("Write something : ");
            String text = scanner.nextLine();

            // Ask the language to translate
            System.out.println("1 = hexadecimal");
            System.out.println("2 = octal");
            System.out.println("3 = decimal");
            System.out.println("4 = binary");
            System.out.println("5 = text");

            System.out.print("Choose the language (1 to 5) : ");
            int language = scanner.nextInt();

            while (true){

                if (language == 1) {
                    System.out.println(text + " 1");
                }

                if (language == 2) {
                    System.out.println(text + " 2");
                }
                
                if (language == 3) {
                    System.out.println(text + " 3");
                }
                
                if (language == 4) {
                    System.out.println(text + " 4");
                }
                
                if (language == 5) {
                    System.out.println(text + " 5");
                }
            }
        }
    }
}