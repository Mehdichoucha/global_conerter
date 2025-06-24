import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadDico {
    int binary = 1;
    int decimal = 2;
    int hexadecimal = 3;
    int octal = 4;
    int text = 5;

    public static void readDico(String caractere) throws Exception {
        
        String content = new String(Files.readAllBytes(Paths.get("Dico.json")));
        String regex = "\"" + Pattern.quote(caractere) + "\"\\s*:\\s*\\{[^}]*\"binary\"\\s*:\\s*\"([01]+)\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            String binary = matcher.group(1);
            System.out.print(binary + " ");
        } else {
            System.out.println("Valeur non trouvée pour : " + caractere);
        }
    }

    public static void readDicoInverse(String binaryValue) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get("Dico.json")));
        String regex = "\"([^\"]+)\"\\s*:\\s*\\{[^}]*\"binary\"\\s*:\\s*\"" + Pattern.quote(binaryValue) + "\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            String caractere = matcher.group(1);
            System.out.print(caractere);
        } else {
            System.out.println("Caractère non trouvé pour : " + binaryValue);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choisissez le sens de conversion (1: texte -> binaire, 2: binaire -> texte) : ");
        int choix = scanner.nextInt();
        scanner.nextLine(); 

        if (choix == 1) {
            System.out.print("Entrez une chaîne de caractères : ");
            String input = scanner.nextLine();
            for (char c : input.toCharArray()) {
                readDico(String.valueOf(c));
            }
        } else if (choix == 2) {
            System.out.print("Entrez une chaîne binaire (séparée par des espaces) : ");
            String input = scanner.nextLine();
            String[] binaries = input.split("\\s+");
            for (String binary : binaries) {
                readDicoInverse(binary);
            }
        } else {
            System.out.println("Choix invalide.");
        }
        scanner.close();
    }
}