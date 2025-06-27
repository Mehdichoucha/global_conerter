import java.util.Scanner;

public class ReadInput {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez une chaîne de caractères : ");
        String input = scanner.nextLine();
        System.out.print("Entrez une langue (1: binaire, 2: décimal, 3: hexadécimal, 4: octal) : ");
        int choice = scanner.nextInt();
        if (choice == 1){
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                TraductorBinary.readDicoBinary(String.valueOf(c));
            }
        }
        if (choice == 2){
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                TraductorDecimal.readDicoDecimal(String.valueOf(c));
            }
        }
        if (choice == 3){
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                TraductorHexa.readDicoHexa(String.valueOf(c));
            }
        }
        if (choice == 4){
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                TraductorOctal.readDicoOctal(String.valueOf(c));
            }
        }
        scanner.close();
    }
}