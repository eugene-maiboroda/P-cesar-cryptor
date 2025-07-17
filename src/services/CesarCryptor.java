package services;

import fileManager.FileData;

public class CesarCryptor implements Cryptor {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz.,\':-!? ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    FileData fileData = new FileData();

    public void encrypt(String textFromPath, int key, String path) {
        char[] chars = textFromPath.toCharArray();
        char[] copyChars = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (ALPHABET.indexOf(chars[i]) != -1) {
                copyChars[i] = ALPHABET.charAt((ALPHABET.indexOf(chars[i]) + key) % ALPHABET.length());
            } else {
                copyChars[i] = chars[i];
            }
        }
        fileData.writeFile(new String(copyChars), key, path);

    }

    public void decrypt(String textFromPath, int key, String path) {
       encrypt(textFromPath, ALPHABET.length()-key, path);
    }
}
