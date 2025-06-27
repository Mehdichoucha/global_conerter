import java.util.Scanner;

public class ReadInput {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Choisissez le sens de traduction (1: texte vers code, 2: code vers texte, 0: quitter) : ");
            int mode = scanner.nextInt();
            scanner.nextLine(); 

            if (mode == 0) {
                System.out.println("Au revoir !");
                break;
            }

            if (mode == 1) {
                System.out.print("Entrez une chaîne de caractères : ");
                String input = scanner.nextLine();
                System.out.print("Entrez une langue (1: binaire, 2: décimal, 3: hexadécimal, 4: octal) : ");
                int choice = scanner.nextInt();
                scanner.nextLine(); 
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
                System.out.println(); // retour à la ligne après la traduction
            } else if (mode == 2) {
                System.out.print("Entrez le code à traduire (séparez chaque valeur par un espace) : ");
                String input = scanner.nextLine();
                System.out.print("Entrez le type de code (1: binaire, 2: décimal, 3: hexadécimal, 4: octal) : ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consomme le retour à la ligne
                String[] codes = input.split("\\s+");
                if (choice == 1){
                    for (String code : codes) {
                        TraductorBinary.readDicoInverse(code);
                    }
                }
                if (choice == 2){
                    for (String code : codes) {
                        TraductorDecimal.readDicoInverse(code);
                    }
                }
                if (choice == 3){
                    for (String code : codes) {
                        TraductorHexa.readDicoInverse(code);
                    }
                }
                if (choice == 4){
                    for (String code : codes) {
                        TraductorOctal.readDicoInverse(code);
                    }
                }
                System.out.println(); // retour à la ligne après la traduction
            } else {
                System.out.println("Choix invalide.");
            }
        }
        scanner.close();
    }
}