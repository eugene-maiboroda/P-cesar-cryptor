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
            String str = "";
            key++;
            for (int j = 0; j <chars.length; j++) {
                if (ALPHABET.indexOf(chars[j]) != -1) {
                   char a =  ALPHABET.charAt((ALPHABET.indexOf(chars[j]) + key) % ALPHABET.length());
                   str = (str) + a;
                } else {
                    str += chars[j];
                }
            }
            has.put(74- key,str);
        }
        printOptions(has);
    }
    public void printOptions(Map <Integer, String> options) {
        for (Map.Entry <Integer,String> entry : options.entrySet()) {
            String value = entry.getValue();
            boolean upperFirstLetter = Character.isUpperCase(value.charAt(0));
            boolean lowerLastLetter = Character.isLowerCase(value.charAt(value.length()-1));
            if (value.contains(" ")) {
                if (!value.endsWith(" ") && !value.startsWith(" ") && upperFirstLetter)
                    System.out.println("Key: " + entry.getKey() + "\t" + entry.getValue());
//            } else if (!value.endsWith(" ") && !value.startsWith(" ") && upperFirstLetter && lowerLastLetter) {
//                System.out.println("Key: " + entry.getKey() + "\t" + entry.getValue());
            }
        }
    }
}
