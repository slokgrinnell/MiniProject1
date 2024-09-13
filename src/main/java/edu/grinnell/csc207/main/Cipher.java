package edu.grinnell.csc207.main;

import java.io.PrintWriter;

import edu.grinnell.csc207.util.CipherUtils;

/**
 * Main class for running both Caesar and Vigenère Ciphers.
 * Supports both encoding and decoding based on input.
 * Author: Slok Rajbhandari
 */
public class Cipher {

  // In Cipher.java
  /**
   * Expected number of command-line arguments.
   */
  private static final int EXPECTED_ARGS = 4;

  /**
   * Expected number of third arguments.
   */
  private static final int THIRD_ARGUMENT = 3;

  /**
   * Main method to execute the Caesar or Vigenère cipher.
   *
   * @param args command-line arguments for encoding/decoding
   */
  public static void main(String[] args) {
    // Input validation
    if (args.length != EXPECTED_ARGS) {
      System.err.println("Error: Incorrect number of parameters.");
      return;
    } //if (args)

    // Determine cipher type and operation, regardless of order
    String cipherType = "";
    String option = "";
    String text = "";
    String key = "";

    for (String arg : args) {
      if (arg.equals("-caesar") || arg.equals("-vigenere")) {
        cipherType = arg;
      } else if (arg.equals("-encode") || arg.equals("-decode")) {
        option = arg;
      } else if (text.isEmpty()) {
        text = arg;  // First element that is not -caeser or -encode / -decode
      } else {
        key = arg;  // Second element argument is the key
      }
    } //for

    // Validate cipher type
    if (cipherType.isEmpty() || (!cipherType.equals("-caesar") && !cipherType.equals("-vigenere"))) {
      System.err.println("Error: Invalid cipher type.");
      return;
    }

    // Validate operation type
    if (option.isEmpty() || (!option.equals("-encode") && !option.equals("-decode"))) {
      System.err.println("Error: Invalid option: \"" + option + "\"."
                         + "Valid options are \"encode\" or \"decode\".");
      return;
    }

    // Validate the input text
    if (!text.matches("[a-z]+")) {
      System.err.println("Error: String contains characters other than lowercase letters.");
      return;
    }

    // Validate Caesar cipher key: it must be a single lowercase letter
    if (cipherType.equals("-caesar")) {
      if (key.length() != 1 || !key.matches("[a-z]")) {
        System.err.println("Error: Caesar cipher key must be a single lowercase letter.");
        return;
      }
    }

    // Validate Vigenère cipher key: it must only contain lowercase letters
    if (cipherType.equals("-vigenere")) {
      if (!key.matches("[a-z]+")) {
        System.err.println("Error: Vigenère cipher key must contain only lowercase letters.");
        return;
      }
    }

    // Perform encryption/decryption based on the cipher type
    String result = "";
    PrintWriter output = new PrintWriter(System.out, true);
    
    if (cipherType.equals("-caesar")) {
      char keyLetter = key.charAt(0);
      result = option.equals("-encode")
          ? CipherUtils.caesarEncrypt(text, keyLetter)
          : CipherUtils.caesarDecrypt(text, keyLetter);
    } else if (cipherType.equals("-vigenere")) {
      result = option.equals("-encode")
          ? CipherUtils.vigenereEncrypt(text, key)
          : CipherUtils.vigenereDecrypt(text, key);
    }

    output.println(result);
  } // End main(String[])
} // End Cipher
