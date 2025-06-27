import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TraductorHexa extends ReadInput{ //a comme parent class ReadDico
    public static void readDicoHexa(String caractere) throws Exception {
        //read Dico.json file
        String content = new String(Files.readAllBytes(Paths.get("Dico.json")));
        String regex = "\"" + Pattern.quote(caractere) + "\"\\s*:\\s*\\{[^}]*\"hex\"\\s*:\\s*\"([^\"]+)\"";
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            String value = matcher.group(1);
            System.out.print(value);
        } else {
            System.out.println("Valeur non trouvée pour : " + caractere);
        }
    }

    public static void readDicoInverse(String hexValue) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get("Dico.json")));
        String regex = "\"([^\"]+)\"\\s*:\\s*\\{[^}]*\"hex\"\\s*:\\s*\"" + Pattern.quote(hexValue) + "\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            String caractere = matcher.group(1);
            System.out.print(caractere);
        } else {
            System.out.println("Caractère non trouvé pour : " + hexValue);
        }
    }
}