package edu.grinnell.csc207.main;

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

    String cipherType = args[0];
    String option = args[1];
    String text = args[2];
    String key = args[THIRD_ARGUMENT];

    // Further validation for cipher types and options
    if (!cipherType.equals("caesar") && !cipherType.equals("vigenere")) {
      System.err.println("Error: Invalid cipher type.");
      return;
    } //if(cipherType)

    if (!option.equals("encode") && !option.equals("decode")) {
      System.err.println("Error: Invalid option: \"" + option + "\"."
                        + "Valid options are \"encode\" or \"decode\".");
      return;
    } //if(option)

    if (!text.matches("[a-z]+")) {
      System.err.println("Error: String contains characters other than lowercase letters.");
      return;
    } //if(text)

    // Perform encryption/decryption based on the cipher type
    String result = "";
    if (cipherType.equals("caesar")) {
      char keyLetter = key.charAt(0);
      result = option.equals("encode")
          ? CipherUtils.caesarEncrypt(text, keyLetter)
          : CipherUtils.caesarDecrypt(text, keyLetter);
    } else if (cipherType.equals("vigenere")) {
      result = option.equals("encode")
          ? CipherUtils.vigenereEncrypt(text, key)
          : CipherUtils.vigenereDecrypt(text, key);
    } //if(cipherType)

    System.out.println(result);
  } // End main(String[])
} // End Cipher
