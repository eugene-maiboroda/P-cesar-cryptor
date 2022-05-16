import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class CaesarCipher {

    private static final String ALPHABET_LOWER_CASE = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\"\":-!? ";
    private static final String ALPHABET_UPPER_CASE = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ.,\"\":-!? ";

    public CaesarCipher() {
    }

    public static void encrypt(String pathToFile, int key) {
        if (key > 0) {
            try (FileReader reader = new FileReader(pathToFile);
                 FileWriter writer = new FileWriter(String.valueOf(Files.createFile(Path.of("C:\\Users\\JEKA\\IdeaProjects\\Cryptographic calculator\\Encrypted_file"))))) {

                while (reader.ready()) {
                    char readOneSymbol = (char) reader.read();
                    writer.write(encryptSymbolRightShift(readOneSymbol, key));
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        } else {
            System.out.println("Error - key must be greater than zero");
        }
    }

    public static void decrypt (String pathToFile, int key) {
        if (key > 0) {
            try (FileReader reader = new FileReader(pathToFile)) {
//                 FileWriter writer = new FileWriter(String.valueOf(Files.createFile(Path.of("C:\\Users\\JEKA\\IdeaProjects\\Cryptographic calculator\\Decrypted_file"))))) {

                while (reader.ready()) {
                    char readOneSymbol = (char) reader.read();
//                    writer.write(decryptSymbolRightShift(readOneSymbol, key));
                    System.out.print(decryptSymbolRightShift(readOneSymbol,key));
                }
//
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error - key must be greater than zero");
        }

    }

    static char encryptSymbolRightShift (char symbol, int shift) {
        if (ALPHABET_UPPER_CASE.indexOf(symbol) != -1 && Character.isUpperCase(symbol)) {
            return ALPHABET_UPPER_CASE.charAt((ALPHABET_UPPER_CASE.indexOf(symbol) + shift) % ALPHABET_UPPER_CASE.length());

        } else if (ALPHABET_LOWER_CASE.indexOf(symbol) != -1 && !Character.isUpperCase(symbol)) {
            return ALPHABET_LOWER_CASE.charAt((ALPHABET_LOWER_CASE.indexOf(symbol) + shift) % ALPHABET_LOWER_CASE.length());

        } else {
            return symbol;
        }
    }
    static char decryptSymbolRightShift (char symbol, int shift) {
        if (ALPHABET_UPPER_CASE.indexOf(symbol) != -1 && Character.isUpperCase(symbol)) {
            return ALPHABET_UPPER_CASE.charAt((ALPHABET_UPPER_CASE.indexOf(symbol) - shift + ALPHABET_UPPER_CASE.length()) % ALPHABET_UPPER_CASE.length());

        } else if (ALPHABET_LOWER_CASE.indexOf(symbol) != -1 && !Character.isUpperCase(symbol)) {
            return ALPHABET_LOWER_CASE.charAt((ALPHABET_LOWER_CASE.indexOf(symbol) - shift + ALPHABET_LOWER_CASE.length()) % ALPHABET_LOWER_CASE.length());

        } else {
            return symbol;
        }
    }
}
