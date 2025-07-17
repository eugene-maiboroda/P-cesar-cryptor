package services;

public interface Cryptor {

    void encrypt (String textFromPath, int key, String path);
    void decrypt (String textFromPath, int key, String path);


}
