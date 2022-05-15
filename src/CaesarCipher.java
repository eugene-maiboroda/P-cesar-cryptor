import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class CaesarCipher {

    private static final String ALPHABET_LOWER_CASE = "abcdefghijklmnopqrstuvwxyz.,\"\":-!? ";
    private static final String ALPHABET_UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWSYZ.,\"\":-!? ";

    public CaesarCipher() {
    }

    public static void encrypt(String pathToFile, int key) {
        if (key > 0) {
            try (FileReader reader = new FileReader(pathToFile);
                 FileWriter writer = new FileWriter(String.valueOf(Files.createFile(Path.of("C:\\Users\\JEKA\\IdeaProjects\\Cryptographic calculator\\EncryptedText"))))) {

                while (reader.ready()) {
                    char reaOneSymbol = (char) reader.read();
                    writer.write(encryptSymbolRightShift(reaOneSymbol, key));
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        } else {
            System.out.println("Error");
        }
    }
    static char encryptSymbolRightShift (char symbol, int shift) {
        if (ALPHABET_UPPER_CASE.indexOf(symbol) != -1 && Character.isUpperCase(symbol)) {
            return ALPHABET_UPPER_CASE.charAt((ALPHABET_UPPER_CASE.indexOf(symbol) + shift) % ALPHABET_UPPER_CASE.length());

        } else if (ALPHABET_LOWER_CASE.indexOf(symbol) != -1 && Character.isLowerCase(symbol)) {
            return ALPHABET_LOWER_CASE.charAt((ALPHABET_LOWER_CASE.indexOf(symbol) + shift) % ALPHABET_LOWER_CASE.length());

        } else {
            return symbol;
        }
    }
}
