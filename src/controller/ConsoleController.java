package controller;

import fileManager.MyFile;
import fileManager.FileData;
import services.Decryptor;
import services.CesarCryptor;
import services.CesarBruteForceDecryptor;
import services.Cryptor;

import java.util.Scanner;

public class ConsoleController {

    public static final String APP_NAME = "CRYPTOR";
    public static final int SYMBOL_COUNT = 15;
    private final MyFile myFile = new FileData();
    private final Decryptor bruteForce = new CesarBruteForceDecryptor();
    private final Cryptor cryptor = new CesarCryptor();


    public void printMenu() {
        printHead();
        makeChoice();
    }

    private void makeChoice() {
        do {
            printMenuForSelection();
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (isExitChoice(choice)) break;

            callChoice(choice);
        } while (true);
    }


    private void callChoice(int choice) {
        switch (choice) {
            case 1 -> encryptText();
            case 2 -> decryptText();
            case 3 -> bruteForce();
            default -> printColoredText("Make correct choice", ConsoleColored.RED);
        }
    }

    private void encryptText() {
        String path = getPathToFile();
        int key = getKey();
        String textFromPath = myFile.getData(path);
        cryptor.encrypt(textFromPath, key, path);
    }

    private void decryptText() {
        String path = getPathToFile();
        int key = getKey();
        String textFromPath = myFile.getData(path);
        cryptor.decrypt(textFromPath, key, path);
    }

    private void bruteForce() {
        String path = getPathToFile();
        String textFromPath = myFile.getData(path);
        bruteForce.decryptBruteForce(textFromPath);
    }

    private String getPathToFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ConsoleColored.YELLOW + "Enter the absolute path to the file");
        return scanner.nextLine();
    }

    private int getKey() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ConsoleColored.YELLOW + "Enter key");
        return scanner.nextInt();
    }

    private void printHead() {
        printStartApp();
        System.out.println(ConsoleColored.CYAN_BOLD + "\t\t" + APP_NAME + ConsoleColored.RESET);
        printStartApp();
    }

    private boolean isExitChoice(int choice) {
        if (choice == 0) {
            printColoredText("Goodbye see you", ConsoleColored.BLUE_BOLD);
            return true;
        }
        return false;
    }

    private void printMenuForSelection() {
        System.out.println();
        printColoredText("Make your choice", ConsoleColored.YELLOW_BOLD);
        printColoredText("\t1: Encrypt file", ConsoleColored.GREEN);
        printColoredText("\t2: Decrypt file", ConsoleColored.GREEN);
        printColoredText("\t3: Brute Force", ConsoleColored.GREEN);
        System.out.println();
        printColoredText("\t0: Exit", ConsoleColored.BLUE_BOLD);
    }

    private void printStartApp() {
        try {
            for (int i = 0; i < SYMBOL_COUNT; i++) {
                Thread.sleep(200);
                System.out.print(ConsoleColored.CYAN + "\uD83C\uDFC3\u200D");
            }
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void printColoredText(String text, String color) {
        System.out.println(color + text + ConsoleColored.RESET);
    }
}
