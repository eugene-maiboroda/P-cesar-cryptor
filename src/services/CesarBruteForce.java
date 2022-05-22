package services;

import java.util.HashMap;
import java.util.Map;

public class CesarBruteForce implements BruteForce {

    private static final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\':-!? АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

    @Override
    public void decryptBruteForce(String incomingFilePath, String path) {
        char[] chars = incomingFilePath.toCharArray();
        Map<Integer, String> has = new HashMap<>();
        int key = 0;
        for (int i = 0; i < 73; i++) {
            String allKeyText = "";
            key++;
            for (char aChar : chars) {
                if (ALPHABET.indexOf(aChar) != -1) {
                    char a = ALPHABET.charAt((ALPHABET.indexOf(aChar) + key) % ALPHABET.length());
                    allKeyText = (allKeyText) + a;
                } else {
                    allKeyText += aChar;
                }
            }
//            Записываем все возможные варианты в Мапу
            has.put(74 - key, allKeyText);
        }
        printOptions(has);
    }

    private void printOptions(Map<Integer, String> options) {
        for (Map.Entry<Integer, String> entry : options.entrySet()) {
            String value = entry.getValue();
            if (value.contains(" ")) {
                String[] valueByWord = entry.getValue().split(" ");
                if (isLengthWord(valueByWord)) {
                    if (!value.endsWith(" ") && !value.startsWith(" ") && !value.startsWith(":") && !value.startsWith("-"))
                        System.out.println("Key: " + entry.getKey() + "\t" + entry.getValue());
                }
            }
        }
    }

    private boolean isLetter(String word) {
        for (int i = 1; i < word.length() - 1; i++) {
            if (word.charAt(i) == ':' || word.charAt(i) == '!')
                return true;
        }
        return false;
    }

    private boolean isLengthWord(String[] allText) {
        String letter = "";
        for (String str : allText) {
            letter = str;
            if (letter.length() > 24 || isLetter(str)) { //Википедия говорит что самое большое слово состоит из 24 букв, по этому такое условие.
                return false;
            }
        }
        return true;
    }
}

