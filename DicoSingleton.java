import java.nio.file.Files;
import java.nio.file.Paths;

public class DicoSingleton {
    private static DicoSingleton instance;
    private String content;

    private DicoSingleton() throws Exception {
        content = new String(Files.readAllBytes(Paths.get("Dico.json")));
    }

    public static DicoSingleton getInstance() throws Exception {
        if (instance == null) {
            instance = new DicoSingleton();
        }
        return instance;
    }

    public String getContent() {
        return content;
    }
}