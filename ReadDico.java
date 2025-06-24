import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class ReadDico {
    int binary = 1;
    int decimal = 2;
    int hexadecimal = 3;
    int octal = 4;
    int text = 5;

    public static void readDico(String caractere, int language) throws Exception {
        //selected language
        String lang = "";
        switch (language) {
            case 1:
                lang = "binary";
                break;
            case 2:
                lang = "decimal";
                break;
            case 3:
                lang = "hex";
                break;
            case 4:
                lang = "octal";
                break;
            case 5:
                lang = "text";
                break;
            default:
                System.out.println("Langue non prise en charge");
                return;
        }

        //read Dico.json file
        String content = new String(Files.readAllBytes(Paths.get("Dico.json")));
        String regex = "\"" + Pattern.quote(caractere) + "\"\\s*:\\s*\\{[^}]*\"" + lang + "\"\\s*:\\s*\"([^\"]+)\"";
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            String value = matcher.group(1);
            System.out.print(value);
        } else {
            System.out.println("Valeur non trouvée pour : " + caractere);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez une chaîne de caractères : ");
        String input = scanner.nextLine();
        for (char c : input.toCharArray()) {
            readDico(String.valueOf(c), 3);
        }
        scanner.close();
    }
}