package services;

import fileManager.FileData;

public class CesarCipher implements Cryptor {

    private static final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\':-!? АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    FileData fileData = new FileData();

    public String encrypt(String incomingFilePath, int key, String path) {
        char[] chars = incomingFilePath.toCharArray();
        char[] copyChars = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (ALPHABET.indexOf(chars[i]) != -1) {
                copyChars[i] = ALPHABET.charAt((ALPHABET.indexOf(chars[i]) + key) % ALPHABET.length());
            } else {
                copyChars[i] = chars[i];
            }
        }
        fileData.writeFile(new String(copyChars), key, path);
        return incomingFilePath;
    }

    public String decrypt(String incomingFilePath, int key, String path) {
        return encrypt(incomingFilePath, 74-key, path);
    }
}
