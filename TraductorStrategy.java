public interface TraductorStrategy {
    void readDico(String caractere) throws Exception;
    void readDicoInverse(String value) throws Exception;
}