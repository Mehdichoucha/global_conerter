import java.util.Scanner;

public class ReadInput {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Choisissez le sens de traduction (1: texte vers code, 2: code vers texte, 3: chiffrement Cesar, 0: quitter) : ");
            int mode = scanner.nextInt();
            scanner.nextLine(); // vide le buffer

            if (mode == 0) {
                System.out.println("Au revoir !");
                break;
            }

            TraductorStrategy traductor = null;

            if (mode == 1) {
                System.out.print("Entrez une chaine de caracteres : ");
                String input = scanner.nextLine();
                System.out.print("Entrez une langue (1: binaire, 2: decimal, 3: hexadecimal, 4: octal) : ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        traductor = new TraductorBinary();
                        break;
                    case 2:
                        traductor = new TraductorDecimal();
                        break;
                    case 3:
                        traductor = new TraductorHexa();
                        break;
                    case 4:
                        traductor = new TraductorOctal();
                        break;
                    default:
                        System.out.println("Choix invalide.");
                        continue;
                }

                for (int i = 0; i < input.length(); i++) {
                    char c = input.charAt(i);
                    traductor.readDico(String.valueOf(c));
                }
                System.out.println();
            } else if (mode == 2) {
                System.out.print("Entrez le code a traduire (separez chaque valeur par un espace) : ");
                String input = scanner.nextLine();
                String[] codes = input.split("\\s+");

                for (String code : codes) {
                    if (code.matches("[01]{8}")) { // 8 bits binaire
                        traductor = new TraductorBinary();
                    } else if (code.matches("\\d{1,3}")) { // decimal (0-255)
                        traductor = new TraductorDecimal();
                    } else if (code.matches("[0-9A-Fa-f]{2}")) { // hexa (2 chiffres/lettres)
                        traductor = new TraductorHexa();
                    } else if (code.matches("[0-7]{3}")) { // octal (3 chiffres)
                        traductor = new TraductorOctal();
                    } else {
                        System.out.print("?");
                        continue;
                    }
                    traductor.readDicoInverse(code);
                }
                System.out.println();
            } else if (mode == 3) {
                System.out.print("Entrez le texte a chiffrer : ");
                String texte = scanner.nextLine();
                System.out.print("Entrez le decalage (cle) : ");
                String keyString = scanner.nextLine();
                int key = Integer.parseInt(keyString.trim());

                String encrypted = Cesar.encrypt(texte, key);
                System.out.println("Texte chiffre : " + encrypted);
            } else {
                System.out.println("Choix invalide.");
            }
        }
        scanner.close();
    }
}
