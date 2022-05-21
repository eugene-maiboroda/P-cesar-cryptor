package services;

public interface Cryptor {

    String encrypt (String incomingFilePath, int key, String path);
    String decrypt (String incomingFilePath, int key, String path);


}
