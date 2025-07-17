package services;

import java.util.HashMap;
import java.util.Map;

public class CesarBruteForceDecryptor implements Decryptor {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz.,\':-!? ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Override
    public void decryptBruteForce(String textFromPath) {
        char[] chars = textFromPath.toCharArray();
        Map<Integer, String> has = new HashMap<>();
        int key = 0;
        for (int i = 0; i < ALPHABET.length() -1; i++) {
            key++;
            String allKeyText = returnStringKey(chars,key);
            has.put(ALPHABET.length() - key, allKeyText);
        }
        printOptions(has);
    }

    private String returnStringKey (char [] chars, int key) {
        String allKeyText = "";
        for (char aChar : chars) {
            if (ALPHABET.indexOf(aChar) != -1) {
                char a = ALPHABET.charAt((ALPHABET.indexOf(aChar) + key) % ALPHABET.length());
                allKeyText = (allKeyText) + a;
            } else {
               allKeyText += aChar;
            }
        }
        return allKeyText;
    }

    private void printOptions(Map<Integer, String> options) {
        for (Map.Entry<Integer, String> entry : options.entrySet()) {
            String value = entry.getValue();
            if (value.contains(" ")) {
                String[] valueByWord = entry.getValue().split(" ");
                if (isLengthWord(valueByWord) && (!value.endsWith(" ") && !value.startsWith(" ") && !value.startsWith(":") && !value.startsWith("-"))) {
                        System.out.println("Key: " + entry.getKey() + "\t" + entry.getValue());
                }
            }
        }
    }

    private boolean isLengthWord(String[] allText) {
        String letter = "";
        for (String str : allText) {
            letter = str;
            if (letter.length() > 24 || isLetter(str)) {
            }
        }
        return true;
    }

    private boolean isLetter(String word) {
        for (int i = 1; i < word.length() - 1; i++) {
            if (word.charAt(i) == ':' || word.charAt(i) == '!' || word.charAt(i) == '?')
                return true;
        }
        return false;
    }
}

