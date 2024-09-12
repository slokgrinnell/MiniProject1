package edu.grinnell.csc207.util;

/**
 * Utility class for Caesar and Vigenère cipher operations.
 */
public class CipherUtils {
  // In CipherUtils.java.
/**
 * Number of letters in the alphabet.
 */
  private static final int NUM_LETTERS = 26;

  // +--------------+-------------------------------------------------
  // | Caesar Cipher Methods |
  // +--------------+

  /**
   * Encrypts a string using the Caesar Cipher.
   *
   * @param str the string to encrypt
   * @param letter the key letter
   * @return encrypted string
   */
  public static String caesarEncrypt(String str, char letter) {
    int keyVal = letter2int(letter);
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < str.length(); i++) {
      int strChar = letter2int(str.charAt(i));
      int encryptedChar = (strChar + keyVal) % NUM_LETTERS;
      result.append(int2letter(encryptedChar));
    } // End for loop
    return result.toString();
  } // End caesarEncrypt(String, char)

  /**
   * Decrypts a string using the Caesar Cipher.
   *
   * @param str the string to decrypt
   * @param letter the key letter
   * @return decrypted string
   */
  public static String caesarDecrypt(String str, char letter) {
    int keyVal = letter2int(letter);
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < str.length(); i++) {
      int strChar = letter2int(str.charAt(i));
      int decryptedChar = (strChar - keyVal + NUM_LETTERS) % NUM_LETTERS;
      result.append(int2letter(decryptedChar));
    } // End of for loop
    return result.toString();
  } // End caesarDecrypt(String, char)

  // +--------------+-------------------------------------------------
  // | Vigenère Cipher Methods |
  // +--------------+

  /**
   * Encrypts a string using the Vigenère Cipher.
   *
   * @param str the string to encrypt
   * @param key the key string
   * @return encrypted string
   */
  public static String vigenereEncrypt(String str, String key) {
    StringBuilder result = new StringBuilder();
    int keyLength = key.length();

    for (int i = 0; i < str.length(); i++) {
      int strChar = letter2int(str.charAt(i));
      int keyChar = letter2int(key.charAt(i % keyLength));
      int encryptedChar = (strChar + keyChar) % NUM_LETTERS;
      result.append(int2letter(encryptedChar));
    } // End for loop
    return result.toString();
  } // End vigenereEncrypt(String, String)

  /**
   * Decrypts a string using the Vigenère Cipher.
   *
   * @param str the string to decrypt
   * @param key the key string
   * @return decrypted string
   */
  public static String vigenereDecrypt(String str, String key) {
    StringBuilder result = new StringBuilder();
    int keyLength = key.length();

    for (int i = 0; i < str.length(); i++) {
      int strChar = letter2int(str.charAt(i));
      int keyChar = letter2int(key.charAt(i % keyLength));
      int decryptedChar = (strChar - keyChar + NUM_LETTERS) % NUM_LETTERS;
      result.append(int2letter(decryptedChar));
    } // End for loop
    return result.toString();
  } // End vigenereDecrypt(String, String)

  // +--------------+-------------------------------------------------
  // | Utility Methods |
  // +--------------+

  /**
   * Converts a letter to its corresponding integer value.
   *
   * @param letter the letter to convert
   * @return integer value corresponding to the letter
   */
  private static int letter2int(char letter) {
    return letter - 'a';
  } // End letter2int(char)

  /**
   * Converts an integer value to its corresponding letter.
   *
   * @param number the integer to convert
   * @return letter corresponding to the integer value
   */
  private static char int2letter(int number) {
    return (char) ('a' + number);
  } // End int2letter(int)
} // End CipherUtils
