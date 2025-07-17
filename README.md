### J-Cesar Cryptor

**J-Cesar Cryptor** is a simple encryption/decryption tool built using Java. It implements the classic Caesar cipher algorithm with support for both direct key-based decryption and brute-force decryption. The project simulates a basic file-based encryption engine and showcases how to apply custom logic for encoding/decoding based on character shifting.

<img width="301" height="240" alt="SCR-20250717-rqjk" src="https://github.com/user-attachments/assets/ef088990-8297-4280-8bc4-8308e53e84c4" />


### Description

The application provides functionality to:

* Encrypt a text file using a key and save the result in-place
* Decrypt an encrypted file using a known key
* Brute-force decrypt a file without knowing the key by iterating over all possible Caesar cipher shifts (alphabet rotations)
* The cipher operates on a custom alphabet that contains exactly 60 characters: 26 lowercase letters, 26 uppercase letters of the English alphabet, 1 space character, and 7 basic punctuation marks (., ,, :, -, !, ?, ').
* This configuration allows the encryption and decryption of texts that include standard English letters, whitespace, and common punctuation.

> **Note**: According to Wikipedia, the longest valid word in most natural languages does not exceed 24 characters, so this value is used to filter improbable results during brute-force.

### How It Works

* **Encrypt/Decrypt:**

  * Accepts an input file (`text.txt` in project root)
  * Applies character shift based on Caesar cipher and updates the same file with the result
* **Brute Force:**

  * Tries all shifts from 1 to `alphabet.length`
  * Does **not** modify the file — only displays the most probable decryption result in the console

### Example Flow

* Developer places input text into `text.txt`
* Runs encryption with a key (e.g., 5)
* File content is encrypted and overwritten
* To decrypt, runs decryption with the same key — original content restored
* If key is unknown, runs brute-force mode

  * Console displays potential outputs with likely decrypted text
  * User manually verifies and uses the suggested key for final decryption
 <img width="788" height="721" alt="SCR-20250717-rmkx" src="https://github.com/user-attachments/assets/fe340afd-1cc6-4a75-9277-3fc0614ecbf2" />


### Technologies Used

* Java 17+
* OOP
* Map
* Java I/O (FileReader, FileWriter)
* Custom character arrays for alphabet

### What I Learned From This Project

* Implementing classic cryptographic algorithms from scratch
* Working with file I/O and mutable content updates
* Designing interface-based architecture for pluggable cipher strategies
* Using modularity and separation of concerns for maintainable code
