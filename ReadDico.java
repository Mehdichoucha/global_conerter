import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class ReadDico {

    public static void readDico(String caractere) throws Exception {
        //read Dico.json file
        String content = new String(Files.readAllBytes(Paths.get("Dico.json")));
        String regex = "\"" + Pattern.quote(caractere) + "\"\\s*:\\s*\\{[^}]*\"binary\"\\s*:\\s*\"([01]+)\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            String binary = matcher.group(1);
            System.out.print(binary);
        } else {
            System.out.println("Valeur non trouvée pour : " + caractere);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez une chaîne de caractères : ");
        String input = scanner.nextLine();
        for (char c : input.toCharArray()) {
            readDico(String.valueOf(c));
        }
        scanner.close();
    }
}