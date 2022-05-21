package fileManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileData implements File {

    @Override
    public String getData(String incomingFilePath) {
        byte[] dataBytes = new byte[0];
        try {
            dataBytes = Files.readAllBytes(Path.of(incomingFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(dataBytes);
    }

    @Override
    public void writeFile(String incomingFilePath, int key, String path) {
        try {
            Files.write(Path.of(path), incomingFilePath.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
