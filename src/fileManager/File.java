package fileManager;

public interface File {

    String getData (String incomingFilePath);
    void writeFile (String incomingFilePath, int key, String path);
    }

