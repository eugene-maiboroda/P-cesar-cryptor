import fileManager.Controller.ConsoleController;
import fileManager.File;
import services.CaesarCipher;
import services.CesarBruteForce;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {


    public static void main(String[] args) {

        ConsoleController controller = new ConsoleController();
        controller.printMenu();
    }
}

