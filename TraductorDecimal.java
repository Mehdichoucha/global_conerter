import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TraductorDecimal implements TraductorStrategy {
    @Override
    public void readDico(String caractere) throws Exception {
        String content = DicoSingleton.getInstance().getContent();
        String regex = "\"" + Pattern.quote(caractere) + "\"\\s*:\\s*\\{[^}]*\"decimal\"\\s*:\\s*\"([^\"]+)\"";
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            String value = matcher.group(1);
            System.out.print(value);
        } else {
            System.out.println("Valeur non trouvée pour : " + caractere);
        }
    }

    @Override
    public void readDicoInverse(String decimalValue) throws Exception {
        String content = DicoSingleton.getInstance().getContent();
        String regex = "\"([^\"]+)\"\\s*:\\s*\\{[^}]*\"decimal\"\\s*:\\s*\"" + Pattern.quote(decimalValue) + "\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            String caractere = matcher.group(1);
            System.out.print(caractere);
        } else {
            System.out.println("Caractère non trouvé pour : " + decimalValue);
        }
    }
}